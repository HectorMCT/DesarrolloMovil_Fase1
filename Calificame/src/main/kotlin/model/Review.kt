package model

data class Review (val user : User, val comment : String, val satisfaction : Double){
    override fun toString(): String {
return """User: ${user.username}
Satisfaction: $satisfaction
Comment: $comment 
""".trimIndent()
    }
}