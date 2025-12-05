public class StringStudy {

    static class User{
        public String name;
        
        public void setName(String input){
            name = input;
        }

        public void getName(){
            System.out.println(name);
        }

        public void test(){
            System.out.println("Parent testing");
        }
    }
    
    static class Student extends User {
        public int age;
        
        public void setAge(int age){
            this.age = age;
        }
        
        public void getAge(){
            System.out.println(age);
        }

        public void test(){
            System.out.println("Student testing");
        }
    }

    static class Teacher extends User {
        public int id;

        public void setId(int id){
            this.id = id;
        }

        public void getId(){
            System.out.println(id);
        }
    }
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";

        // String s3 = new String("hello");

       User student = new User();
       student.test();
    }
}
