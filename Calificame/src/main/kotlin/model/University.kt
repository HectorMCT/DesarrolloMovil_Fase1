package model

data class University (val name : String, private val faculties : MutableSet<Faculty> = mutableSetOf()){
    fun getFaculties() = faculties.toSet()
    fun addFaculty(faculty : Faculty) = faculties.add(faculty)
    fun removeFaculty(faculty : Faculty) = faculties.remove(faculty)
}