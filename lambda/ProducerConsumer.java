class Counter1{
    int count;
    boolean valueSet = false;
    public synchronized void put(int count){
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Put: " + count);
        this.count = count;
        valueSet = true;
        notify();
    }

    public synchronized void get(){
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get: " + count);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable{
    Counter1 count;

    public Producer(Counter1 counter){
        this.count = counter;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    @Override
    public void run(){
        int i = 0;
        while (true) {
            count.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    Counter1 count;

    public Consumer(Counter1 count){
        this.count = count;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    @Override
    public void run(){
        while (true) {
            count.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Counter1 c = new Counter1();
        new Producer(c);
        new Consumer(c);
    }    
}
