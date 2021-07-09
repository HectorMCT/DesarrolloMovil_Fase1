/*En esta breve simulación se guardan los datos pertenecientes al profesor que se evaluará en 
clase, los cuales se ingresan por la línea de comandos. Después, con un ciclo while y una 
condición if, validamos que se ingrese una calificación de entre 1 a 5. Solo contando números 
enteros. Por último, colocamos todo lo anterior dentro de un bucle while, con el propósito de 
poder agregar más profesores.*/
/*                                          RETO FINAL 1                                       */
fun main(){
    var opc = 1;

    do{
        println("Ingresa el nombre del profesor: ")
        var profeName = readLine()!!

        println("Ingresa el apellido paterno del profesor: ")
        var profeApPat = readLine()!!

        println("Ingresa el apellido materno del profesor: ")
        var profeApMat = readLine()!!

        var calif1 : Int
        do {
            println("Ingresa la calificacion del profesor $profeName $profeApPat $profeApMat del 1 al 5: ")
            calif1 = readLine()!!.toInt()
            if (calif1 !in 1..5)
                println("La calificación debe ser en el rango de 1-5")
        }while(calif1 !in 1..5)

        println("La calificacion del profesor $profeName $profeApPat $profeApMat  segun la comunidad es de: $calif1 estrellas")
        println("Gustas agregar a otro profesor?")
        println("1. Si")
        println("2. No")
        opc = readLine()!!.toInt()
    }while(opc != 2)