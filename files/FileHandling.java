import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class FileHandling {
    public static void main(String[] args) {
        try(BufferedReader stream = new BufferedReader(new FileReader("output.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("destination.txt"))    
        ){
            String input = stream.readLine();
            out.write(input);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
