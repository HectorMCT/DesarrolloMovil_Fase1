package model

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Representa una review de la aplicación Califícame!
 * @constructor Crea una nueva reseña dado un [User], comment y satisfaction
 * @property user Usuario que hace la review
 * @property date fecha en la que se hace la review (Por defecto es la actual cuando se crea)
 * @property comment Comentario que hace el usuario
 * @property satisfaction Grado de satisfaction del usuario
 */
data class Review (val user : User, val comment : String, val satisfaction : Double, private val date : Date = Date()){
    override fun toString(): String {
return """User: ${user.username}
Fecha: ${SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(date)}
Satisfacción: $satisfaction
Comentario: $comment 
""".trimIndent()
    }
}