public class EmployeeAssignment {
    public static class Employee{
        public void work(){
            System.out.println("Employee is working");
        }
    }
    public static class Manager extends Employee{
        public void conductMeeting(){
            System.out.println("Manager is conducting meeting");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Manager(); 

        Manager m1 = (Manager)e1;
        m1.conductMeeting();

        Manager m2 = new Manager();
        Employee e2 = (Employee) m2;

        e2.work();
    }
}
