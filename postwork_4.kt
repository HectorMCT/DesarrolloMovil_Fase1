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
