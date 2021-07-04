package model

/**
 * Representa un materia de la aplicación Califícame!
 * @constructor Crea una nueva Materia dado su nombre
 * @property name Nombre de la materia
 */
data class Signature(val name : String){
    override fun toString() = "Subject: $name"
}