import java.util.*;
// import java.util.List;

public class CollectionsEtude {
    public static class Student {
        public int age;
        public String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public void print() {
            System.out.println(name + " " + age);
        }

        public String toString() {
            return age + " - " + name;
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "Melisa"));
        list.add(new Student(12, "Joshua"));
        list.add(new Student(8, "Florissa"));

        // Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student a, Student b){
                return b.age - a.age;
            }
        });
        System.out.println(list);
    }
}