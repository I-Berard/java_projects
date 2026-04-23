public class WeirdFormatting {
    interface interestingly {
        void m2();
        void m3();
        default void interesting(){
            System.out.println("Thats good");
        }
        static void notinteresting(){
            System.out.println("hello");
        }
    }

    enum Computer implements interestingly{
        HP(400),
        DELL(800),
        LENOVO(700);

        int price;

        Computer(int price){
            this.price = price;
        }

        public int getPrice(){
            return price;
        }

        public void m2(){
            System.out.println("This is m2");
        }

        public void m3(){
            System.out.println("This is m3");
        }
    }

    public static void main(String[] args) {
        Computer c = Computer.DELL;
        System.out.println("Our computer is " + c.name() + " " + c.getPrice());
        System.out.println(c);
    }
    
}
