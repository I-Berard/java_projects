import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiPartDownloader {
   
    public static final int NUM_THREADS = 4;

    public static void downloadFile(String fileUrl) throws Exception{
        //Find the file size
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest headRequest = HttpRequest.newBuilder()
            .uri(new URI(fileUrl))
            // .method("HEAD", HttpRequest.BodyPublishers.noBody())
            .HEAD()
            .build();

        HttpResponse<Void> headResponse = client.send(headRequest, HttpResponse.BodyHandlers.discarding());

        Long fileSize = Long.parseLong(headResponse.headers().firstValue("Content-Length").orElseThrow());
        // System.out.println(fileSize);

        //Prepare location where to store and calculate ranges
        long partSize = fileSize / NUM_THREADS;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        CompletableFuture<?>[] futures = new CompletableFuture[NUM_THREADS];

        String filename = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        Path outputDir = Paths.get(System.getProperty("user.home"), "Downloads");
        Files.createDirectories(outputDir);

        //Download chunks
        for(int i = 0; i < NUM_THREADS; i++){
            final int partNumber = i;
            long start = partNumber * partSize;
            long end = (i == NUM_THREADS) ? fileSize - 1 : (start + partSize - 1);

            Path partPath = outputDir.resolve(filename + ".part" + partNumber);
            
            futures[i] = CompletableFuture.runAsync(() -> {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(fileUrl))
                        .header("Range", "bytes=" + start + "-" + end)
                        .GET()
                        .build();
                    
                    client.send(request, HttpResponse.BodyHandlers.ofFile(partPath));
                    System.out.println("Download part " + partNumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, executor);
        }

        // Wait for all the parts to finish downloading
        CompletableFuture.allOf(futures).join();
        executor.shutdown();

        //Merge all parts 
        Path finaleFile = outputDir.resolve(filename);
        try(OutputStream out = new FileOutputStream(finaleFile.toFile())){
            for( int i = 0; i< NUM_THREADS; i++){
                Path partPath = outputDir.resolve(filename + ".part" + i);
                Files.copy(partPath, out);
                Files.delete(partPath);
            }

            System.out.println("Merged into one file");
        }catch(Exception e){
            e.printStackTrace();
        }

    } 

    public static void main(String[] args) {
        try{
            downloadFile("https://raw.githubusercontent.com/github/explore/main/topics/java/java.png");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
