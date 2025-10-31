import java.util.*;

public class Merge {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = Arrays.asList(6,7,8,9,10);

        list1.addAll(list2);
        list1.forEach(System.out::println);
    }   
}
