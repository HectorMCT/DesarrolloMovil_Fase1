package model

open class Stats(val facility: Double, val clarity: Double, val recommendation: Double) {

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
            ${'\n'}
            ||-- General Stats --||
            Facility: $facility
            Clarity: $clarity
            Recommendation: $recommendation
        """.trimIndent()
    }

}