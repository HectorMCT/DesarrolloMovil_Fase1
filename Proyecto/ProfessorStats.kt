package model

/**
 *
 */
class ProfessorStats(
    facility: Double,
    clarity: Double,
    recommendation: Double,
    subjectsStats: MutableMap<Subject, SubjectStats>?,
    reviews: MutableMap<Subject, Review>?
) : Stats(facility, clarity, recommendation) {

    //Subjects Stats
    var subjectsStats : Map<Subject, SubjectStats>? = subjectsStats

    //Subjects Reviews
    var reviews : Map<Subject, Review>? = reviews

}