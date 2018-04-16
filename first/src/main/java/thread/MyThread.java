package thread;

public class MyThread extends Thread {
	MySignal mySignal;

	public MyThread(MySignal mySignal) {
		this.mySignal = mySignal;
	}

	public void run() {
		while(true) {
		while (!mySignal.isHasData()) {
			
      //   System.out.println("waiting " + Thread.currentThread());
		}
        
		mySignal.setHasData(false);
		System.out.println("running going to sleep" + Thread.currentThread());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("running  awake" + Thread.currentThread());
		
		mySignal.setHasData(true);
		}
	}

}
