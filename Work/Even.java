public class Even {
    public static void main(String[] args){
        int i = 2;
        while (i <= 20 && i % 2 == 0) {
            System.out.println(i);
            i += 2;   
        }
    }
}
