package model

/**
 * Representa una facultad de la aplicación Califícame!
 * @constructor Crea una facultad dado su nombre y (opcionalmente)
 * un [Map] de [Professor] - [ProfessorStats] , que por defecto esta vacio.
 * @property name Nombre de la facultad
 * @property professors [Map] de los profesores de la facultad
 */
data class Faculty (val name : String, private val professors : MutableMap<Professor, ProfessorStats> = mutableMapOf()) {
    fun getProfessors() = professors.map { it.key }.toSet()
    fun getProfessorStat(professor : Professor) = professors[professor]

    /**
     * Añade el profesor dado a la facultad
     * @return `true` si el profesor se añadió, `false` si ya existía.
     */
    fun addProfessor(professor : Professor) = professors.putIfAbsent(
        professor,
        ProfessorStats(0.0,0.0, 0.0))
    /**
     * Elimina el profesor de la facultad
     * @return true si la profesor se eliminó, false si no exististe el la facultad.
     */
    fun removeProfessor(professor : Professor) = professors.remove(professor)
}