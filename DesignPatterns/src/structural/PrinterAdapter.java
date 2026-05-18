package structural;

public class PrinterAdapter implements NewPrinter {
    OldPrinter oldPrinter;

    PrinterAdapter(OldPrinter oldPrinter){
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void printText(String message){
        oldPrinter.print(message);
    }
}
