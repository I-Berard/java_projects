public class Fibbonaci {
    public static void main(String[] args) {
        int series = decide(6);
        System.out.println(series);
    }

    public static int decide(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        return decide(n - 1) + decide(n - 2);
    }
}
