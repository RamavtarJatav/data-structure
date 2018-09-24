package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest implements Callable<Integer>{
    int x;
    int y;
	CallableTest(int x , int y){
		this.x = x;
		this.y = y;
	}
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return x+y;
	}
	
	public static void main(String[] args) {
		CallableTest callableTest = new CallableTest(1 ,2);
		ExecutorService executor = Executors.newFixedThreadPool(10); 
		Future<Integer> fu = executor.submit(callableTest);
		try {
			System.out.println(fu.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
