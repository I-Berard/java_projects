package core;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
// import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class SimpleHTTPDownloader {
    public static void downloadFile(String fileUrl) throws Exception {
        String output = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        // System.out.println(output);

        Path outputPath = Paths.get(System.getProperty("user.home"), "Downloads", output);
        // System.out.println(outputPath);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(fileUrl))
            .GET()
            .build();
        
        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(outputPath));

        System.out.println("Downloaded to: " + response.body());
    }

    public static void main(String[] args) {
        try{
            downloadFile("https://raw.githubusercontent.com/github/explore/main/topics/java/java.png");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}