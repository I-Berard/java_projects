import java.io.*;
import java.util.Scanner;

public class IOStream {
    public static void main(String[] args) {

        // try(PrintWriter writer = new PrintWriter(new FileWriter("output.txt", true))){
        //     writer.println("Wake up !!");
        //     writer.println("Still in java !!!");
        // }catch(IOException e){
        //     e.printStackTrace();
        // }

        Scanner c = new Scanner(System.in);
        System.out.print("Enter the data you want to write in a file (type 'exit' to quit): ");
        String line;
        while (c.hasNext()) {
            line = c.nextLine();
            if(line.equalsIgnoreCase("exit")) break;            
            System.out.println("Entered line: " + line);
            System.out.print("Enter the data you want to write in a file (type 'exit' to quit): ");
        }
        c.close();
    }
}

