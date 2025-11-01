public class Generics {
    public static class Teacher<T> {
        T var1;

        public Teacher(T a){
            this.var1 = a;
        }

        public T print(){
            return var1;
        }
    }

    public static <T extends Number> void printStuff(T a){
        System.out.println(a);
        // return a;
    }

    public static void main(String[] args) {
        Teacher<String> teach = new Teacher<>("Melissa");
        System.out.println(teach.print());
        printStuff(2);
    }
}
