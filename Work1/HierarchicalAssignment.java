public class HierarchicalAssignment {
    public static class Vehicle {
        public void start(){
            System.out.println("I'm a vehicle");
        }
    }

    public static class Car extends Vehicle {
        public void start(){
            System.out.println("I'm a car");
        }
    }

    public static class Bicycle {
        public void start(){
            System.out.println("I'm a bicycle");
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        Bicycle b1 = new Bicycle();

        c1.start();
        b1.start();
    }
}
