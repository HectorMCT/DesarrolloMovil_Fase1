package model

/**
 * Subject Stats
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
||-- Specific Stats --||
Domain: $domain
Complexity: $complexity
Fair Evaluation: $fairEvaluation
Apply Exams: $applyExams
Exams count: ${examsCount ?: 0}""".trimIndent()
    }
}