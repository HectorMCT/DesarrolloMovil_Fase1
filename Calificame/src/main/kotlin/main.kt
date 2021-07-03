import model.*
import utils.Utils

fun main() {
    val universities : MutableSet<University> = mutableSetOf()
    val professors : MutableSet<Professor> = mutableSetOf()
    val signatures : MutableSet<Signature> = mutableSetOf()
    val users : MutableSet<User> = mutableSetOf(User("Anónimo", ""))
    menuLogin(universities, professors, signatures, users)
}


/*              Login Menu and Functions              */
fun menuLogin(universities: MutableSet<University>,
              professors: MutableSet<Professor>,
              signatures: MutableSet<Signature>,
              users: MutableSet<User>) {

    var opc: Int
    do{
        Utils.printHeader()
        println("1. Ingresar")
        println("2. Registrarse")
        println("3. Ingresar anonimamente")
        println("0. Salir")
        opc = Utils.validRangeValue(0,3, "Digita una opción [0, 3]: " )
        when (opc) {
            1 -> {
                val user = userSignIn(users)
                if (user != null){
                    println("Login exitoso")
                    menuPricipal(universities, professors, signatures, user)
                }else
                    println("Intentalo nuevamente o registrate")
            }
            2 -> {
                val user = userSignUp(users)
                if (user != null) {
                    users.add(user)
                    println("Registro exitoso")
                    menuPricipal(universities, professors, signatures, user)
                }
            }
            3 -> menuPricipal(universities, professors, signatures, users.elementAt(0))
        }
    }while(opc != 0)
}

/*              Menú principal              */
fun menuPricipal(universities: MutableSet<University>,
                 professors: MutableSet<Professor>,
                 signatures: MutableSet<Signature>,
                 user: User) {

    var opc : Int
    do {
        Utils.printHeader(user)
        println("1. Agregar universidad")
        println("2. Eliminar universidad")
        println("3. Agregar profesor")
        println("4. Eliminar profesor")
        println("5. Agregar materia")
        println("6. Eliminar materia")
        println("7. Ver lista de universidades")
        println("8. Seleccionar universidad")
        println("0. Cerrar sesión")
        opc = Utils.validRangeValue(0,8, "Digita una opción [0, 8]: " )
        when(opc){
            1 -> addUniveristy(universities)
            2 -> removeUniversity(universities)
            3 -> addProfessor(professors)
            4 -> removeProfessor(professors)
            5 -> addSignature(signatures)
            6 -> removeSignature(signatures)
            7 -> Utils.printUniversities(universities)
            8 -> {
                val university = getUniversity(universities)
                if (university != null) menuUniversidad(university, professors, signatures, user)
            }
        }
    }while (opc != 0)
}

/*              Menú Universidad           */
fun menuUniversidad(university: University,
                    professors: MutableSet<Professor>,
                    signatures: MutableSet<Signature>,
                    user: User) {

    var opc : Int
    do{
        Utils.printHeader(user)
        println("Universidad: ${university.name}")
        println("1. Agregar facultad")
        println("2. Eliminar facultad")
        println("3. Ver lista de facultades")
        println("4. Seleccionar facultad")
        println("0. Regresar")
        opc = Utils.validRangeValue(0,4, "Digita una opción [0, 4]: " )
        when (opc) {
            1 -> addFacultyTo(university)
            2 -> removeFacultyOf(university)
            3 -> Utils.printFaculties(university)
            4 -> {
                val faculty = getFaculty(university)
                if (faculty != null) menuFacultad(university, faculty, professors, signatures, user)
            }
        }
    }while(opc != 0)
}

/*              Menú Facultad           */
fun menuFacultad(university : University,
                 faculty : Faculty,
                 professors: MutableSet<Professor>,
                 signatures: MutableSet<Signature>,
                 user: User){

    fun professor(func : (faculty: Faculty, professor: Professor) -> Any){
        val prof = getProfessor(professors)
        if (prof != null) func(faculty, prof)
    }
    var opc: Int
    do{
        Utils.printHeader(user)
        println("Universidad: ${university.name}")
        println("Facultad: ${faculty.name}")
        println("1. Ver lista de profesores de la facultad")
        println("2. Añadir profesor a la facultad")
        println("3. Eliminar profesor de la facultad")
        println("4. Seleccionar profesor de la facultad")
        println("0. Regresar")
        opc = Utils.validRangeValue(0,4, "Digita una opción [0, 4]: " )
        when (opc) {
            1 -> Utils.printProfessors(faculty.getProfessors())
            2 -> professor(::addProfessorTo)
            3 -> professor(::removeProfessorOf)
            4 -> {
                val professor = getProfessor(faculty.getProfessors())
                if (professor != null) menuProfesor(university, faculty, professor, signatures, user)
            }
        }
    }while(opc != 0)
}

