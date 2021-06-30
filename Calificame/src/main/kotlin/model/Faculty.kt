package model

data class Faculty (val name : String, var professors : MutableMap<Professor, ProfessorStats>?) {

    override fun toString(): String {
        return """
Faculty: $name
||-- Professors --||
${professorToString()}
""".trimIndent()
    }
    private fun professorToString() : String {
        if (this.professors != null && this.professors!!.isNotEmpty()) {
            var professors = ""
            this.professors!!.forEach { professors += it }
            return professors
        }
        return "There's no professor registered"
    }
}