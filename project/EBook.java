public class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String fileFormat) {
        super(title);
        this.fileFormat = fileFormat;
    }

    @Override
    public void showDetails() {
        System.out.println("E-Book: " + title + " [" + fileFormat + "]");
    }
}
