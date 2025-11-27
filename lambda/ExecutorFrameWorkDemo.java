import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task {
    int num;    

    public Task(int num) {
        this.num = num;
    }


    public int run(int numRows){
        System.out.println("Task " + num + " has started");
        for(int i = num; i< num * 10; i++){
            System.out.print(" " + i);
        }
        System.out.println("Task " + num + "is completed" );

        return numRows;
    }
}

public class ExecutorFrameWorkDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            Task task1 = new Task(5);
            int value = task1.run(5);
            System.out.println("Value returned by task: " + value);
        });
        executorService.execute(() -> {
            Task task1 = new Task(6);
            int value = task1.run(6);
            System.out.println("Value returned by task: " + value);
        });
        executorService.execute(() -> {
            Task task1 = new Task(7);
            int value = task1.run(7);
            System.out.println("Value returned by task: " + value);
        });
        
        executorService.shutdown();

    }   
}
