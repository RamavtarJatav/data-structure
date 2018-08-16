package thread;

public class NewThread extends Thread {
	
	NewThread(String thredName, ThreadGroup tg){
		super(tg, thredName);
		start();
	}
	
	public void run(){
		for(int i= 0 ; i < 1000 ; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Exception ocurred");
			}
		}
		System.out.println("Finished Executing " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		ThreadGroup gfg = new ThreadGroup("gfg");
		NewThread nt = new NewThread("first" , gfg);
		NewThread nt2 = new NewThread("second", gfg);
		gfg.checkAccess();
		System.out.println("Number of executing thread group" + gfg.activeCount());
		
	}

}
