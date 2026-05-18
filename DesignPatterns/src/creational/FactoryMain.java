package creational;

public class FactoryMain {
    public static void main(String[] args) {
        OperatingSystemFactory factory = new OperatingSystemFactory();
        OS os = factory.getInstance("closed");
        os.spec();
    }
}
