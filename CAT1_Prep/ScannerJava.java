import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerJava {
    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)){
            String input = s.nextLine();
            System.out.println(input);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
