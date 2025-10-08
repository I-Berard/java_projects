import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("output.txt", true)){ // the true makes the writer be able to append instead of overwiting
            writer.write("Hello, Java input and output\n");
            writer.write("This is a new line\n");
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
