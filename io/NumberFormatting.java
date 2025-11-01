import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatting {
    public static void main(String[] args) {
        double num = 50000.456;
        NumberFormat usFormat = NumberFormat.getNumberInstance(Locale.US);
        NumberFormat frFormat = NumberFormat.getNumberInstance(Locale.FRENCH);

        System.out.println("Us format: "+ usFormat.format(num) + " French format: " + frFormat.format(num));
    }
}
