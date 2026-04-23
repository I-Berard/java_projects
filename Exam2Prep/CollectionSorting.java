import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSorting {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(4, "Berard"));
        students.add(new Student(2, "irakoze"));
        students.add(new Student(1, "murasira"));
        students.add(new Student(9, "Hello"));
        students.sort(new Comparator<Student>() {
            public int compare(Student a, Student b){
                return a.age - b.age;
            }
        });
        Collections.sort(students, (a, b) -> a.name.compareTo(b.name));
        students.forEach(System.out::println);
    }
}

class Student {
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