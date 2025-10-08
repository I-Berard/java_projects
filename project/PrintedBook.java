public class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String title, int pages) {
        super(title);
        this.pages = pages;
    }

    @Override
    public void showDetails() {
        System.out.println("Printed Book: " + title + " (" + pages + " pages)");
    }
}
