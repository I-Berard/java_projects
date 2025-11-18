import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static long sendHead(String fileUrl) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest headRequest = HttpRequest.newBuilder()
            .uri( new URI(fileUrl))
            .HEAD()
            .build();
        
        HttpResponse<Void> headerResponse = client.send(headRequest, BodyHandlers.discarding());

        Optional<String> contentLength = headerResponse.headers().firstValue("Content-Length");

        if(contentLength.isPresent()){
            long size = Long.parseLong(contentLength.get());
            System.out.println("Server supports multipart downloading");
            return size;
        }else{
            System.out.println("Server doesn't support multipart download");
            return -1;
        }
    }
    public static void main(String[] args) {
        try(Scanner c = new Scanner(System.in)){
            System.out.print("Input the url of the file you want to download: ");
            String fileUrl = c.nextLine();

            Long response = sendHead(fileUrl);
            System.out.println(response);
            
            if(response == -1){
                MultiPartDownloader.downloadFile(fileUrl);
            }else{
                SimpleHTTPDownloader.downloadFile(fileUrl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
