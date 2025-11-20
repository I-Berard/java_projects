package src.main.java.core;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static boolean sendHead(String fileUrl) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest headRequest = HttpRequest.newBuilder()
            .uri( new URI(fileUrl))
            .HEAD()
            .build();
        
        HttpResponse<Void> headerResponse = client.send(headRequest, BodyHandlers.discarding());

        Optional<String> contentLength = headerResponse.headers().firstValue("Content-Length");
        Optional<String> acceptRange = headerResponse.headers().firstValue("Accept-Ranges");
        System.out.println(acceptRange.get());

        if(contentLength.isPresent()){
            long size = Long.parseLong(contentLength.get());
            System.out.println("Server supports multipart downloading");
            return true;
        }else{
            System.out.println("Server doesn't support multipart download");
            return false;
        }
    }
    public static void main(String[] args) {
        try(Scanner c = new Scanner(System.in)){
            System.out.print("Input the url of the file you want to download: ");
            String fileUrl = c.nextLine();

            boolean response = sendHead(fileUrl);
            System.out.println(response);

            if(response){
                MultiPartDownloader.downloadFile(fileUrl);
            }else{
                SimpleHTTPDownloader.downloadFile(fileUrl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
