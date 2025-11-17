import java.security.*;
import java.util.HexFormat;

public class SHA256Example {
    public static void main(String[] args) {
        try{
            String input = "password";

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(input.getBytes());

            String hashHex = HexFormat.of().formatHex(hashBytes);
            
            System.out.println("Input; " + input);
            System.out.println("Hash: " + hashHex);
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
