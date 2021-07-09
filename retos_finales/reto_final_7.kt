fun main(args: Array<String>) {
    //val fileStr = File("Archivo").inputStream().readBytes().toString(Charsets.UTF_8)
    //Exception: Exception in thread "main" java.io.FileNotFoundException: Archivo (No such file or directory)

    //val formatData = SimpleDateFormat("MM, dd, yyyy").parse("fecha-invalida")
    //Exception: Exception in thread "main" java.text.ParseException: Unparseable date: "fecha-invalida"

    println("Antes del sleep")
    Thread.sleep(1_000)
    println("Después del sleep")

    //Si el tiempo es negativo
    //Exception: Exception in thread "main" java.lang.IllegalArgumentException: timeout value is negative
}