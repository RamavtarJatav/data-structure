package thread;

public class Work {
	 
		
	
	public static void main(String[] args) {
		MySignal mySignal = new MySignal();
		MyThread mythread1 = new MyThread(mySignal);
		MyThread mythread2 = new MyThread(mySignal);
		mythread1.start();
		mythread2.start();
		
	}

}
