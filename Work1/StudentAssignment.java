public class StudentAssignment {
    public static class Student {
        public static int count;

        public Student(){
            count++;
        }

        public static void displayCount(){
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        Student.displayCount();
    }
}
