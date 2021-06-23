package model

data class User(val username : String, val email : String){
    override fun toString() = "Username: $username, Email: $email"
}