package structural;

public class AdapterMain {
    public static void main(String[] args) {
        NewPrinter newPrinter = new PrinterAdapter(new OldPrinter());
        newPrinter.printText("Hello");

        NewPrinter newPrinter1 = System.out::println;
    }
}
