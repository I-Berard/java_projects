public class SalaryAssignment {
    public static class Employee {
        public void calculateSalary(){
            System.out.println("I'm an employee");
        }
    }

    public static class FullTimeEmployee extends Employee {
        public void calculateSalary(){
            System.out.println("I'm a full time employee");
        }
    }

    public static class PartTimeEmployee extends Employee {
        public void calculateSalary(){
            System.out.println("I'm a part time employee");
        }
    }

    public static void main(String[] args) {
        Employee f1 = new FullTimeEmployee();
        Employee d1 = new PartTimeEmployee();
    
        f1.calculateSalary();
        d1.calculateSalary();
    }

}

