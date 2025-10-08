public class PersonAssignment {
    public static class Person {
        public static void displayInfo(){
            System.out.println("I'm a person");
        }
    }
    public static class Student extends Person{
        public void showInfo(){
            super.displayInfo();
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.showInfo();
    }
}
