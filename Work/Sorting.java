public class Sorting {
    public static void main(String[] args) {
        int[] array = {1,2,3,6,4,3,5,4};
        int[] sorted = sort(array);

        for(int i : sorted){
            System.out.println(i);
        }
    }

    public static int[] sort(int[] input) {
        int n = input.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    swap(input, j, j + 1);
                }
            }
        }
        return input;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
