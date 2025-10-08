public class Count {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        int odd = 0;
        int even = 0;

        for(int i : array){
            if(i % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        System.out.printf("Even numbers are %d and odd numbers are %d", even, odd);
    }

}