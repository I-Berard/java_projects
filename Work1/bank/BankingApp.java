import java.io.Console;
import account.Accounts.*;
 

public class BankingApp{
    public static void main(String[] args) {
        Console console = System.console();

        String name = console.readLine("Enter your name: ");
        String dob = console.readLine("Enter your date of birth (2001-01-01): ");
        String accountNumber = console.readLine("Enter your account number: ");
        String _balance = console.readLine("Enter your initial balance: ");

        Account account = new Account(01, name, dob, accountNumber, Double.parseDouble(_balance));

        System.out.println("\n" + account + "\n");

        if(console == null){
            System.err.println("Unable to open the console");
            return;
        }

        do {
            System.out.println("\n==== Transaction interface ====");
            System.out.println("1. Withdraw cash");
            System.out.println("2. Deposit cash");
            System.out.println("3. Exit");

            String input = console.readLine("Input your choice: ");

            switch (Integer.parseInt(input)) {
                case 1:
                    try{
                        String withdrawAmount = console.readLine("\nEnter your withdrawal amount: ");
                        account.withDraw(Double.parseDouble(withdrawAmount));
                        break;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            
                case 2:
                    try{
                        String depositAmount = console.readLine("\nEnter your deposit amount: ");
                        account.deposit(Double.parseDouble(depositAmount));
                        break;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                case 3:
                    System.exit(0);
                default:
                    break;
            }
        }while(true);
    }
}