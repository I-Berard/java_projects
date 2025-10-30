import java.util.*;

public class Confusing {
    public static class Student{
        public int age;
        public String name;

        public Student(int a, String b){
            age = a;
            name = b;
        }

        @Override
        public String toString(){
            return name + " - " + age;
        }
    }

    public static class sortByAge implements Comparator<Student>{
        @Override
        public int compare(Student a, Student b){
            return a.age - b.age;
        }
    }

    public static class sortByName implements Comparator<Student>{
        @Override
        public int compare(Student a, Student b){
            return a.name.compareTo(b.name);
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(23, "Mugabo"));
        list.add(new Student(12, "Kalisa"));
        list.add(new Student(45, "Teta"));
        list.add(new Student(32, "Maguello"));
        list.add(new Student(17, "Zazan"));
        list.add(new Student(16, "Zaza"));

        System.out.println(list);
        // Collections.sort(list, new Comparator<Student>() {
        //     @Override
        //     public int compare(Student arg0, Student arg1) {
        //         return (arg0.age % 10) - (arg1.age % 10);
        //     }
        // });

        Collections.sort(list, (a, b) -> b.age - a.age);
        System.out.println(list);
    }
}
