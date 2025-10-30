public class PrinterJava {
    public static class Printer<T>{
        T valueToPrint;

        public Printer(T value){
            valueToPrint = value;
        }

        public void print(){
            System.out.println("Values: " + valueToPrint);
        }
    }

    public static void main(String[] args) {
        Printer<Double> printer = new Printer<>(5.5);
        printer.print();
        Printer<String> printer1 = new Printer<>("hello");
        printer1.print();
    }
}
