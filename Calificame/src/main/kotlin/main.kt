import model.*
import utils.Utils

//Variables globales
val universities : MutableSet<University> = mutableSetOf()
val professors : MutableSet<Professor> = mutableSetOf()
val signatures : MutableSet<Signature> = mutableSetOf()
val usuarios : MutableSet<User> = mutableSetOf()

fun main(){
    menuPricipal(universities, professors, signatures)
}
//Menu fail function
fun menuFail(message : String) : Nothing = throw Exception(message)

/*              Login Menu and Functions              */
fun menuLogin(users : MutableSet<User>){
    var opc : Int? = null
    do{
        try {
            println("App Califícame!")
            println("1. Ingresar")
            println("2. Registrarme")
            println("0. Salir")
            print("Digita una opción: ")
            opc = readLine()!!.toInt()
            when (opc) {
                in 0..2 -> {
                    when (opc) {
                        1 -> validateUser(users)
                        2 -> addUser(users)
                    }
                }
                else -> menuFail("Rango invalido")
            }
        }catch (e : Exception) {
            System.err.println("Error: ${e.message}. Rango valido [0, 2]")
        }
    }while(opc != 0)
}


/*              Principal Menu and Functions              */
fun menuPricipal(universities: MutableSet<University>,
                 professors: MutableSet<Professor>,
                 signatures: MutableSet<Signature>){
    var opc : Int? = null
    do{
        try {
            println("||------------------------||")
            println("App Califícame!")
            println("1. Agregar universidad")
            println("2. Agregar profesor")
            println("3. Agregar materia")
            println("4. Ver lista de universidades")
            println("5. Seleccionar universidad")
            println("0. Salir")
            print("Digita una opción: ")
            opc = readLine()!!.toInt()
            when (opc) {
                in 0..5 -> {
                    when (opc) {
                        1 -> addUniveristy(universities)
                        2 -> addProfessor(professors)
                        3 -> addSignature(signatures)
                        4 -> Utils.printUniversities(universities)
                        5 -> {
                            val uni = getUniversity(universities)
                            if (uni != null) menuUniversidad(uni, universities)
                        }
                    }
                }
                else -> menuFail("Rango invalido")
            }
        }catch (e : Exception) {
            System.err.println("Error: ${e.message}. Rango valido [0, 5]")
        }
    }while(opc != 0)
}

/*              University Menu and Functions           */
fun menuUniversidad(university: University, universities: MutableSet<University>){
    var opc : Int? = null
    do{
        try {
            println("||------------------------||")
            println("App Califícame!")
            println("Universidad: ${university.name}")
            println("1. Agregar facultad")
            println("2. Eliminar universidad")
            println("3. Ver lista de facultades")
            println("4. Seleccionar facultad")
            println("0. Regresar")
            print("Digita una opción: ")
            opc = readLine()!!.toInt()
            when (opc) {
                in 0..4 -> {
                    when (opc) {
                        1 -> addFaculty(university)
                        2 -> {
                            removeUniversity(universities, university)
                            opc = 0
                        }
                        3 -> Utils.printFaculties(university)
                        4 -> {
                            val fac = getFaculty(university)
                            if (fac != null) menuFacultad(university, fac)
                        }
                    }
                }
                else -> menuFail("Rango invalido")
            }
        }catch (e : Exception) {
            System.err.println("Error: ${e.message}. Rango valido [0, 5]")
        }
    }while(opc != 0)
}

fun menuFacultad(university : University, faculty : Faculty){
    var opc : Int? = null
    do{
        try {
            println("||------------------------||")
            println("App Califícame!")
            println("Universidad: ${university.name}")
            println("Facultad: ${faculty.name}")
            println("1. Ver lista de profesores")
            println("2. Seleccionar profesor")
            println("3. Añadir profesor")
            println("0. Regresar")
            print("Digita una opción: ")
            opc = readLine()!!.toInt()
            when (opc) {
                in 0..2 -> {
                    when (opc) {
                        1 -> Utils.printProfessors(faculty.getProfessors().toSet())
                        2 -> {
                            val prof = getProfessor(faculty.getProfessors().toSet())
                            if (prof != null) menuProfesor(university, faculty, prof)
                        }
                        3 -> {
                            val prof = getProfessor(professors)

                        }
                    }
                }
                else -> menuFail("Rango invalido")
            }
        }catch (e : Exception) {
            System.err.println("Error: ${e.message}. Rango valido [0, 5]")
        }
    }while(opc != 0)
}

fun menuProfesor(university : University, faculty : Faculty, professor : Professor){
    var opc : Int? = null
    do{
        try {
            println("||------------------------||")
            println("App Califícame!")
            println("Universidad: ${university.name}")
            println("Facultad: ${faculty.name}")
            println("Profesor: ${professor.name}")
            println("1. Ver lista de materias")
            println("2. Agregar materia")
            println("0. Regresar")
            print("Digita una opción: ")
            opc = readLine()!!.toInt()
            when (opc) {
                in 0..2 -> {
                    when (opc) {
                        1 -> Utils.printSignatures(faculty.getProfessorStat(professor))
                        2 ->
                            //val prof = getProfessor(faculty.getProfessors().toSet())
                            //if (prof != null) menuProfesor(university, faculty, prof)
                    }
                }
                else -> menuFail("Rango invalido")
            }
        }catch (e : Exception) {
            System.err.println("Error: ${e.message}. Rango valido [0, 2]")
        }
    }while(opc != 0)
}



