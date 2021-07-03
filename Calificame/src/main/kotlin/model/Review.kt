package model

/**
 * Representa una review de la aplicación Califícame!
 * @constructor Crea una nueva reseña dado un [User], comment y satisfaction
 * @property User Usiario que hace la review
 * @property comment Comentario que hace el usuario
 * @property satisfaction Grado de satisfaction del usuario
 */
data class Review (val user : User, val comment : String, val satisfaction : Double){
    override fun toString(): String {
return """User: ${user.username}
Satisfaction: $satisfaction
Comment: $comment 
""".trimIndent()
    }
}