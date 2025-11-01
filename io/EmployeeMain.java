import java.io.*;

public class EmployeeMain {    
    public static void main(String[] args) throws ClassNotFoundException{
        File file = new File("employee.ser");
        // Employee em = new Employee("Irakoze", "Berard");
        
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            Employee em2 = (Employee)in.readObject();
            System.out.println("First name: " + em2.getfName() + " , LastName: " + em2.getlName());
        }catch(IOException e){
            e.printStackTrace();
        }
        // try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
        //     out.writeObject(em);
        // }catch(IOException e){
        //     e.printStackTrace();
        // }
    }
}

