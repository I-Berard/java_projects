// class Boy implements Runnable{
//     public void run(){
//         for(int i = 0; i < 20; i++){
//             System.out.println("Boy");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class Girl implements Runnable{
//     public void run(){
//         for(int i = 0; i < 20; i++){
//             System.out.println("Girl");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

class Counter{
    int count;
    public synchronized void increment() {
        count++;
    }
}

public class MultiplierMain {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable counter1 = () -> {
            for(int i = 0; i < 500; i++){
                counter.increment();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("From thread 1 " + counter.count);
        };

        Runnable counter2 = () -> {
            for(int i = 0; i < 500; i++){
                counter.increment();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("From thread 2 " + counter.count);
        };

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);

        t2.start();
        t1.start();

        t1.join();
        t2.join(); //Waiting for both the threads to finish execution so that we can use what they've changed

        System.out.println(counter.count);
    }
}
