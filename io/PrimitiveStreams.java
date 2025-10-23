import java.io.*;

public class PrimitiveStreams {
    public static void main(String[] args) {
        File file = new File("primitives.dat");   
        try(DataInputStream reader = new DataInputStream(new FileInputStream(file))){
            // dos.writeInt(5);
            // dos.writeUTF("hello");
            // dos.writeBool(true);
            System.out.println(reader.readInt());
            System.out.println(reader.readUTF());
            System.out.println(reader.readBoolean());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
