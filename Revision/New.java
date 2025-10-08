import java.nio.file.*;
import java.util.stream.Stream;
import java.io.IOException;

public class New {
    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        // Files.lines(path).forEach(System.out::println);
        try(Stream<String> lines = Files.lines(path)){
            lines.forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
