public class Factorial {
    public static void main(String[] args) {
        int num = 7;
        int fact = 1;

        for(int i = 1; i <= num; i++){
            fact *= i;
        }

        System.out.printf("The factorial of %d is %d",num ,fact);
    }
}
