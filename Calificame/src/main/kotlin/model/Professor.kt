package model

/**
 * Representa un profesor el cual contiene un nombre
 */
data class Professor(val name : String){
    override fun toString() = "Professor: $name"
}