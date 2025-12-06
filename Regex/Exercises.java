import java.util.regex.Pattern;

public class Exercises {
    public static boolean isLowerCase(String string){
        boolean isLowerCase = Pattern.compile("^[a-z]+").matcher(string).matches();
        return isLowerCase;
    }

    public static boolean isThreeDigits(String string){
        boolean isThreeDigits = Pattern.compile("[0-9]{3}").matcher(string).matches();
        return isThreeDigits;
    }

    public static boolean startsWithA(String string){
        boolean startsWithA = Pattern.compile("^a.+z$").matcher(string).matches();
        return startsWithA;
    }

    public static boolean isImage(String string){
        boolean isImage = Pattern.compile("^.+\\.(jpg|png)$").matcher(string).matches();
        return isImage;
    }

    public static boolean isPhoneNumber(String string){
        boolean isPhoneNumber = Pattern.compile("\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]\\d{4}").matcher(string).matches();
        return isPhoneNumber;
    }

    public static boolean isHexColorCode(String string){
        boolean isHexColorCode = Pattern.compile("^(#[0-9a-fA-F]{3}|#[0-9a-fA-F]{6})$").matcher(string).matches();
        return isHexColorCode;
    }

    public static void main(String[] args) {
        System.out.println(isLowerCase("hello"));
        System.out.println(isThreeDigits("234"));
        System.out.println(startsWithA("aasderz"));
        System.out.println(isImage("hello.png"));
        System.out.println(isPhoneNumber("123-456-7890"));
        System.out.println(isPhoneNumber("(123) 456-7890"));
        System.out.println(isPhoneNumber("123 456 7890"));
        System.out.println(isPhoneNumber("123.456.7890"));
        System.out.println(isHexColorCode("#FFF"));
    }
}
