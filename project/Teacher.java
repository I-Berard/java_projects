public class Teacher extends Person {
    private String role;

    public Teacher(String name, int id, String role) {
        super(name, id);
        this.role = role;
    }

    @Override
    public void displayInfo() {
        System.out.println("Staff: " + getName() + ", Role: " + role);
    }
}
