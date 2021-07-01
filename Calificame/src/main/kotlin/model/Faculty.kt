package model

/**
 * Representa una facultad la cual contiene un nombre y
 * un mapa de las estidiscas de cada profesor que tenga registrado
 */
data class Faculty (var name : String, private val professors : MutableMap<Professor, ProfessorStats> = mutableMapOf()) {
    /*override fun toString(): String {
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
    }*/

    override fun toString(): String = "Professor: $name"
    fun getProfessors() = professors.map { it.key.copy() }
    fun getProfessorStat(professor : Professor) = professors[professor]

    //fun addProfessor(faculty : Faculty) = profes.add(faculty)
    //fun removeFaculty(faculty : String) = faculties.removeIf { it.name == faculty }
}