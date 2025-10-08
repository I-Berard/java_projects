public class Big {
    public static void main(String[] args){
        int[] array = {1,2,3,7,9,4};
        int max = 0;

        for(int i : array){
            if(i > max){
                max = i;
            }
        }

        System.out.println(max);
    }
}
