public class Recursion {
    public static void main(String[] args){
        int result = sum(20);
        Main.console.log(result);
    }
    public static int sum(int x){
        if(x > 0){
            return x + sum(x - 1);
        }else{
            return 0;
        }
    }
}
