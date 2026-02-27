package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studentsjava")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String studentfirstname;

    @Column(nullable=false)
    private String studentlastname;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Computer> computers = new ArrayList<>();

    public void addComputer(Computer computer){
        computers.add(computer);
        computer.setStudent(this);
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public Student() {
    }

    public Student(int id, String studentfirstname, String studentlastname) {
        this.id = id;
        this.studentfirstname = studentfirstname;
        this.studentlastname = studentlastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentfirstname() {
        return studentfirstname;
    }

    public void setStudentfirstname(String studentfirstname) {
        this.studentfirstname = studentfirstname;
    }

    public String getStudentlastname() {
        return studentlastname;
    }

    public void setStudentlastname(String studentlastname) {
        this.studentlastname = studentlastname;
    }


}
