public class Reverse {
    static int[] array = {1,2,3,4,6};
    static int[] after = new int[array.length];
    public static void main(String[] args){
        for(int i = 0; i < array.length; i++){
            after[i] = array[array.length - i - 1];
        }

        for (int j : after){
            System.out.println(j);
        }
    }
}