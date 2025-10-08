import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Abstract {
    @FunctionalInterface
    public interface Add<T> {
        public int add(T a, T b );
    }

    public static class Person{
        int age;
        String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString(){
            return this.name + " - " + this.age;
        }
    }

    public static void main(String[] args) {
        Add<Integer> sum = (Integer x, Integer y) -> x + y;
        System.out.println(sum.add(8, 9));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4));

        List<String> names = Arrays.asList("Irakoze", "Berard", "Murasira", "Bible");
        names.forEach(System.out::println); 

        List<Person> people = List.of(
            new Person( 7, "Kellia"),
            new Person(8, "Kagabo")
        );

        people.forEach(System.out::println);
    }
}