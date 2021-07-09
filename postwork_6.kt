/*En la sesión 6, se abordaron temas sobre la interoperabilidad de Java y Kotlin, es decir, 
poder ocupar código escrito en Java en algún documento de Kotlin y viceversa.

En el proyecto, priorizamos la utilización de código escrito en Kotlin, sin embargo, requerimos 
el uso de la clase Date y FormatSimpleDate de las bibliotecas de java.utils y java.text 
respectivamente, para el uso de fechas y de su impresión en terminal de manera legible para los 
usuarios.*/
/*                                        POSTWORK 6                                        */
import java.text.NumberFormat
import java.util.Currency

/*Clase y función estatica escrita en Java*/
/*public class Utils {
    public static String FormatPrice(Float price) {
        NumberFormat currencyInstance NumberFormat.getCurrencyInstan();
        currencyInstance.setCurren(Currency.getInstance("MXN"));
        return currencyInstance.form(price);
    }
}*/

/*  Object y función escrita en kotlin, utilizando el método getCurrencyInstance
    de la clase abstracta NumberFormat y el método getInstance de la clase Currency,
    ambas de Java.
*/
object Utils {
    fun formatPrice(price: Float?): String {
        val currencyInstance = NumberFormat.getCurrencyInstance()
        currencyInstance.currency = Currency.getInstance("MXN")
        return currencyInstance.format(price)
    }
}

fun main() {
    println("El precio del iPhone 11 es: ${Utils.formatPrice(17_500f)}")
    println("El precio del iPhone 12 es: ${Utils.formatPrice(22_000f)}")
}