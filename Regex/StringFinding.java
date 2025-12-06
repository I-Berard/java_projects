import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFinding {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\w.").matcher("bd");
        System.out.println(matcher.matches());
    }
}
