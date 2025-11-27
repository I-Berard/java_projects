import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BoyA implements Runnable {

	@Override
	public void run() {
		System.out.println("Boy thread has started");
		for (int i = 1; i <= 100; i++) {
			System.out.print("Boy :" + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println();
		System.out.println("Boy thread has completed");

	}

}

class Task implements Runnable {
	int num;

	public Task(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("Task number :" + num + " has started");
		for (int i = num; i < num * 5; i++) {
			System.out.print("  " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Task number :" + num + " has completed");
	}

}

class GirlA implements Runnable {

	@Override
	public void run() {
		System.out.println("Girl thread has started");
		for (int i = 1; i <= 100; i++) {
			System.out.print("Girl :" + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println();
		System.out.println("Girl thread has completed");

	}

}

public class ExecutorFramewrokDemo {
	public static void main(String[] a) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		/*
		 * executor.execute(new BoyA()); executor.execute(new Thread(new GirlA()));
		 */
		for (int i = 1; i <= 10; i++) {
			executor.execute(new Task(i));
		}
		executor.shutdown();
		/*
		 * for(int i=0;i<5;i++) { System.out.println("main values :"+i); }
		 */

	}

}
