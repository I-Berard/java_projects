public class Square {
    public static void main(String[] args) {
        int num = 15;
        boolean isPrime = true;

        if(num <= 1){
            isPrime = false;
        }else{
            for(int i = 2; i <= (int)Math.sqrt(num); i++){
                if( num % i == 0){
                    isPrime = false;
                }
            }
        }

        if(isPrime){
            System.out.printf("%d is prime", num);
        }else{
            System.out.printf("%d is not prime", num);
        }
    }
}
