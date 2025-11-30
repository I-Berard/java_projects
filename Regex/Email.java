import java.util.regex.Pattern;

public class Email {
    public static boolean isEmail(String email){
        boolean isEmail = Pattern.compile(".+@.+\\..+").matcher(email).matches();
        return isEmail;
    }

    public static void main(String[] args) {
        System.out.println(isEmail("irakozeberard12@gmail.com"));
    }
}
