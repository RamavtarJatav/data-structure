package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EXecuterServiceUses {
	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(4);
		ex.execute(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub

			}

		});
		
		
		ex.hashCode();
		
		
	}

}
