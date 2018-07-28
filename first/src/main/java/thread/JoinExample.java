package thread;

public class JoinExample {
	
	static class First implements Runnable{

		public void run() {
			System.out.println("first thread started");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("first thread ended");
			
		}
		
	}
	
	static class Second implements Runnable{

		public void run() {
			System.out.println("second thread started");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("second thread ended");
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread started");
		Thread t1 = new Thread(new First(), "t1");
		Thread t2 = new Thread(new Second(), "t2");
		t2.start();
		t1.start();
		t2.join();
	
		t1.join();
		
		System.out.println("main thread ended");
		
		
		
	}

}
