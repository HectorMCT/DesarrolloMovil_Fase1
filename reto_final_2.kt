/*Con respecto al uso de funciones, nos permite modularizar más nuestro código y agregar más 
funcionalidad al proyecto. Se crearon tres funciones; la función califica nos permite ingresar 
la calificación de una materia específica, dentro de ella se puede agregar materias que no se 
encuentran en la lista, todo esto con ayuda de la función ingresaMateria. Por otro lado, 
promedioReview nos ayuda a obtener el promedio de calificación hacia un profesor.

Se implementó un menú para poder recoger calificaciones de una función. Dicha adición nos 
proporcionó una perspectiva bastante más certera del comportamiento básico del programa. 
El propio IDE nos brindó soluciones para evitar el uso de return a la hora de trabajar en 
el menú para cada caso del when*/

/*                                      RETO FINAL 2                                   */
fun main() {
    val idProfe = mapOf(340960 to "Enrique", 219320 to "Aldo")
    //Se guardan las calificaciones de una materia o curso en una lista.
    val calRw = mutableListOf(5.0, 3.0, 4.0, 5.0, 4.5)
    //Lista de materias
    val signatures = mutableListOf("1.-Matematicas", "2.-Historia", "3.-Geografia", "4.-Artes", "5.-Gramatica", "6.-Lengua Extranjera" )
    
    println("1.- Calificar profesores")
    califica(signatures)
    println("2.- Review de profesores")
    val promedio = promedioReview(calRw)
    calRw.add(promedio)
    println(promedio)
}

fun califica(materias: MutableList<String>): Int? {

    var promedio = 0
    materias.forEach{println(it)}
    println("Elige la materia impartida: ")
    val elect = readLine()?.toInt()
    when(elect){
        1 -> {
            println("Calificacion en matematicas: ")
            return readLine()?.toInt()
        }
        2 -> {
            println("Calificacion en Historia: ")
            return readLine()?.toInt()
        }
        3 -> {
            println("Calificacion en Geografia: ")
            return readLine()?.toInt()
        }
        4 -> {
            println("Calificacion en Artes: ")
            return readLine()?.toInt()
        }
        5 -> {
            println("Calificacion en Gramatica: ")
            return readLine()?.toInt()
        }
        6 -> {
            println("Calificacion en Lengua Extranjera: ")
            val cal1 = readLine()?.toInt()
        }
        7 -> {
            println("Ingrese el nombre de la materia: ")
            val signat = readLine()?.toString()
            ingresaMateria(materias, signat)
            println("Ingrese la calificacion calificacion en dicha materia: ")
            return readLine()?.toInt()
        }
        else -> println("Elija una opcion valida")
    }
}

fun ingresaMateria(materias: MutableList<String>, signa: String?){
    materias.add(signa.toString())
}

//Promedio de calificaciones de Reviews
fun promedioReview(califRevie: MutableList<Double>): Double{
    var promedio = 0.0
    califRevie.forEach {
        promedio += it
    }
    return promedio / califRevie.size
}