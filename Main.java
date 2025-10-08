public class Main {
    public static void print(Object msg) {
        System.out.println(msg);
    }
    
    
    public static void main(String[] args) {
        String[] cars = { "Volvo", "BMW", "Toyota", "Koenigsegg" };
        // printA(cars);
        for(String i : cars){
            console.log(i);
        }
        print("These are the best car models available");
    }
    
    public class console {
        public static void log(Object msg){
            System.out.println(msg);
        }
    }
}
// public static void printA(Object msg) {
//     if (msg instanceof int[]) {
//         int[] arr = (int[]) msg;
//         for (int i : arr) {
//             System.out.println(i);
//         }
//     } else {
//         System.out.println(msg);
//     }
// }