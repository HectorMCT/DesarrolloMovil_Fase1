package model

/**
 * Representa un usuario que contiene un username y contraseña
 */
/*data class User(val name : String,
                val lastName : String,
                val email : String,
                val username : String,
                val password : String
                ){
    init {
        println("Bienvenido $name $lastName")
    }

}*/

data class User(val username : String, val password : String)