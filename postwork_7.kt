fun main(args: Array<String>) {
    // print("Ingresa un número: ")
    // val number = Integer.valueOf(readLine())
    // println("Has ingresado el número: $number")

    //Manejando la excepción
    try{
        val number = Integer.valueOf(readLine())
        println("Has ingresado el número: $number")
    } catch (e: NumberFormatException){
        println("Por favor, escribe una opción válida")
    }

    val nullableList: List<Int?> = listOf(15, 30, null, 7)
    val intList: List<Int> = nullableList.filterNotNull()

    println(intList)  
}