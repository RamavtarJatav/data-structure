package elevator;

import java.util.LinkedList;
import java.util.Queue;

public class CommonStorage {
	private Queue<Integer> quUP = new LinkedList<Integer>();
	private Queue<Integer> qudown = new LinkedList<Integer>();
	
	
	Integer popupsyn() throws InterruptedException{
		synchronized(this){
			if(quUP.isEmpty()) {
				wait();
			}
			
			
		}
		return null;
	}
	
	Integer popdwnsyn() throws InterruptedException{
		synchronized(this){
			if(quUP.isEmpty()) {
				wait();
			}
			
			
		}
		return null;
	}
	
	Integer pushup(Integer signal) throws InterruptedException{
		synchronized(this){
			
		}
		return null;
	}
	Integer pushdwn(Integer signal) throws InterruptedException{
		synchronized(this){
			
		}
		return null;
	}
	
	

}
