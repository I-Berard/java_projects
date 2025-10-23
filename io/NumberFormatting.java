import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatting {
    public static void main(String[] args) {
        double num = 50000.456;
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat frFormat = NumberFormat.getCurrencyInstance(Locale.ENGLISH);

        System.out.println("Us format: "+ usFormat.format(num) + " French format: " + frFormat.format(num));
    }
}
