package core;

import app.models.DownloadItem;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class MultiPartDownloader {

    public static final int NUM_THREADS = 4;

    public static void downloadFile(String fileUrl, DownloadItem item) throws Exception {

        item.setStatus("Fetching server info...");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest headRequest = HttpRequest.newBuilder()
                .uri(new URI(fileUrl))
                .method("HEAD", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Void> headResponse =
                client.send(headRequest, HttpResponse.BodyHandlers.discarding());

        long fileSize = Long.parseLong(
                headResponse.headers().firstValue("Content-Length").orElseThrow()
        );

        item.setStatus("File size: " + fileSize / 1024 + " KB");

        String filename = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        Path outputDir = Paths.get(System.getProperty("user.home"), "Downloads");
        Files.createDirectories(outputDir);

        long partSize = fileSize / NUM_THREADS;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        CompletableFuture<?>[] futures = new CompletableFuture[NUM_THREADS];

        final long[] totalDownloaded = {0};

        item.setProgress(0);
        item.setStatus("Downloading in " + NUM_THREADS + " parts...");

        for (int i = 0; i < NUM_THREADS; i++) {

            final int partNum = i;
            long start = partNum * partSize;
            long end = (partNum == NUM_THREADS - 1) ? fileSize - 1 : (start + partSize - 1);

            Path partPath = outputDir.resolve(filename + ".part" + partNum);

            futures[i] = CompletableFuture.runAsync(() -> {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(new URI(fileUrl))
                            .header("Range", "bytes=" + start + "-" + end)
                            .GET()
                            .build();

                    client.send(request, HttpResponse.BodyHandlers.ofFile(partPath));

                    long partSizeDownloaded = Files.size(partPath);

                    synchronized (totalDownloaded) {
                        totalDownloaded[0] += partSizeDownloaded;
                        double progress = (double) totalDownloaded[0] / fileSize;
                        item.setProgress(progress);
                        item.setStatus("Downloading... " + (int) (progress * 100) + "%");
                    }

                } catch (Exception e) {
                    item.setStatus("Error in part " + partNum);
                    e.printStackTrace();
                }
            }, executor);
        }

        CompletableFuture.allOf(futures).join();
        executor.shutdown();

        item.setStatus("Merging parts..."); 
        Path finalFile = outputDir.resolve(filename);

        try (OutputStream out = new FileOutputStream(finalFile.toFile())) {
            for (int i = 0; i < NUM_THREADS; i++) {
                Path partPath = outputDir.resolve(filename + ".part" + i);
                Files.copy(partPath, out);
                Files.delete(partPath);

                double mergeProgress = (double) (i + 1) / NUM_THREADS;
                item.setProgress(mergeProgress);
                item.setStatus("Merging... " + ((i + 1) * 25) + "%");
            }
        }

        item.setProgress(1);
        item.setStatus("Completed");
    }
}
