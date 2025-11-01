import java.io.*;

public class Student implements Serializable{
    public int age;
    public String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }
    
    public void print(){
        System.out.println(age + " " + name);
    }    
}
