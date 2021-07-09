/*Durante la sesión 4 retomamos temas relacionados con programación orientada a objetos. 
Para lo cual en este postwork se trabajo con los conceptos de clases abstractas y data class. 
Se crearon 2 clases, Computer y Mobile proyecto  las cuales se derivan de la clase abstracta 
Product. Con ella sobreescribimos el método description con el propósito de presentar los 
atributos de ambos productos de diferentes maneras. 

Dentro del proyecto implementamos data class en las clases que solo se encargan de almacenar 
los datos, ya sea del usuario, de la universidad, la facultad, el profesor, las reseñas y las 
asignaturas, debido a que en su mayoría estos datos una vez seteados, será muy raro que se 
modifiquen. También se implementó una clase abstracta relacionada a las estadísticas de 
calificación del profesor, con el objetivo de mostrarlas de mejor manera.*/
/*                                        POSTWORK 4                                        */
abstract class Product(
    val name: String,
    val description: String,
    var sku:Int){

    abstract fun description() : String
}

class Mobile (
    private val brand: String,
    model:String,
    description: String,
    private val color: String,
    private val price: Float,
    sku:Int): Product(model,description,sku)
{

    override fun description(): String {
        return """Mobile: $name
            |SKU: $sku
            |Brand: $brand
            |Color: $color
            |Price: $price
            |Description: $description""".trimMargin()
    }
}

class Computer(
    model : String,
    description: String,
    private val price : Float,
    private val color : String,
    sku:Int): Product(model ,description,sku){

    override fun description() = """Computer: $name
            |SKU: $sku
            |Color: $color
            |Price: $price
            |Description: $description""".trimMargin()
}

fun main() {
    val m = Mobile("Apple", "iPhone 11", "Procesador Bionic A13", "Blanco", 17_500f, 524-658)
    val c = Computer("Macbook Pro 2017", "2 puertos Thunderbolt 3 ",27_500f,"Gris espacial", 652-458)

    println(m.description())
    println(c.description())
}
