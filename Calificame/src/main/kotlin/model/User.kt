package model

/**
 * Representa un usuario que contiene un username y un email
 */
data class User(val name : String,
                val lastName : String,
                val email : String,
                val username : String,
                val password : String
                ){
    init {
        println("Bienvenido $name $lastName")
    }
}