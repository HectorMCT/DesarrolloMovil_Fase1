package model

/**
 * Representa las estisticas generales de un profesor
 * Hereda de la clase Stats, por lo cual contiene facilidad, claridad y recomendación
 * Adicionalmente, contiene un mapa de las estadisticas de cada materia que tenga registrada
 * y un mapa de reviews por cada materia registrada
 */
class ProfessorStats(
    facility: Double,
    clarity: Double,
    recommendation: Double,
    val signaturesStats: MutableMap<Signature, MutableList<SignatureStats>> = mutableMapOf(),
    val reviews: MutableMap<Signature, MutableList<Review>> = mutableMapOf()
) : Stats(facility, clarity, recommendation) {

    fun getSignatures() = (signaturesStats.map { it.key } + reviews.map { it.key }).toSet()
    fun getReviewsOf(signature: Signature) = reviews[signature]?.toList()
    fun addReviewTo(signature : Signature, review: Review) = reviews[signature]?.add(review) ?: reviews.put(signature, mutableListOf(review))
    fun getStatsOf(signature: Signature) = signaturesStats[signature]?.toList()
    fun addStatsTo(signature : Signature, stats: SignatureStats) = signaturesStats[signature]?.add(stats) ?: signaturesStats.put(signature, mutableListOf(stats))
    fun generalStats() : String{
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
            facility += auxFacility / signaturesStats[key]!!.size
            clarity += auxClarity / signaturesStats[key]!!.size
            recommendation += auxRecommendation / signaturesStats[key]!!.size
        }
        this.facility = facility / signaturesStats.size
        this.clarity = clarity / signaturesStats.size
        this.recommendation = recommendation / signaturesStats.size
        return super.toString()
    }

}