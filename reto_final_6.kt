import java.text.SimpleDateFormat
import java.util.*

fun main(){
    val now = Date()
    val formatDate = SimpleDateFormat("yyyy.MM.dd hh:mm:ss")
    println(formatDate.format(now))

    val iPhone = IPhone()

    println("precio sin impuesto: ${iPhone.price}")
    println("precio con impuesto: ${iPhone.priceWithTax()}")	

}



/* JAVA */
public class SmartPhone {
    private String name;
    private String model;
    private String processor;
    private float price;

    protected static int stock = 0;

    public SmartPhone(String name, String model, String processor, float price) {
        this.name = name;
        this.model = model;
        this.processor = processor;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public float getPrice() {
        return price;
    }
    public static int getStock() { return stock; }
    public static void minusStock() {
        stock--;
    }
    public static void restock(int quantity) {
        stock += quantity;
    }
}

public interface Taxable {
    float priceWithTax();
}

/* KOTLIN */
class IPhone : SmartPhone(
    21230.53F,
    "iPhone",
    "11 Pro",
    "A13 Bionic"
), Taxable {

    override fun priceWithTax(): Float {
        return price * 1.16f
    }

}