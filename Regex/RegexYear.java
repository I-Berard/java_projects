import java.util.regex.*;

public class RegexYear{
    public static void main(String[] args) {
        // Pattern p = Pattern.compile("ca");
        // Matcher m = p.matcher("rca");
        // System.out.println(Pattern.matches("[amn]*", "mn"));
        // System.out.println(Pattern.matches(".ca", "rca"));

        Pattern  p = Pattern.compile("\\d+");
        Matcher m = p.matcher("123ggh657");
        System.out.println(m.matches());
        
        while(m.find()){
            System.out.println(m.group());
        }

        Pattern p1 = Pattern.compile("^L\\w+\\d+$");
        Matcher m2 = p1.matcher("Langdon123");
        System.out.println(m2.matches());
        
        // boolean res = m.matches();
        
        // System.out.println(res);
        // // System.out.println(Pattern.matches("ca", "rca"));
        
        // boolean k = Pattern.compile("ca").matcher("rca").matches();
        // System.out.println(k);
    }
}