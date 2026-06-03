import java.lang.reflect.Field;

public class Person {
    private String name;
    private double height;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }    

    public static void main(String[] args) {
        Person p = new Person();
        try {
            Field f = p.getClass().getDeclaredField("name");
            f.setAccessible(true);
            f.set(p, "berard");
            System.out.println(f.get(p));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}