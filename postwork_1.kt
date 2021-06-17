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

}
