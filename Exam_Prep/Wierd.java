import java.util.ArrayList;
import java.util.List;

public class Wierd {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
        list.add(null);
        try{
            int number = Integer.parseInt("234");
            // System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
