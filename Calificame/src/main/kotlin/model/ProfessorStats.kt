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
    subjectsStats: MutableMap<Signature, SignatureStats>?,
    reviews: MutableMap<Signature, Review>?
) : Stats(facility, clarity, recommendation), Cloneable {

    //Subjects Stats
    var subjectsStats : Map<Signature, SignatureStats>? = subjectsStats

    //Subjects Reviews
    var reviews : Map<Signature, Review>? = reviews

    public override fun clone(): Any {
        return super.clone()
    }

}