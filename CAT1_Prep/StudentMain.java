import java.io.*;
// import java.io.ObjectOutputStream;

public class StudentMain {
    public static void main(String[] args) {
        // Student std1 = new Student(12, "Landra");
        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream("employee.ser"))){
            Student std1 = (Student) out.readObject();
            std1.print();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
