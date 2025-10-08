public class Search {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,4,7};
        int element = 4;

        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                System.out.printf("The element is at position %d \n", i + 1);
            }
        }
    }
}
