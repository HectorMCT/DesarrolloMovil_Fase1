package model

/**
 * Representa una universidad de la aplicación Califícame!
 * @constructor Crea una universidad dado su nombre y (opcionalmente)
 * un [Set] de facultades, que por defecto esta vacio.
 * @property name Nombre de la universidad
 * @property faculties Set de las facultades de la universidad
 */
data class University (val name : String, private val faculties : MutableSet<Faculty> = mutableSetOf()){
    fun getFaculties() = faculties.toSet()

    /**
     * Añade la facultad dada a la universidad
     * @return `true` si la facultad se añadió, `false` si ya existía.
     */
    fun addFaculty(faculty : Faculty) = faculties.add(faculty)

    /**
     * Elimina la facultad dada de la universidad
     * @return `true` si la facultad se eliminó, `false` si no exististe en la universidad.
     */
    fun removeFaculty(faculty : Faculty) = faculties.remove(faculty)
}