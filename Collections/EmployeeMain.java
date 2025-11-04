import java.util.*;

public class EmployeeMain {
    public static class Employee implements Comparable<Employee> {
        private String firstName;
        private String lastName;
        private int age;
        private int salary;

        public Employee(String firstName, String lastName, int age, int salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
            result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
            result = prime * result + age;
            result = prime * result + salary;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Employee other = (Employee) obj;
            if (firstName == null) {
                if (other.firstName != null)
                    return false;
            } else if (!firstName.equals(other.firstName))
                return false;
            if (lastName == null) {
                if (other.lastName != null)
                    return false;
            } else if (!lastName.equals(other.lastName))
                return false;
            if (age != other.age)
                return false;
            if (salary != other.salary)
                return false;
            return true;
        }

        public int compareTo(Employee other) {
            return Integer.compare(other.salary, this.salary);
        }

        @Override
        public String toString() {
            return "Employee [firstname=" + firstName + ", lastname=" + lastName + ", age=" + age + ", salary=" + salary
                    + "]";
        }
    }

    public static class SortAge implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return Integer.compare(a.getAge(), b.getAge());
        }
    }

    public static void main(String[] args) {
        // List<Employee> list = new ArrayList<>();
        // list.add(new Employee("Florence", "Wihogora", 16, 1000));
        // list.add(new Employee("Amani", "Samuel", 20, 2000));
        // list.add(new Employee("Gold", "Gold", 17, 1500));

        // // Collections.sort(list, new SortAge());
        // // System.out.println(list);

        // Comparator<Employee> comp = new Comparator<Employee>() {
        // @Override
        // public int compare(Employee a, Employee b){
        // if(a.getSalary() < b.getSalary()){
        // return 1;
        // }else{
        // return -1;
        // }
        // }
        // };

        // // Collections.sort(list, comp);
        // // System.out.println(list);

        // Collections.sort(list);
        // list.forEach(System.out::println);

        Employee emp1 = new Employee("Florence", "Wihogora", 16, 1000);
        Employee emp2 = new Employee("Florence", "Wihogora", 16, 1000);

        Set<Employee> set = new HashSet<>();
        set.add(emp1);
        set.add(emp2);

        System.out.println(emp1.equals(emp2));
        System.out.println(set.size());

        // Map<Employee, String> map = new HashMap<>();
        // map.put(emp1, "first value");
        // map.put(emp2, "duplicate value");

        // System.out.println(map);
    }
}
