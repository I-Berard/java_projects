package creational;

public class Application {
    public static void main(String[] args) {
        DBConnection connection = DBConnection.CONNECTION;
        connection.display();
    }
}
