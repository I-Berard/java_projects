package core;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleHTTPDownloader {

    public static void downloadFile(String fileUrl, app.models.DownloadItem item) throws Exception {
        String output = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        Path outputPath = Paths.get(System.getProperty("user.home"), "Downloads", output);

        HttpClient client = HttpClient.newHttpClient();

        // HEAD request to get file size
        HttpRequest headRequest = HttpRequest.newBuilder()
            .uri(new URI(fileUrl))
            .method("HEAD", HttpRequest.BodyPublishers.noBody())
            .build();

        HttpResponse<Void> headResponse = client.send(headRequest, HttpResponse.BodyHandlers.discarding());
        long fileSize = Long.parseLong(headResponse.headers().firstValue("Content-Length").orElse("0"));

        item.setFileName(output);
        item.setStatus("Downloading...");

        // GET request
        HttpRequest downloadRequest = HttpRequest.newBuilder()
            .uri(new URI(fileUrl))
            .GET()
            .build();

        HttpResponse<InputStream> response =
            client.send(downloadRequest, HttpResponse.BodyHandlers.ofInputStream());

        try (InputStream in = response.body();
             OutputStream out = Files.newOutputStream(outputPath)) {

            byte[] buffer = new byte[8192];
            long totalRead = 0;
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                totalRead += bytesRead;

                double progress = (double) totalRead / fileSize;
                item.setProgress(progress);   // UI will auto-update if using Observable properties
            }
        }

        item.setStatus("Completed");
        item.setProgress(1.0);
    }

    public static void main(String[] args) {
        try {
            downloadFile(
                "https://raw.githubusercontent.com/github/explore/main/topics/java/java.png",
                new app.models.DownloadItem(null)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
