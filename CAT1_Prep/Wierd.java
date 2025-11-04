public class Wierd {
    public interface InnerWierd {
        default void print(){
            System.out.println("hello world");
        }
    }
    
    public static class Stop implements InnerWierd{
        public static int x;

        static {
            x = 10;
        }

        // public void print(){
        //     System.out.println(x);
        // }
    }

    
    public static void main(String[] args) {
        Integer x = 10;
        // System.out.println(x.getClass().getSimpleName());

        double y = Math.sin(50);
        // System.out.println(y);

        String s1 = "hello";
        String s2 = s1;
        String s3 = "hello";
        String s4 = new String("hello");

        // System.out.printf("%x%n", System.identityHashCode(s1)); 
        // System.out.printf("%x%n", System.identityHashCode(s2)); 

        // System.out.println(s1 == s4); //prints true
        InnerWierd stop = new Stop();
        stop.print();
        
    }
}
