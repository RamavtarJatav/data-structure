package thread;

public class MySignal {
	private boolean hasData=true;

	public synchronized boolean isHasData() {
		return hasData;
	}

	public  synchronized  void setHasData(boolean hasData) {
		
		this.hasData = hasData;
		
	}
    
}
