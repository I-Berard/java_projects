import java.io.*;

public class Employee implements Serializable {
    private String fName;
    private String lName;
    public Employee(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getlName() {
        return lName;
    }
    
}
