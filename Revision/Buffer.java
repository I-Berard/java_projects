import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Buffer {
    public static void main(String[] args) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))){
            writer.newLine();
            writer.write("Welcome to my youtube channel\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }   
}
