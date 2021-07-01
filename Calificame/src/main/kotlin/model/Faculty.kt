package model

/**
 * Representa una facultad la cual contiene un nombre y
 * un mapa de las estidiscas de cada profesor que tenga registrado
 */
data class Faculty (val name : String, private val professors : MutableMap<Professor, ProfessorStats> = mutableMapOf()) {
    fun getProfessors() = professors.map { it.key }.toSet()
    fun getProfessorStat(professor : Professor) = professors[professor]
    fun addProfessor(professor : Professor) = professors.putIfAbsent(
        professor,
        ProfessorStats(0.0,0.0, 0.0))
    fun removeProfessor(professor : Professor) = professors.remove(professor)
}