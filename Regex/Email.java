import java.util.regex.Pattern;

public class Email {
    public static boolean isEmail(String email){
        boolean isEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z.-]+\\.[A-Za-z]{2,}$").matcher(email).matches();
        return isEmail;
    }

    public static void main(String[] args) {
        System.out.println(isEmail("irakozeberard12@gmail.com"));
    }
}
