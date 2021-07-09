fun main() {
    fun main() = runBlocking {
    withTimeout(10_000L) {
        repeat(30) { i ->
            println("Descargando $i% ...")
            delay(300L)
        }
    }
}
}