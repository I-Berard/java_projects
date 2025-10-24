import java.util.*;

public class Y2Collection {
    
    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>();
        c.add(49);
        c.add(52);
        c.add(35);
        c.add(1, 19);
        // c.remove(0);

        Collections.sort(c, new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return (a % 10) - (b % 10);
            }
        });

        System.out.println(c);
    }
}
