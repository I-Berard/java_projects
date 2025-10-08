import java.io.*;

public class Library {

    public void loadBooksFromFile(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        fr.close();
    }

    public void simulateRuntimeError() {
        String str = null;
        System.out.println(str.length()); 
    }
}
