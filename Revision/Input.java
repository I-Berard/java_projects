import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner b = new Scanner(System.in);

        System.out.print("Enter your name please: ");
        String name = b.nextLine();

        System.out.print("Enter your age: ");
        int age = b.nextInt();

        System.out.println("You are " + name + " and you are " + age + " years old.");
    }
}
