import java.util.*;
public class PrinterJava {
    public static class Printer<T extends Number>{
        T valueToPrint;

        public Printer(T value){
            valueToPrint = value;
        }

        public void print(){
            System.out.println("Values: " + valueToPrint);
        }
    }

    public static void display(List<? extends Number> numbers){
        numbers.forEach(System.out::println);
    }
    public static void main(String[] args) {

        Printer<Double> printer = new Printer<>(5.5);
        printer.print();
        Printer<Long> printer1 = new Printer<>(3874923l);
        printer1.print();
        display(Arrays.asList(1,2,3,4,5,6));
        display(new ArrayList<>(Arrays.asList(3.4, 6.7, 3.4, 2.3)));
    }
}
