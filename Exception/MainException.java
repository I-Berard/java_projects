import java.util.InputMismatchException;
import java.util.Scanner;

public class MainException {

    public static int division(int a, int b) throws ArithmeticException, InputMismatchException {
        int result = a / b;
        return result;
    }
    public static void main(String[] args) {
        int x,y;
        Scanner c = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        x = c.nextInt();
        System.out.print("Enter the the second number: ");
        y = c.nextInt();

        try {
            System.out.println("The result is: " + division(x, y));
        }catch(ArithmeticException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
