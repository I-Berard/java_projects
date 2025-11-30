import java.util.regex.Pattern;

public class Escaping {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("ca.");
        System.out.println(pattern.matcher("cat").find());
        Pattern pattern1 = Pattern.compile("ca\\."); // We use literals to indicat the . character
        System.out.println(pattern1.matcher("ca.").find());

        System.out.println(Pattern.compile("test[.\\\\]").matcher("test.").find()); // We used four of \ because java uses one pair to escape others
        System.out.println(Pattern.compile("test[^.a-z]").matcher("test1").find());
        System.out.println(Pattern.compile("[a-m[i-l]]").matcher("a9").find());
        System.out.println(Pattern.compile("[a-m&&[i-l]]").matcher("al").find());
        System.out.println(Pattern.compile("[a-z&&[^ab]]").matcher("i").matches());
        System.out.println(Pattern.compile("[\\w]").matcher("irakoze").find());
        System.out.println(Pattern.compile("cat\\d\\s").matcher("cat3 ").find());
        System.out.println(Pattern.compile("\\w").matcher("my cat").find());
        
    }
}
