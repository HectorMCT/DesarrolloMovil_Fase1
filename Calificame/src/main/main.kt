import model.*

fun main(){
    var universities : MutableList<University> = mutableListOf<University>(
        University("Benemérita Universidad Autónoma de Puebla", mutableListOf<Faculty>(
            Faculty("Facultad de Cs. de la Computación", mutableMapOf<Professor, ProfessorStats>(
                Professor("Hilda Castillo Zacatelco") to ProfessorStats(90.0, 100.0, 100.0,
                mutableMapOf<Subject, SubjectStats>(
                    Subject("Programación I") to SubjectStats(90.0, 100.0, 100.0, 100.0, 50.0,100.0, 80.0, 3)
                ),
                    mutableMapOf<Subject, Review>()
                ),
            ))
        )),
        University("Universidad Nacional Autónoma de México", null)
    )
    printUniversities(universities)
}

fun printUniversities(universities : Iterable<University>) {
    for (university in universities) {
        println(university);
    }
}
