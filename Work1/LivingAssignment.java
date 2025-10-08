public class LivingAssignment {
    public static class LivingThing {
        public void breathe(){
            System.out.println("I'm breathiing");
        }
    }

    public static class Animal extends LivingThing {
        public void eat(){
            System.out.println("I'm eating");
        }
    }

    public static class Dog extends Animal {
        public void bark(){
            System.out.println("I'm barking");
        }
    }
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.bark();
        d1.eat();
        d1.breathe();        
    }
}
