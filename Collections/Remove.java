import java.util.ArrayList;
import java.util.List;

public class Remove {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("berard");
        list.add("kellia");
        list.add("hello");
        list.add("yuri");
        list.add("koslov");

        // for (String str : list){
        //     System.out.println(str);
        // }

        list.remove(2);

        System.out.println(list);
    }
}
