import java.io.Console;
// import java.lang.reflect.Array;
import java.util.Arrays;

public class Cons {
    public static void main(String[] args) {
        Console console = System.console();

        if(console == null){
            System.err.println("Error opening the console");
            return;
        }

        String username = console.readLine("Enter your username: ");
        char[] password = console.readPassword("Enter your password: ");

        System.out.println("Your Username is: "+username);
        System.out.println("Your password: "+ new String(password));

        Arrays.fill(password, ' ');
    }
}
