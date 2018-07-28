package connectionpool;

import java.util.LinkedList;
import java.util.Queue;

public class Resource {
	private Queue<Integer> q = new LinkedList<Integer>();
	private int count = 0;
	
	public Integer remove() throws InterruptedException {
	    int data = 0;
            if(q.isEmpty()) {
                synchronized(this) {
                	System.out.println("queue is empty so going into wait mode " + Thread.currentThread());
                	wait();
            	}
            	
            }else {
            	synchronized(this) {
            		
            		data = q.remove();
            		System.out.println("removed from the data = " + data + " " + Thread.currentThread());
            		notifyAll();
            	    
            	}
            }
			return data;
	}
	
	
	public void add() throws InterruptedException {
		synchronized(this) {
		if(q.size() == 8) {
			   System.out.println("Queue is full so going into wait mode " + Thread.currentThread());
				wait();
			}else {
				System.out.println("Creating new data = "+ count +" " + Thread.currentThread());
				q.add(count++);
				notifyAll();
			}
		}
	}

}
