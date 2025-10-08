public class Person {
    String name;
    int age;

    public Person(){
        this("Unknown", 0);
    }

    public Person(String name){
        this(name, 0);
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println("This person is called " + name + " and the age is " + age);
    }
}
