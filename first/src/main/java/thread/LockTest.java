package thread;

public class LockTest {
	void print() {
		System.out.println("you change nothing");
	}
	public static void main(String[] args) {
		
		LockTest lt = new LockTest();
		Lock lock = new Lock();
		try {
			lock.lock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   lt.print();
		   
				
	}

}
