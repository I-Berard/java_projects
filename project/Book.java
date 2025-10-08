public abstract class Book {
    protected String title;

    public Book(String title) {
        this.title = title;
    }

    public abstract void showDetails();
}
