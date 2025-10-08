package zoo;
import animals.Animal;

public class Zookeeper extends Animal{
    public void display() {
        // Animal a = new Animal();
        System.out.println("animal name: " + name);
    }

    public static void main(String[] args) {
        Zookeeper z1 = new Zookeeper();
        z1.display();
    }
}
