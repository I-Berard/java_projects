import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class CallableTask implements Callable<String>{
	private String message;

	public CallableTask(String message) {

		this.message = message;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		return "the message is :"+ message;
	}
	
}




public class CallableClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService exxecutorService=Executors.newFixedThreadPool(1);
		List<CallableTask> tasks=List.of(new CallableTask("hello year 2 A"),new CallableTask("Hello Year 2 B"), new CallableTask("Hello Rca")); 
		//Future<String> msgFuture=exxecutorService.submit(new CallableTask("Hello class"));
		List<Future<String>> results=exxecutorService.invokeAll(tasks);
		System.out.println("callable executted");
		try {
			//String ourMessage=msgFuture.get();
			for(Future<String> res:results) {
			System.out.println("our message"+res.get() );
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exxecutorService.shutdown();
		System.out.println("hello main");

	}

}
