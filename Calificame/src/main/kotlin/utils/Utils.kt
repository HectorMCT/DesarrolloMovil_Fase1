package utils

import model.Professor
import model.Signature
import model.University

class Utils {
    companion object{
        fun printUniversities(universities: Set<University>) {
            if (universities.isNotEmpty())
                universities.forEachIndexed{ index, university -> println("${index + 1}. ${university.name}") }
            else
                println("No hay universidades registradas")
        }

        fun printProfessors(professors: Set<Professor>) {
            if (professors.isNotEmpty())
                professors.forEachIndexed{ index, professor -> println("${index + 1}. ${professor.name}") }
            else
                println("No hay profesores registrados")
        }

        fun printSignatures(signatures: Set<Signature>) {
            if (signatures.isNotEmpty())
                signatures.forEachIndexed{ index, signature -> println("${index + 1}. ${signature.name}") }
            else
                println("No hay materias registradas")
        }

        fun printFaculties(university : University){
            if (university.getFaculties().isNotEmpty())
                university.getFaculties().forEachIndexed{ index, faculty -> println("${index + 1}. ${faculty.name}") }
            else
                println("No hay facultades registradas")
        }

    }

}