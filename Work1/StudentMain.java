public class StudentMain {
    public static class Student {
        private String lastName;
        private String firstName;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setFirstName( "Irakoze");
        s1.setLastName("Berard");
        System.out.println(s1.getFirstName());
        System.out.println(s1.getLastName());
        
    }
}

