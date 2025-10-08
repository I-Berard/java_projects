public class VehicleAssignment {
    public static class Vehicle {
        public Vehicle(){
            System.out.println("Vehicle created !!");
        }

        public Vehicle(String input){
            System.out.println(input);
        }
    }

    public static class Car extends Vehicle{
        public Car(){
            super("Car Created");
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        
    }
}
