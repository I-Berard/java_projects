public class Average {
    public static void main(String[] args) {
        int[] array = {1,2,3,6,4,3,5,4};
        float av = average(array);

        System.out.println(av);
    }   

    public static float average(int[] input){
        int sum = 0;
        for(int i : input){
            sum+=i;
        }
        return sum / input.length;
    }
}