/*              Add Functions               */
fun addUniveristy(universities : MutableSet<University>) {
    val university : String
    print("Ingresa el nombre de la universidad: ")
    university = readLine()!!

    if (universities.add(University(university)))
        println("La universidad se añadio exitosamente")
    else
        println("Ya existe registro de esta universidad")
}

fun addProfessor(professors : MutableSet<Professor>) {
    val professor : String
    print("Ingresa el nombre del profesor(a): ")
    professor = readLine()!!

    if (professors.add(Professor(professor)))
        println("El profesor se añadio exitosamente")
    else
        println("Ya existe registro de esta profesor(a)")
}

fun addSignature(signatures : MutableSet<Signature>) {
    val signature : String
    print("Ingresa su nombre de la materia: ")
    signature = readLine()!!

    if (signatures.add(Signature(signature)))
        println("La materia se añadio exitosamente")
    else
        println("Ya existe registro de esta materia")
}

fun addFaculty(university : University ) {
    val faculty : String
    print("Ingresa el nombre de la facultad: ")
    faculty = readLine()!!

    if (university.addFaculty(Faculty(faculty)))
        println("La materia se añadio exitosamente")
    else
        println("Ya existe registro de esta materia")

}

fun addProfessorToFaculty(faculty : Faculty, professor : Professor) = faculty.addProfessor(professor)

fun addUser(users : MutableSet<User>) {

    print("Nombre: ")
    val name : String = readLine()!!

    print("Apellido: ")
    val lastName : String = readLine()!!

    println("Correo: ")
    val email : String = readLine()!!

    print("Username: ")
    val username : String = readLine()!!

    print("Password: ")
    val password : String = readLine()!!

    if (users.add(User(name, lastName, email, username, password)))
        println("Se registró exitosamente")
    else
        println("Ya existe el usuario")
}

fun validateUser(users : MutableSet<User>) {

    print("Username: ")
    val username : String = readLine()!!

    print("Password: ")
    val password : String = readLine()!!

    if (users.any { it.username == username && it.password == password })
        println("Bienvenido")
    else
        println("El usuario no existe!")
}

/*              Remove Functions               */
fun removeUniversity(universities : MutableSet<University>, university: University) = universities.remove(university)


/*          Getters           */
fun getUniversity(universities: Set<University>) : University? {
    if (universities.isNotEmpty()) {
        var ind : Int? = null
        do {
            try{
                Utils.printUniversities(universities)
                println("Ingresa 0 para regresar")
                print("Ingresa el índice de la universidad: ")
                ind = readLine()!!.toInt()
                return when (ind) {
                    0 -> null
                    in 1..universities.size -> universities.elementAt(ind - 1)
                    else -> menuFail("Rango invalido")
                }
            }catch (e : Exception){
                System.err.println("Error: ${e.message}. Rango valido [1, ${universities.size}]")
            }
        }while(ind != 0)
    }
    println("No hay universidades registradas")
    return null;
}

fun getFaculty(university : University) : Faculty? {
    if (university.getFaculties().isNotEmpty()) {
        var ind : Int? = null
        do {
            try{
                Utils.printFaculties(university)
                println("Ingresa 0 para regresar")
                print("Ingresa el índice de la facultad: ")
                ind = readLine()!!.toInt()
                return when (ind) {
                    0 -> null
                    in 1..university.getFaculties().size -> university.getFaculties().elementAt(ind - 1)
                    else -> menuFail("Rango invalido")
                }
            }catch (e : Exception){
                System.err.println("Error: ${e.message}. Rango valido [1, ${university.getFaculties().size}]")
            }
        }while(ind != 0)
    }
    println("No hay facultades registradas")
    return null;
}

fun getProfessor(professors: Set<Professor>) : Professor? {
    if (professors.isNotEmpty()) {
        var ind : Int? = null
        do {
            try{
                Utils.printProfessors(professors)
                println("Ingresa 0 para regresar")
                print("Ingresa el índice del profesor: ")
                ind = readLine()!!.toInt()
                return when (ind) {
                    0 -> null
                    in 1..professors.size -> professors.elementAt(ind - 1)
                    else -> menuFail("Rango invalido")
                }
            }catch (e : Exception){
                System.err.println("Error: ${e.message}. Rango valido [1, ${professors.size}]")
            }
        }while(ind != 0)
    }
    println("No hay profesores registrados")
    return null;
}

fun getSignature(signatures: Set<Signature>) : Signature? {
    if (signatures.isNotEmpty()) {
        var ind : Int? = null
        do {
            try{
                Utils.printSignatures(signatures)
                println("Ingresa 0 para regresar")
                print("Ingresa el índice del profesor: ")
                ind = readLine()!!.toInt()
                return when (ind) {
                    0 -> null
                    in 1..signatures.size -> signatures.elementAt(ind - 1)
                    else -> menuFail("Rango invalido")
                }
            }catch (e : Exception){
                System.err.println("Error: ${e.message}. Rango valido [1, ${signatures.size}]")
            }
        }while(ind != 0)
    }
    println("No hay materias registrados")
    return null;
}


