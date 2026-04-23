
import java.util.regex.Pattern;

public class RegularExpression {
    public static boolean isUsername(String string){
        boolean isUsername = Pattern.compile("^[a-zA-Z0-9]{5,12}$").matcher(string).matches();
        return isUsername;
    }

    public static boolean isPin(String string){
        boolean isPin = Pattern.compile("^\\d{4}$").matcher(string).matches();
        return isPin;
    }

    public static boolean startsWithLetter(String string){
        boolean startsWithLetter = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9]*$").matcher(string).matches();
        return startsWithLetter;
    }

    public static boolean isEmail(String string){
        boolean isEmail = Pattern.compile("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,7}$").matcher(string).matches();
        return isEmail;
    }

    public static boolean isPhone(String string){
        boolean isPhone = Pattern.compile("^([+]?250\\d{9})|(07\\d{8})$").matcher(string).matches();
        return isPhone;
    }

    public static boolean isHexColor(String string){
        boolean isHexColor = Pattern.compile("^#([0-9A-Fa-f]{3}|[0-9A-Fa-f]{6})$").matcher(string).matches();
        return isHexColor;
    }

    public static boolean isURL(String string){
        boolean isURL = Pattern.compile("^(https?:\\/\\/)\\w+\\.\\w{2,}$").matcher(string).matches();
        return isURL;
    }
    public static void main(String[] args) {
        System.out.println(isUsername("irakoze23"));
        System.out.println(isPin("2341"));
        System.out.println(startsWithLetter("Hello123"));
        System.out.println(isEmail("irakozeberard@gmail.com"));
        System.out.println(isPhone("+250783423453"));
        System.out.println(isHexColor("#26ff00"));
        System.out.println(isURL("https://example.com"));   
    }
}
