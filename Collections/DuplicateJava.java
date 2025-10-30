import java.util.*;

public class DuplicateJava {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 6, 9, 3, 5, 4, 3);

        List<Integer> non = new ArrayList<>();
        List<Integer> duplicate = new ArrayList<>();

        for (int num : list){
            if(!non.contains(num)){
                non.add(num);
            }else if (non.contains(num) && !duplicate.contains(num)){
                duplicate.add(num);
            }
        }

        System.out.println(duplicate);

    }   
}
