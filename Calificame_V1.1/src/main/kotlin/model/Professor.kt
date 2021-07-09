package model

/**
 * Representa un profesor de la aplicación Califícame!
 * @constructor Crea un nuevo profesor dado su nombre
 * @property name Nombre del profesor
 */
data class Professor(val name : String){
    override fun toString() = "Profesor: $name"
}