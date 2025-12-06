import java.util.*;
import java.util.Comparator;

public class SelfStudy {
    public static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

        public void print(){
            System.out.println(age + " - " + name);
        }


        public String toString(){
            return age + " - " + name;
        }

        // @Override
        // public int compareTo(Person other){
        //     if(this.age < other.age){
        //         return 1;
        //     }else{
        //         return -1;
        //     }
        // }
    }    

    public static void main(String[] args) {
        Person p1 = new Person("Ange", 10);
        Person p2 = new Person("Heloise", 13);
        Person p3 = new Person("Berard", 9);
        System.out.println(p1);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Comparator<Person> comparator = new Comparator<Person>() {
            public int compare(Person a, Person b){
                if(a.age % 10 > b.age % 10){
                    return 1;
                }else{
                    return -1;
                }
                // return a.age - b.age;
            }
        };

        Collections.sort(list, comparator);

        // Collections.sort(list);

        System.out.println(list);
    }
}
