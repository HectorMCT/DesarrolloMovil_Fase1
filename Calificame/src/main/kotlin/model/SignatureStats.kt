package model

/**
 * Representa las estisticas de una materia de la aplicación Califícame!
 * @constructor Crea las estadisticas de una materia dadas la facilidad, claridad, recomendación
 * dominio, complejidad, evaluación justa, si aplica examenes y la cantidad de examenes
 * @throws Exception si facility, clarity, recommendation, domain, complexity
 * fairEvaluation, applyExams, no están en el rango de valores de 1 - 100.
 */
class SignatureStats//Range
    (facility: Double = 0.0,
     clarity: Double = 0.0,
     recommendation: Double = 0.0,//Stats
     val domain: Double = 0.0,
     val complexity: Double = 0.0,
     val fairEvaluation: Double = 0.0,
     val applyExams: Double = 0.0,
     val examsCount: Int = 0
) : Stats(facility, clarity, recommendation) {

    init {
        val range = 0.0..100.0 //Range
        when {
            domain !in range -> throw Exception("Domain out of range. Range: from 0 up to 100")
            complexity !in range -> throw Exception("Complexity out of range. Range: from 0 up to 100")
            fairEvaluation !in range -> throw Exception("FairEvaluatiob out of range. Range: from 0 up to 100")
            applyExams !in range -> throw Exception("ApplyExams out of range. Range: from 0 up to 100")
        }
    }

    override fun toString(): String {
return """${super.toString()}
||-- Estadísticas específicas --||
Dominio: $domain
Complejidad: $complexity
Evaluación justa: $fairEvaluation
¿Aplica exámenes?: $applyExams
Cantidad de exámenes: ${examsCount ?: 0}""".trimIndent()
    }
}