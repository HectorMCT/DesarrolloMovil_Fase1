package model

data class University (val name : String, private val faculties : MutableSet<Faculty> = mutableSetOf()){
    /*override fun toString(): String {
        return """University: $name
        ${faculties.toString()}
        """.trimIndent()
    }*/

    /*private fun facultiesToString() : String {
        if (this.faculties != null && this.faculties!!.isNotEmpty()) {
            var faculties = "\n"
            this.faculties.forEach { faculties += it }
            return faculties
        }
        return "There's no faculty registered\n"
    }*/

    override fun toString(): String = "University: $name"
    fun getFaculties() = faculties.map { it.copy() }
    fun addFaculty(faculty : Faculty) = faculties.add(faculty)
    fun removeFaculty(faculty : Faculty) = faculties.remove(faculty)

}