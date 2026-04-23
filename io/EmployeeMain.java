import java.io.*;

public class EmployeeMain {    
    public static void main(String[] args) throws ClassNotFoundException{
        File file = new File("employee.ser");
        // Employee em = new Employee("Irakoze", "Berard");
        File file2 = new File("employee1.ser");
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file2))){
            // Employee emp1 = new Employee("Ange", "Nziza");
            // out.writeObject(emp1);
            Employee emp2 = (Employee) in.readObject();
            System.out.println("First name: " + emp2.getfName() + " , LastName: " + emp2.getlName());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
        //     Employee em2 = (Employee)in.readObject();
        //     System.out.println("First name: " + em2.getfName() + " , LastName: " + em2.getlName());
        // }catch(IOException e){
        //     e.printStackTrace();
        // }
        // try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
        //     out.writeObject(em);
        // }catch(IOException e){
        //     e.printStackTrace();
        // }
    }
}

