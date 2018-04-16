package thread;

public class ThreadCon extends  Thread {
	ConnectionPool pl;
	ThreadCon(ConnectionPool pl){
		this.pl = pl;
	}
	public void run() {
		while(true) {
		int object= pl.get();
		System.out.println(Thread.currentThread()+ "working on="+ object);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pl.add(object);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	
		
		
	}
	

}
