package model

data class University (val name : String, var faculties : MutableList<Faculty>?){
    override fun toString(): String {
        return """
University: $name
||--- Faculties ---||
${this.facultiesToString()}
""".trimIndent()
    }

    private fun facultiesToString() : String {
        if (this.faculties != null && this.faculties!!.isNotEmpty()) {
            var faculties = ""
            this.faculties!!.forEach { faculties += it }
            return faculties
        }
        return "There's no faculty registered"
    }
}