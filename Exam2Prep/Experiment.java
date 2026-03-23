public class Experiment {
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(() -> {
            System.out.println("Task 2 running");
        });

        Thread t1 = new Thread(() -> {
            try {
                t2.join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 running after t2");
        });

        t2.start();
        t1.start();

        t1.join();
        System.out.println("t1 finished, now continuing...");

    }
}
