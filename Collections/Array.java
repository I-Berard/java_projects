import java.util.*;

public class Array {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(123);
        list.add('d');

        int x = (Integer)list.get(0);
        System.out.println(x);

        char c = (char)list.get(1);
        System.out.println(c);

        // System.out.println(list);
        // list.forEach(System.out::print);
        list.forEach(e -> System.out.println(e));
    }
}
