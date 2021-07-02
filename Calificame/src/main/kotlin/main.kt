import model.*
import utils.Utils

//Variables globales
val universities : MutableSet<University> = mutableSetOf()
val professors : MutableSet<Professor> = mutableSetOf()
val signatures : MutableSet<Signature> = mutableSetOf()
val users : MutableSet<User> = mutableSetOf(User("Anónimo", ""))
var currentUser = users.elementAt(0)

fun main() {
    menuLogin(users)
}


/*              Login Menu and Functions              */
fun menuLogin(users: MutableSet<User>) {
    var opc: Int
    do{
        println("||-----------------App Califícame!----------------||")
        println("1. Ingresar")
        println("2. Registrarse")
        println("3. Ingresar anonimamente")
        println("0. Salir")
        opc = Utils.validRangeValue(0,3, "Digita una opción [0, 3]: " )
        when (opc) {
            1 -> {
                val auxUser = userSignIn(users)
                if (auxUser != null){
                    currentUser = auxUser
                    println("Login exitoso")
                    menuPricipal(universities, professors, signatures)
                }else{
                    println("Tu contraseña fue incorrecta, intentalo nuevamente o registrate nuevamente")
                }
            }
            2 -> {
                val auxUser = userSignUp(users)
                if (auxUser != null) {
                    users.add(auxUser)
                    currentUser = auxUser
                    println("Registro exitoso")
                    menuPricipal(universities, professors, signatures)
                }
            }
            3 -> menuPricipal(universities, professors, signatures)
        }
        currentUser = users.elementAt(0)
    }while(opc != 0)
}

/*              Menú principal              */
fun menuPricipal(universities: MutableSet<University>,
                 professors: MutableSet<Professor>,
                 signatures: MutableSet<Signature>){
    var opc : Int
    do {
        println("||-- Usuario: ${currentUser.username} --||")
        println("||-----------------App Califícame!----------------||")
        println("1. Agregar universidad")
        println("2. Eliminar universidad")
        println("3. Agregar profesor")
        println("*. Eliminar profesor")
        println("4. Agregar materia")
        println("*. Eliminar materia")
        println("5. Ver lista de universidades")
        println("6. Seleccionar universidad")
        println("0. Regresar")
        opc = Utils.validRangeValue(0,6, "Digita una opción [0, 6]: " )
        when(opc){
            1 -> addUniveristy(universities)
            2 -> {
                val uni = getUniversity(universities)
                if (uni != null) removeUniversity(universities, uni)
            }
            3 -> addProfessor(professors)
            4 -> addSignature(signatures)
            5 -> Utils.printUniversities(universities)
            6 -> {
                val uni = getUniversity(universities)
                if (uni != null) menuUniversidad(uni)
            }
        }
    }while (opc != 0)
}

/*              Menú Universidad           */
fun menuUniversidad(university: University){

    fun faculties(func : (university: University, faculty: Faculty) -> Any){
        val faculty = getFaculty(university)
        if (faculty != null) func(university, faculty)
    }

    var opc : Int
    do{
        println("||-- Usuario: ${currentUser.username} --||")
        println("||-----------------App Califícame!----------------||")
        println("Universidad: ${university.name}")
        println("1. Agregar facultad")
        println("2. Eliminar facultad")
        println("3. Ver lista de facultades")
        println("4. Seleccionar facultad")
        println("0. Regresar")
        opc = Utils.validRangeValue(0,6, "Digita una opción [0, 4]: " )
        when (opc) {
            1 -> addFacultyTo(university)
            2 -> faculties(::removeFacultyOf)
            3 -> Utils.printFaculties(university)
            4 -> faculties(::menuFacultad)
        }
    }while(opc != 0)
}

fun menuFacultad(university : University, faculty : Faculty){

    fun professor(func : (faculty: Faculty, professor: Professor) -> Any){
        val prof = getProfessor(professors)
        if (prof != null) func(faculty, prof)
    }

    var opc: Int
    do{
        println("||-- Usuario: ${currentUser.username} --||")
        println("||-----------------App Califícame!----------------||")
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
            2 -> professor(::addProfessorToFaculty)
            3 -> professor(::removeProfessorOf)
            4 -> {
                val prof = getProfessor(faculty.getProfessors())
                if (prof != null) menuProfesor(university, faculty, prof)
            }
        }
    }while(opc != 0)
}

fun menuProfesor(university : University, faculty : Faculty, professor : Professor) {
    fun menuAddReviewStatsTo(stats: ProfessorStats, signature: Signature) {
        var opc: Int
        do {
            println("||-- Usuario: ${currentUser.username} --||")
            println("||-----------------App Califícame!----------------||")
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
                2 -> addReviewTo(stats, signature)
            }
        }while(opc != 0)
    }

    var opc: Int
    do{
        println("||-- Usuario: ${currentUser.username} --||")
        println("||-----------------App Califícame!----------------||")
        println("Universidad: ${university.name}")
        println("Facultad: ${faculty.name}")
        println("Profesor: ${professor.name}")
        println(faculty.getProfessorStat(professor)!!.generalStats())
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

fun addProfessorToFaculty(faculty : Faculty, professor : Professor) {
    if (faculty.addProfessor(professor) == null)
        println("Profesor añadirdo correctamente")
    else
        println("Ya existe registro de este profesor en la facultad")
}

fun addReviewTo(professorStats: ProfessorStats, signature: Signature) {
    print("Ingresa tu comentario: ")
    val comment = readLine()!!
    val sat = Utils.validRangeValue(0.0, 100.0, "Ingresa tu satisfacción [0 - 100]: ")
    professorStats.addReviewTo(signature, Review(currentUser , comment, sat))
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

    return users.find { it.username == username && it.password == password }
}

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

/*              Remove Functions               */
fun removeUniversity(universities : MutableSet<University>, university: University) {
    if (universities.remove(university))
        println("Universidad eliminada correctamente")
    else
        println("No se puedo eliminar la universidad solicitada")
}
fun removeFacultyOf(university: University, faculty: Faculty) {
    if (university.removeFaculty(faculty))
        println("Facultad eliminada correctamente")
    else{
        println("No se puedo eliminar la facultas solicitada")
    }
}
fun removeProfessorOf(faculty: Faculty, professor: Professor) {
    if (faculty.removeProfessor(professor) != null)
        println("Profesor eliminado correctamente")
    else
        println("No se puedo eliminar el profesor solicitado")
}


/*          Getters           */
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