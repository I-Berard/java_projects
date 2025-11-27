public class ConsumerProducerMain {
    public static void main(String[] args) {
        ProdCons pc = new ProdCons(1);
        Thread t1  = new Thread(() -> {
            for(int i = 0; i < 50; i++ ){
                try {
                    pc.produce(i);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2  = new Thread(() -> {
            for(int i = 0; i < 50; i++ ){
                try {
                    pc.consume();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
