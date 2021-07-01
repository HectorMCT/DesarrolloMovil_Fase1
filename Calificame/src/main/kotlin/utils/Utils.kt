package utils

import model.Professor
import model.Signature
import model.University

class Utils {
    companion object{
        fun printUniversities(universities: MutableSet<University>) {
            if (universities.isNotEmpty())
                universities.forEachIndexed{ index, university -> println("${index + 1}. ${university.name}") }
            else
                println("No hay universidades registradas")
        }

        fun printProfessors(professors: MutableSet<Professor>) {
            if (professors.isNotEmpty())
                professors.forEachIndexed{ index, professor -> println("${index + 1}. ${professor.name}") }
            else
                println("No hay profesores registradas")
        }

        fun printSignatures(signatures: MutableSet<Signature>) {
            if (signatures.isNotEmpty())
                signatures.forEachIndexed{ index, signature -> println("${index + 1}. ${signature.name}") }
            else
                println("No hay materias registradas")
        }

    }

}