import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class Book {
        private String title;
        private String author;
        private boolean isAvailable = true;
        
        public Book(String title, String author, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.isAvailable = isAvailable;
        }

        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public boolean isAvailable() {
            return isAvailable;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }        
       
    }

    public static class Person {
        public String name;
        public int Id;
        
        public Person(String name, int id) {
            this.name = name;
            Id = id;
        }

        public void displayInfo(){
            System.out.println("This is a person");
        }
    }

    public static class Staff extends Person {
        private List<Book> managedBooks = new ArrayList<>();

        public Staff(String name, int id){
            super(name, id);
        }

        public void manageBook(Book b, boolean add){
            if (add){
                managedBooks.add(b);
            }else{
                managedBooks.remove(b);
            }
        }  
        
        public void getManaged(){
            for(Book b : managedBooks){
                System.out.println(b);
            }
        }

        @Override
        public void displayInfo(){
            System.out.println("This is a staff member");
        }
    }

    public static class Student extends Person {
        public String department;

        public Student(String name, int id, String department) {
            super(name, id);
            this.department = department;
        }

        public String borrowBook(Book b1){
            if(b1.isAvailable){
                return "You can have " + b1.title + " written by " + b1.author;
            }else{
                return b1.title + " written by " + b1.author + " is not available.";
            }
        }

        @Override
        public void displayInfo(){
            System.out.println("This is a student");
        }
    }

    public static abstract class LibraryUser {
        public abstract String accessLibrary();
    }

    public static class StudentUser extends LibraryUser{
        @Override
        public String accessLibrary(){
            return "I'm accessing the library as a student";
        }

    }

    public static class StaffUser extends LibraryUser {
        @Override
        public String accessLibrary(){
            return "I'm accessing the library as a staff member";
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Angels and Demons", "Dan Brown", true);
        Book b2 = new Book("Inferno", "Dan Brown", false);
        if(b1.isAvailable == true){
            System.out.printf("The book is %s and it was written by %s\n", b1.title, b1.author);
        }

        Student s1 = new Student("Irakoze", 2198, "CyberSecurity");
        System.out.println(s1.borrowBook(b1));
        System.out.println(s1.borrowBook(b2));
        System.out.printf("%d, %s\n",s1.Id, s1.name);


        Person ps = new Student("Kellia", 72384, "3d Design");
        Person pst = new Staff("Larissa", 72342);

        ps.displayInfo();
        pst.displayInfo();
        

        LibraryUser l1 = new StudentUser();
        LibraryUser l2 = new StaffUser();

        System.out.println(l1.accessLibrary());
        System.out.println(l2.accessLibrary());

    }
}
