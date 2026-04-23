import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("berard.txt");
            FileOutputStream out = new FileOutputStream("hello.txt", true)
        ){
            int content;
            while ((content=in.read()) != -1) { 
                out.write((byte)content);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}
