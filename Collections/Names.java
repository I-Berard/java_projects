import java.util.*;

public class Names {
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

        list.forEach((x) -> System.out.println(x));
    }
}
