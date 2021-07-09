/*En la sesión 3, se comenzó a abordar el paradigma “Programación Orientada a Objetos”, 
mejor conocido como  POO, dado la importancia de éste en la actualidad fue indispensable 
comenzar a trabajar el proyecto desde este paradigma. Primero se comenzó con los conceptos 
de clases y objetos, posteriormente con los de constructores, getters y setters, para que 
finalmente se diseñará una simulación de ventas de celulares mediante un carrito de compras.

Para la actividad anterior, fue necesario la creación de la clase “Phone”, la cual representa un 
celular y contiene las propiedades de un celular, adicionalmente se creó la clase ShoppingCart 
simulando un carrito de compras en donde se agregaran o remover los celulares que se desean 
comprar mediante métodos, así como un método para realizar la compra.

El objetivo del post work fue entender la programación orientada a objetos, así como también, 
la sintaxis que utiliza kotlin con la finalidad de poder aplicarla al proyecto.*/
/*                                        POSTWORK 3                                        */
const val PHONE_LENGTH = 10

class User(
    private val name: String,
    private var age: Int,
    private val userToken: String,
    private val email: String ){

    private var phoneNumber: Long = 0
        set(value) {
            if(value.toString().length == PHONE_LENGTH){
                field = value
            } else{
                println("El número debe de tener al menos $PHONE_LENGTH dígitos")
            }
        }
    fun update(phoneNumber : Long?, age : Int?){
        if (phoneNumber != null) this.phoneNumber = phoneNumber
        if (age != null) this.age = age
    }

    override fun toString(): String {
        return """
            Name: $name
            Age: $age
            Token: $userToken
            email: $email
            Phone number: $phoneNumber
        """.trimIndent()
    }

}

class Mobile(
    val sku: Int,
    private val brand: String,
    val color: String,
    private val model: String,
    val price: Float){

    init {
        println("El celular es un $model de la marca $brand")
    }
}

class ShoppingCart() {
    private var cart: MutableList<Mobile> = mutableListOf<Mobile>()
    var total = 0f
        private set

    fun add(mobile : Mobile) {
         if (cart.add(mobile)) {
             total += mobile.price
             println("El celular con SKU: ${mobile.sku} fue añadido del carrito")
         }
    }
    fun remove (mobile : Mobile) {
        if(cart.remove(mobile)) {
            total -= mobile.price
            println("El celular con SKU: ${mobile.sku} fue eliminado del carrito")
        }
    }

    fun emptyShoppingCart() {
        cart.removeAll { true }
        total = 0f
        println("El carro esta vacio")
    }

    fun viewCart(){
        println("Carrito de compra:")
        for (mobile in cart) println("Mobile SKU: ${mobile.sku} y su precio: ${mobile.price}")
    }

    fun buy(){
        viewCart()
        println("El total es: $total")
    }
}

fun main() {
    val user = User("Esiel Arizmendi", 23, "token_gdsfrs", "esiel_kar@hotmail.com")
    user.update(phoneNumber = 2223154651, age = null)
    println(user)

    val mobile1 = Mobile(100, "Apple", "Gold", "iPhone 12", 19_500f)
    val mobile2 = Mobile(567, "Samsung", "White", "Galaxy Z", 20_659f)
    val mobile3 = Mobile(999, "Huawei", "Blue", "Mate 20", 17_500f)

    val cart =  ShoppingCart()

    cart.add(mobile1)
    cart.add(mobile2)
    cart.viewCart()
    cart.add(mobile3)
    cart.remove(mobile1)
    cart.viewCart()
    cart.add(mobile1)
    cart.buy()

}