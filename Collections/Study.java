public class Study {
    public static class Animal {
        public static int x;

        public Animal(int a) {
            x = a;
        }

        public void print(){
            System.out.println(x);
        }
    }   

    public static class Dog extends Animal{
        public Dog(int x){
            super(x);
        }

        public static void add(){
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Animal an = new Animal(4);
        Dog dog = new Dog(10);

        an.print();
        dog.print();
    }
}
