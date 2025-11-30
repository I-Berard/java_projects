import java.util.regex.*;

public class AllMatches {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("foo|ber");
        Matcher matcher = pattern.matcher("foofoofoober");
        while(matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end() + "\n");
        }
    }
}
