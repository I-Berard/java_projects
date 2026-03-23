import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    public static void main(String[] args) throws IOException  {
        Socket socket = new Socket("10.12.73.108", 5000);
        Scanner keyboard = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println(in.readLine());
        String userName = keyboard.nextLine();
        out.println(userName);

        Thread readThread = new Thread(()->{
            while(true){
                String message;
                try {
                    while((message = in.readLine()) != null){
                        System.out.println(message);
                    }
                } catch(IOException e){
                    System.out.println("Error reading input : " + e.getMessage());
                    break;
                }
            }
        });

        Thread writeThread = new Thread(()->{
            while(true){
                String message = keyboard.nextLine();
                out.println(message);
                if("bye".equalsIgnoreCase(message)){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        System.out.println("failed to close socket : " + e.getMessage());
                    }
                    break;
                }
            }
        });

        readThread.start();
        writeThread.start();
    }
}
