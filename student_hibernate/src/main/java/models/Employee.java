package models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person{
    private double salary;
    private String qualifications;

    public Employee(double salary, String qualifications) {
        this.salary = salary;
        this.qualifications = qualifications;
    }

    public Employee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", qualifications='" + qualifications + '\'' +
                '}';
    }
}
