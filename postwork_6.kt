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