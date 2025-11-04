import java.io.IOException;
import java.util.Scanner;

public class Study {
    public static void main(String[] args) throws ArithmeticException {
        System.out.println("start");
        // int quo = 3 / 0;
        // System.out.println(quo);
 
        try (Scanner scanner = new Scanner(System.in)) {
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            if(denominator == 0){
                throw new ArithmeticException("Division with zero is prohibited");
            }
            int quo = numerator / denominator;
            System.out.println(quo);
            
        } catch (Exception e) {
            System.out.println("division by zero");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
