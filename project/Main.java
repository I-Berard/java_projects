public class Main {
    public static void main(String[] args) {
        try {
            Person p1 = new Student("Alice", 1, "Computer Science");
            Person p2 = new Teacher("Bob", 2, "Librarian");

            p1.displayInfo();  
            p2.displayInfo();

            Book b1 = new EBook("Java Basics", "PDF");
            Book b2 = new PrintedBook("OOP in Depth", 350);

            b1.showDetails();
            b2.showDetails();

            Library lib = new Library();

            try {
                lib.loadBooksFromFile("missing.txt"); 
            } catch (Exception e) {
                System.out.println("Caught checked exception: " + e);
            }

            try {
                lib.simulateRuntimeError(); 
            } catch (RuntimeException e) {
                System.out.println("Caught unchecked exception: " + e);
            }

            throw new Exception("Manual exception thrown!");
        } catch (Throwable t) {
            System.out.println("Caught Throwable: " + t.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
