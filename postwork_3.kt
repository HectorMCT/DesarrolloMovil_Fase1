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

class ShoppingCar() {
    private var car: MutableList<Mobile> = mutableListOf<Mobile>()
    var total = 0f
        private set

    fun add(mobile : Mobile) {
         if (car.add(mobile)) {
             total += mobile.price
             println("El celular con SKU: ${mobile.sku} fue añadido del carrito")
         }
    }
    fun remove (mobile : Mobile) {
        if(car.remove(mobile)) {
            total -= mobile.price
            println("El celular con SKU: ${mobile.sku} fue eliminado del carrito")
        }
    }

    fun emptyShoppingCar() {
        car.removeAll { true }
        total = 0f
        println("El carro esta vacio")
    }

    fun viewCart(){
        println("Carrito de compra:")
        for (mobile in car) println("Mobile SKU: ${mobile.sku} y su precio: ${mobile.price}")
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

    val car =  ShoppingCar()

    car.add(mobile1)
    car.add(mobile2)
    car.viewCart()
    car.add(mobile3)
    car.remove(mobile1)
    car.viewCart()
    car.add(mobile1)
    car.buy()

}