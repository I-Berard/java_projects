import java.io.*;
import java.net.*;

public class SimpleDownloader {
    public static void main(String[] args) throws Exception{
        String fileUrl = "https://raw.githubusercontent.com/github/explore/main/topics/java/java.png";
        String outputFile = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        // System.out.println(outputFile);

        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        FileOutputStream out = new FileOutputStream(outputFile);

        byte[] buffer = new byte[4096];
        int bytesRead;

        while((bytesRead = in.read(buffer)) != -1){
            out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.close();
        System.out.println("Download complete");
    }
}
