public class AnimalAssignment {
    public static class Animal {
        public void call(){
            System.out.println("Animal");
        }
    }

    public static class Dog extends Animal{
        public void bark(){
            System.out.println("I'm barking");
        }
    }
    public static void main(String[] args) {
        Animal d1 = new Dog();

        Dog d2 = (Dog) d1;
        d2.bark();
    }
}