/*              Menú Profesor           */
fun menuProfesor(university : University,
                 faculty : Faculty,
                 professor : Professor,
                 signatures: MutableSet<Signature>,
                 user: User) {
    /*              Menú para añadir reviews y/o stats           */
    fun menuAddReviewStatsTo(stats: ProfessorStats, signature: Signature) {
        var opc: Int
        do {
            Utils.printHeader(user)
            println("Universidad: ${university.name}")
            println("Facultad: ${faculty.name}")
            println("Profesor: ${professor.name}")
            println("Materia: ${signature.name}")
            println("1. Añadir Stats")
            println("2. Añadir review")
            println("0. Regresar")
            opc = Utils.validRangeValue(0,2, "Digita una opción [0, 2]: " )
            when (opc) {
                1 -> addStatsTo(stats, signature)
                2 -> addReviewTo(stats, signature, user)
            }
        }while(opc != 0)
    }

    var opc: Int
    do{
        Utils.printHeader(user)
        println("Universidad: ${university.name}")
        println("Facultad: ${faculty.name}")
        println("Profesor: ${professor.name}")
        println(faculty.getProfessorStat(professor)!!)
        println("1. Ver lista de materias del profesor")
        println("2. Añadir stats/review de materia al profesor(a)")
        println("3. Seleccionar materia del profesor(a) para ver reviews y stats")
        println("0. Regresar")
        opc = Utils.validRangeValue(0,3, "Digita una opción [0, 3]: " )
        when (opc) {
            1 -> Utils.printSignatures(faculty.getProfessorStat(professor)!!.getSignatures())
            2 -> {
                val signature = getSignature(signatures)
                if (signature != null) menuAddReviewStatsTo(faculty.getProfessorStat(professor)!!, signature)
            }
            3 -> {
                val signature = getSignature(faculty.getProfessorStat(professor)!!.getSignatures())
                if (signature != null) {
                    Utils.printSignatureStats(faculty.getProfessorStat(professor)!!.getStatsOf(signature) ?: listOf())
                    Utils.printSignatureReviews(faculty.getProfessorStat(professor)!!.getReviewsOf(signature) ?: listOf())
                }
            }
        }
    }while(opc != 0)
}

/*               Sing in Function           */
fun userSignIn(users: MutableSet<User>) : User? {
    var username : String
    println("Ingresa 0 para regresar")
    print("Ingresa tu username: ")
    do {
        username = readLine()!!
        when (username){
            "0" -> return null
            else -> {
                if (!Utils.existUsernameIn(users, username)) {
                    println("El nombre de usuario $username no existe, puedes intentar corregirlo o registrate")
                    print("Ingresa otro nombre de usuario o 0 para regresar: ")
                } else break
            }
        }
    }while(true)
    print("Ingresa tu contraseña: ")
    val password: String = readLine()!!

    val user = users.find { it.username == username && it.password == password }
    if (user != null) println("Contraseña incorrecta!")
    return user
}

/*               Sing up Function           */
fun userSignUp(users : MutableSet<User>) : User? {
    var username : String
    println("Ingresa 0 para regresar")
    print("Ingresa tu nuevo username: ")
    do {
        username = readLine()!!
        when (username){
            "0" -> return null
            else -> {
                if (Utils.existUsernameIn(users, username)) {
                    println("El nombre de usuario $username ya existe, puedes intentar iniciando sesión")
                    print("Ingresa otro nombre de usuario o 0 para regresar: ")
                } else break
            }
        }
    }while(true)
    print("Ingresa tu contraseña: ")
    val password: String = readLine()!!
    return User(username, password)
}

/*              Add Functions               */
fun addUniveristy(universities : MutableSet<University>) {
    print("Ingresa el nombre de la universidad: ")
    val university : String = readLine()!!

    if (universities.add(University(university)))
        println("La universidad se añadio exitosamente")
    else
        println("Ya existe registro de esta universidad")
}

fun addProfessor(professors : MutableSet<Professor>) {
    print("Ingresa el nombre del profesor(a): ")
    val professor : String = readLine()!!

    if (professors.add(Professor(professor)))
        println("El profesor se añadio exitosamente")
    else
        println("Ya existe registro de esta profesor(a)")
}

fun addSignature(signatures : MutableSet<Signature>) {
    print("Ingresa su nombre de la materia: ")
    val signature : String = readLine()!!

    if (signatures.add(Signature(signature)))
        println("La materia se añadio exitosamente")
    else
        println("Ya existe registro de esta materia")
}

fun addFacultyTo(university : University ) {
    print("Ingresa el nombre de la facultad: ")
    val faculty : String = readLine()!!

    if (university.addFaculty(Faculty(faculty)))
        println("La materia se añadio exitosamente")
    else
        println("Ya existe registro de esta materia")

}

fun addProfessorTo(faculty : Faculty, professor : Professor) {
    if (faculty.addProfessor(professor) == null)
        println("Profesor añadirdo correctamente")
    else
        println("Ya existe registro de este profesor en la facultad")
}

