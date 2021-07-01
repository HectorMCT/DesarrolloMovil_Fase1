package utils

import model.*

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

        fun printSignatureStats(stats : List<SignatureStats>){
            if (stats.isNotEmpty())
                stats.forEachIndexed{ index, stat -> println("${index + 1}\n$stat") }
            else
                println("No hay estadisticas registradas")
        }

        fun printSignatureReviews(reviews : List<Review>){
            if (reviews.isNotEmpty())
                reviews.forEachIndexed{ index, review -> println("${index + 1}.\n$review") }
            else
                println("No hay reviews registradas")
        }

        //Menu fail function
        fun menuFail(message : String) : Nothing = throw Exception(message)
        fun validRangeValue(min : Int, max: Int, message : String) : Int {
            var value : Int? = null
            do {
                try {
                    print(message)
                    value = readLine()!!.toInt()
                    if (value !in min..max) menuFail("Rango invalido")
                }catch (e : Exception) {
                    println("Error: ${e.message}. Rango valido [$min, $max]")
                }
            }while (value == null || value !in min..max)
            return value!!
        }
        fun validRangeValue(min : Double, max: Double, message : String) : Double {
            var value : Double? = null
            do {
                try {
                    print(message)
                    value = readLine()!!.toDouble()
                    if (value !in min..max) menuFail("Rango invalido")
                }catch (e : Exception) {
                    println("Error: ${e.message}. Rango valido [$min, $max]")
                }
            }while (value == null || value !in min..max)
            return value!!
        }
    }

}