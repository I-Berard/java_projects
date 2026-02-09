
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("abc123xyz345");
        if(m.find()){
            System.out.println(m.find());
            System.out.println(m.group());
        }
    }   
}
