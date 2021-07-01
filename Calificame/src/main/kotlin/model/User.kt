package model

/**
 * Representa un usuario que contiene un username y un email
 */
data class User(val username : String, val email : String){
    override fun toString() = "Username: $username, Email: $email"
}