fun addReviewTo(professorStats: ProfessorStats, signature: Signature, user: User) {
    print("Ingresa tu comentario: ")
    val comment = readLine()!!
    val sat = Utils.validRangeValue(0.0, 100.0, "Ingresa tu satisfacción [0 - 100]: ")
    professorStats.addReviewTo(signature, Review(user , comment, sat))
}

fun addStatsTo(professorStats: ProfessorStats, signature: Signature){
    val facility = Utils.validRangeValue(0.0, 100.0, "Ingresa su facilidad [0 - 100]: ")
    val clarity = Utils.validRangeValue(0.0, 100.0, "Ingresa su claridad [0 - 100]: ")
    val recommendation = Utils.validRangeValue(0.0, 100.0, "Ingresa tu recomendación [0 - 100]: ")
    val domain = Utils.validRangeValue(0.0, 100.0, "Ingresa su dominio [0 - 100]: ")
    val complexity = Utils.validRangeValue(0.0, 100.0, "Ingresa la complejidad [0 - 100]: ")
    val fairEvaluation = Utils.validRangeValue(0.0, 100.0, "Que tan justo es al evaluar [0 - 100]: ")
    val applyExams = Utils.validRangeValue(0.0, 100.0, "Aplica examenes [0 - 100]: ")
    val examsCount = Utils.validRangeValue(0, Int.MAX_VALUE, "¿Cuántos examenes? [0 - ${Int.MAX_VALUE}]: ")
    professorStats.addStatsTo(signature, SignatureStats(facility, clarity, recommendation, domain, complexity, fairEvaluation, applyExams, examsCount))
}

/*              Remove Functions               */
fun removeUniversity(universities : MutableSet<University>) {
    val university = getUniversity(universities)
    if (university != null)
        if (universities.remove(university))
            println("Universidad eliminada correctamente")
        else
            println("No se puedo eliminar la universidad solicitada")
}
fun removeProfessor(professors: MutableSet<Professor>) {
    val professor = getProfessor(professors)
    if (professor != null)
        if (professors.remove(professor))
            println("Profesor(a) eliminado correctamente")
        else
            println("No se puedo eliminar el profesor(a) solicitado")
}

fun removeSignature(signatures: MutableSet<Signature>) {
    val signature = getSignature(signatures)
    if (signature != null)
        if (signatures.remove(signature))
            println("Materia eliminado correctamente")
        else
            println("No se puedo eliminar la materia solicitada, intentalo nuevamente")
}


fun removeFacultyOf(university: University) {
    val faculty = getFaculty(university)
    if (faculty != null)
        if (university.removeFaculty(faculty))
            println("Facultad eliminada correctamente")
        else
            println("No se puedo eliminar la facultas solicitada")
}

fun removeProfessorOf(faculty: Faculty, professor: Professor) {
    if (faculty.removeProfessor(professor) != null)
        println("Profesor eliminado correctamente")
    else
        println("No se puedo eliminar el profesor solicitado")
}


/*          Getter Functions           */
fun getUniversity(universities: Set<University>) : University? {
    if (universities.isNotEmpty()) {
        Utils.printUniversities(universities)
        return when (val ind = Utils.validRangeValue(0, universities.size, "Ingresa el índice de la universidad (0 para regresar): ")) {
            0 -> null
            in 1..universities.size -> universities.elementAt(ind - 1)
            else -> Utils.menuFail("Rango invalido")
        }
    }
    println("No hay universidades registradas")
    return null
}

fun getFaculty(university : University) : Faculty? {
    if (university.getFaculties().isNotEmpty()) {
        Utils.printFaculties(university)
        return when (val ind = Utils.validRangeValue(0, university.getFaculties().size, "Ingresa el índice de la facultad (0 para regresar): ")) {
            0 -> null
            in 1..university.getFaculties().size -> university.getFaculties().elementAt(ind - 1)
            else -> Utils.menuFail("Rango invalido")
        }
    }
    println("No hay facultades registradas")
    return null
}

fun getProfessor(professors: Set<Professor>) : Professor? {
    if (professors.isNotEmpty()) {
        Utils.printProfessors(professors)
        return when (val ind = Utils.validRangeValue(0, professors.size, "Ingresa el índice de la profesor (0 para regresar): ")) {
            0 -> null
            in 1..professors.size -> professors.elementAt(ind - 1)
            else -> Utils.menuFail("Rango invalido")
        }
    }
    println("No hay profesores registrados")
    return null
}

fun getSignature(signatures: Set<Signature>) : Signature? {
    if (signatures.isNotEmpty()) {
        Utils.printSignatures(signatures)
        return when (val ind = Utils.validRangeValue(0,signatures.size, "Ingresa el índice de la materia (0 para regresar): ")){
            0 -> null
            in 1..signatures.size -> signatures.elementAt(ind - 1)
            else -> Utils.menuFail("Rango invalido")
        }
    }
    println("No hay materias registradas")
    return null
}