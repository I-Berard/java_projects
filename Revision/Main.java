import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader fis = new BufferedReader(new FileReader("input.txt"))){
            String data;
            while((data = fis.readLine()) != null){
                System.out.println(data);
            }
        }catch(IOException e){
            // System.out.println();
            e.printStackTrace();
        }
    }
}
