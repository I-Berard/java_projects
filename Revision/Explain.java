import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Explain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Berard");
        list.add("Irakoze");
        list.add("Berard");

        // System.out.println(list);

        Set<String> set = new HashSet<>();
        set.add("Berard");
        set.add("Mutesi");
        set.add("Berard");

        // System.out.println(set);

        Map<String, Integer> map = new HashMap<>();

        map.put("Berard", 16);
        map.put("Gasore", 30);
        map.put("larissa", 40);

        System.out.println(map);
    }   
}
