package model

import java.util.*

data class Review (val user : User, val comment : String, val date: Date, val satisfaction : Double){
    override fun toString(): String {
        return """
            ${'\n'}
            ||- Review -||
            User: ${user.username}
            Satisfaction: $satisfaction
            Date: $date
            Comment: $comment 
        """.trimIndent()
    }
}