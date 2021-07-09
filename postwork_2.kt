/*               POSTWORK 2              */
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