public class Test {
    public static void main(String[] args) {
        int num = test();
        System.out.println(num);
    }   

    public static int test(){
        try{
            return 1;
        }finally{
            return 2;
        }
    }
}
