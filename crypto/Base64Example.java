import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String str = "Hello World";

        String encodedStr = Base64.getEncoder().encodeToString(str.getBytes());
        // System.out.println(encodedStr);

        // String decoded = new String(Base64.getDecoder().decode(encodedStr));
        // System.out.println(decoded);

        // byte[] decoded = Base64.getDecoder().decode(encodedStr);
        // for(byte b : decoded){
        //     System.out.print((char)b);
        // }
    }
}
