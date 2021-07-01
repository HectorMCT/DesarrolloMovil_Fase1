package model

/**
 * Clase abstracta que representa las estadisticas en común de un profesor y una materia
 */
abstract class Stats(var facility: Double = 0.0, var clarity: Double = 0.0, var recommendation: Double = 0.0) {
    init {
        val range = 0.0..100.0
        when {
            facility !in range -> throw Exception("Facility out of range. Range: from 0 up to 100")
            clarity !in range -> throw Exception("Clarity out of range. Range: from 0 up to 100")
            recommendation !in range -> throw Exception("Recommendation out of range. Range: from 0 up to 100")
        }
    }

    override fun toString(): String {
        return """
            ||-- General Stats --||
            Facility: $facility
            Clarity: $clarity
            Recommendation: $recommendation
        """.trimIndent()
    }

}