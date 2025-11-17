import java.io.*;
import java.net.*;

public class SimpleDownloader {
    public static void main(String[] args) throws Exception{
        String fileUrl = "https://raw.githubusercontent.com/github/explore/main/topics/java/java.png";
        String outputFile = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        // System.out.println(outputFile);

        URI uri = new URI(fileUrl); // This allows you to create a url instance, it provides different methodologies for different things
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Here you are making a connection to the server and casting it to an HTTP cause you know that it is already http(s)
        InputStream in = connection.getInputStream(); // This is a method that allows you to get the data from the server
        FileOutputStream out = new FileOutputStream(outputFile); // Open an outputstream

        byte[] buffer = new byte[4096];
        int bytesRead;

        while((bytesRead = in.read(buffer)) != -1){ // read and return the value of bytes read
            out.write(buffer, 0, bytesRead); // write bytes from 0 to bytesRead to file
        }

        in.close();
        out.close();
        System.out.println("Download complete");
    }
}
