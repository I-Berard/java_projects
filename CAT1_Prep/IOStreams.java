import java.io.*;

public class IOStreams {
    public static void main(String[] args) {
        try(DataInputStream input = new DataInputStream( new FileInputStream("primitives.txt"))){
            System.out.println(input.readInt());
            System.out.println(input.readUTF());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
