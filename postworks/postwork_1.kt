/*Con respecto al primer entregable, se definió el proyecto que llevaremos a cabo durante 
todo el curso, el cual tiene como nombre “Calificame” y cuya definición se encontrará más 
adelante. Por otro lado, en lo que respecta al código y debido a que en la primera clase solo 
se abordaron temas introductorios a Kotlin, se desarrolló una breve simulación de lo que sería 
el proyecto.*/
/*                                        POSTWORK 1                                        */
fun main(){
    val productPrice = 200
    val productPrice2 = 150

    println("El precio del artículo es de $productPrice")


    val amount = productPrice + productPrice2 // la suma de los productos
    val tax = 1.16f //Aplicando el IVA

    val total = amount * tax; //Precio total con IVA
    println("El total a pagar es de $total pesos")


    //Datos del usuario
    val name = "Esiel"
    val uid = "5624-1245-4789"
    val gender = false
    val age = 23

    val isLegal = age>=18
    println("¿El usuario es mayor de edad? $isLegal")
}
