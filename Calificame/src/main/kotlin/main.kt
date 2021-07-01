import model.*
import utils.Utils
import java.util.*

fun main(){
    var universities : MutableSet<University> = mutableSetOf()
    var professors : MutableSet<Professor> = mutableSetOf()
    var signatures : MutableSet<Signature> = mutableSetOf()
//
//
//    var universities : MutableSet<University> = mutableSetOf<University>(
//        University("Benemérita Universidad Autónoma de Puebla", mutableSetOf<Faculty>(
//            Faculty("Facultad de Cs. de la Computación", mutableMapOf<Professor, ProfessorStats>(
//                Professor("Hilda Castillo Zacatelco") to ProfessorStats(90.0, 100.0, 100.0,
//                    mutableMapOf<Subject, SubjectStats>(
//                        Subject("Programación I") to SubjectStats(90.0, 100.0, 100.0, 100.0, 50.0,100.0, 80.0, 3)
//                    ),
//                    mutableMapOf<Subject, Review>()
//                ),
//            ))
//        )),
//        University("Universidad Nacional Autónoma de México")
//    )
//    printUniversities(universities)
//
val fac : Faculty = Faculty("Ingenieria", mutableMapOf(
    Professor("Hilda") to ProfessorStats(50.0,50.0,50.0,null,null)
))
    println(fac.getProfessorStat(fac.getProfessors().elementAt(0))?.reviews)

    //menuPricipal(universities, professors, signatures)
}
//Menu fail function
fun menuFail(message : String) : Nothing = throw Exception(message)

/*              Principal Menu and Functions              */
fun menuPricipal(universities: MutableSet<University>,
                 professors: MutableSet<Professor>,
                 signatures: MutableSet<Signature>){
    var opc : Int? = null
    do{
        try {
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
                            if (uni != null) menuUniversidad(uni)
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
fun menuUniversidad(university: University){
    println("App Califícame!")
    println("Universidad: ${university.name}")
    println("1. Agregar facultad")
    println("2. Eliminar universidad")
    println("3. Ver lista de facultades")
    println("4. Seleccionar facultad")
    println("5. Regresar")
    print("Digita una opción: ")
}

fun menuFacultad(){
    println("App Califícame!")
    println("Universidad: ")
    println("Facultad: ")
    println("1. Agregar Profesor")
    println("2. Ver lista de profesores")
    println("3. Seleccionar profesor")
    print("Digita una opción: ")
}

fun menuProfesor(){
    println("App Califícame!")
    println("Universidad: ")
    println("Facultad: ")
    println("Profesor: ")
    println("1. Agregar Profesor")
    println("2. Ver lista de profesores")
    println("3. Seleccionar profesor")
    print("Digita una opción: ")
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
    print("Ingresa el nombre de la materia: ")
    signature = readLine()!!

    if (signatures.add(Signature(signature)))
        println("La materia se añadio exitosamente")
    else
        println("Ya existe registro de esta materia")
}


/*          Getters           */
fun getUniversity(universities: MutableSet<University>) : University? {
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

fun getProfessor(professors: MutableSet<Professor>) : Professor? {
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

fun getSignature(signatures: MutableSet<Signature>) : Signature? {
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


