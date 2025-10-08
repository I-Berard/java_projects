public class Main {
    public static class Computer {

        String brandName;

        public Computer(String brand){
            this.brandName = brand;
        }

        public static void display(){
            System.out.print("This is displaying from computer");
        }

        public static void playMusic(){
            System.out.print("Playing with computer");
        }        
    } 

    public static class Laptop extends Computer {
        String brandName = "Hp Laptop";

        public Laptop(){
            super("Computing Machine");
        }

        public static void playMusic(){
            System.out.print("Playing with HP laptop");
        }

        public String printBrand(){
            return super.brandName;
        }

        
    }  

    public static class DeskTop extends Computer {
        String brandName = "Dell Desktop";

        public DeskTop(){
            super("Computing Machine");
        }

        public static void playMusic(){
            System.out.print("Playing with HP laptop");
        }

        public String printBrand(){
            return super.brandName;
        }
    }

    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        DeskTop d1 = new DeskTop();
        
        System.out.println(l1.printBrand());
        System.out.println(l1.brandName);

        System.out.println(d1.printBrand());
        System.out.println(d1.brandName);
    }
}   
