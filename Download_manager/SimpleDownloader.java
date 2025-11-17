import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleDownloader {
    public static void main(String[] args) {
        String fileUrl = "https://raw.githubusercontent.com/github/explore/main/topics/java/java.png";
        String outputFile = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        System.out.println(outputFile);
    }
}
