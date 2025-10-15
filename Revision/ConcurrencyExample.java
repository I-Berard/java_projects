public class ConcurrencyExample {
    static class Task extends Thread {
        private String name;

        public Task(String name){
            this.name = name;
        }

        public void run(){
            for(int i = 1; i <= 5 ; i++){
                System.out.println(name + " - Step " + i);
                try{
                    Thread.sleep(500);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task("Download Task ...");
        Task task2 = new Task("File writing task...");

        task1.start();
        Thread.sleep(200);
        task2.start();

        System.out.println("Main thread finished starting tasks...");
    }
}
