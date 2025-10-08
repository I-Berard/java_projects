public class Student extends Person {
    private String course;

    public Student(String name, int id, String course) {
        super(name, id);
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName() + ", Course: " + course);
    }
}
