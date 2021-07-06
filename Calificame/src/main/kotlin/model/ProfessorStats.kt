package model

/**
 * Representa las estisticas generales de un profesor de la aplicación Califícame!
 * @constructor Crea las estadisticas de un profesor dadas su facilidad, claridad y recomendación.
 * Adicionalmente, un [Map] de las estadisticas de cada materia que tenga estadisticas registradas
 * y un [Map] de reviews por cada materia que tenga reviews registradas
 * @throws Exception si facility, clarity o recommendation no están en el rango de valores de 1 - 100.
 */
class ProfessorStats(
    facility: Double = 0.0,
    clarity: Double = 0.0,
    recommendation: Double = 0.0,
    private val signaturesStats: MutableMap<Signature, MutableList<SignatureStats>> = mutableMapOf(),
    private val reviews: MutableMap<Signature, MutableList<Review>> = mutableMapOf()
) : Stats(facility, clarity, recommendation) {
    fun getSignatures() = (signaturesStats.map { it.key } + reviews.map { it.key }).toSet()
    fun getReviewsOf(signature: Signature) = reviews[signature]?.toList()
    fun getStatsOf(signature: Signature) = signaturesStats[signature]?.toList()
    fun addReviewTo(signature : Signature, review: Review) = reviews[signature]?.add(review) ?: reviews.put(signature, mutableListOf(review))
    fun addStatsTo(signature : Signature, stats: SignatureStats) = signaturesStats[signature]?.add(stats) ?: signaturesStats.put(signature, mutableListOf(stats))
    override fun toString() : String{
        updateStats()
        return super.toString()
    }
    private fun updateStats(){
        var size: Int
        var facility= 0.0
        var clarity= 0.0
        var recommendation = 0.0

        for(key in signaturesStats.keys){

            var auxFacility = 0.0
            var auxClarity= 0.0
            var auxRecommendation = 0.0

            for (value in signaturesStats[key]!!){
                auxFacility += value.facility
                auxClarity += value.clarity
                auxRecommendation += value.recommendation
            }
            size = signaturesStats[key]!!.size
            facility += auxFacility / size
            clarity += auxClarity / size
            recommendation += auxRecommendation / size
        }

        size = signaturesStats.size
        if (size != 0){
            this.facility = facility / size
            this.clarity = clarity / size
            this.recommendation = recommendation / size
        }
    }

}