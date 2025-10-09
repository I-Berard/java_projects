import records.*;
import users.*;
import java.io.Console;


public class Main {
   public static void main(String[] args) {
    Console console = System.console();
    
    if(console == null){
        System.err.println("Error opening the console");
        return;
    }
    System.out.println("==== Welcome to our bank ====");
    System.out.println("=============================\n\n");
    System.out.println("Please choose");
    System.out.println("1. Create new account");
    System.out.println("2. Enter your account");
    String input = console.readLine("Input here: ");
    int choice = Integer.parseInt(input);

    switch (choice) {
        case 1:
            String _username = console.readLine("Enter your username: ");
            String _name = console.readLine("Enter your name: ");
            char[] _password = console.readPassword("Enter your password: ");
            User user = new User(_name, _username, new String(_password));
            user.saveUser();
            break;
        case 2:
            String name = console.readLine("Enter your name: ");
            String username = console.readLine("Enter your username: ");
            char[] password = console.readPassword("Enter your password: ");
            
            User loginUser = new User(name, username, new String(password));
            boolean authenticated = loginUser.authenticateUser();

            if(authenticated){
                char c = 'n';
                do{
                    System.out.println("===== Actions that you can do =====");
                    System.out.println("1. Check balance");
                    System.out.println("2. Transfer funds");
                    System.out.println("3. Be added to the ledger");
                    String _input = console.readLine("Input here");
                    int choose = Integer.parseInt(_input);

                    Records record = new Records(username, 10000L);

                    switch (choose) {
                        case 1:
                            Long bal = record.readBalance();
                            System.out.println("Your balance is " + bal);
                            break;
                    
                        case 2: 
                            String recipientsName = console.readLine("Enter the name of the recipient: ");
                            String _amount = console.readLine("Enter the amount to be transfered: ");
                            Long amount = Long.parseLong(_amount);
                            record.transfer(amount, recipientsName);

                            break;

                        case 3:
                            record.addUserToRecord();
                            break;
                        default:
                            break;
                    }
                    
                    

                    String ch = console.readLine("Continue or stop(y/n): ");
                    if (ch != null && !ch.isEmpty()) {
                        c = ch.charAt(0);
                    } else {
                        System.out.println("No input entered!");
                    }
                }while(c == 'Y' || c == 'y');
            }

            break;
        default:
            break;
    }
   } 
}
