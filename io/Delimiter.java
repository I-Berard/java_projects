import java.util.Scanner;

public class Delimiter {
    public static void main(String[] args) {
        String data = "Honorine turamuha bonbon 5";
        String data1 = "17/10/2025";
        Scanner scanner = new Scanner(data1);
        scanner.useDelimiter("/");
        int date = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.println("The sum is " + (date + month + year));
        scanner.close();
    }
}
