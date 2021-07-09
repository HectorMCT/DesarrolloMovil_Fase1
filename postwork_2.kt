/*Para este post work se tenía que trabajar con funciones y estructuras de datos. 
Estos elementos dentro de Kotlin nos ayudaron a estructurar de mejor manera nuestro proyecto, 
debido a que ahora podemos guardar múltiples datos tanto de profesores, cómo de calificaciones, 
necesarias para el proyecto, de una manera más dinámica, esto con ayuda de estructuras de datos 
mutables (Map y List).*/
/*                                       POSTWORK 2                                         */
fun main() {
    val email = "esiel_kar@hotmail.com"
    val contraseña = "123456"
    val login = login(email, contraseña)

    /* COLECCIONES */
    val usuarios = mapOf( //NO ES UTILIZADO
        "esiel_kar@hotmail.com" to "123456",
    );

    val peliculas = setOf(
        "Scary movie",
        "Scary movie 2",
        "Las trillizas de Belleville",
        "Midori",
        "Doce monos",
        "Blade runner",
        "Mulán"
    )
    
    /* BUCLES */
    peliculas.forEach{ println(it) }
    
}

//para hacer login si la aplicación lo requiere
fun login(email: String, pass:String): Boolean{
    if(email=="esiel_kar@hotmail.com" && password=="123456"){
        println("Inicio de sesión exitoso")
        return true
    } else{
        println("Email o contraseña incorrecto")
        return false
    }
}