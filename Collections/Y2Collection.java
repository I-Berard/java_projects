import java.util.*;

public class Y2Collection {
    
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        c.add(4);
        c.add(5);

        Iterator<Integer> It = c.iterator();
        while(It.hasNext()){
            int value = It.next();
            System.out.println(value);
        }
        
    }
}
