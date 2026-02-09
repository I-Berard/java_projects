package models;

public class Student {
    private String id;
    private String studentFirstName;
    private String studentLastName;

    public Student(){

    }

    public Student(String id, String studentFirstName, String studentLastName){
        this.id = id;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
}
