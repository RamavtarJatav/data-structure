package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
	Queue<Integer> conneQueue = new LinkedList<Integer>();

	public ConnectionPool() {
		for (int i = 0; i < 1; i++) {
			conneQueue.add(i);
		}
	}

	public void add(int connection) {
          
			conneQueue.add(connection);
			synchronized(this) {
            notifyAll();
			}
	         

		
	}
	
	

	public int get() {
		while (isEmpty()) {
			try {
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (this) {
			return conneQueue.remove();
		}
	}

	public boolean isEmpty() {
		return conneQueue.isEmpty();
	}

}
