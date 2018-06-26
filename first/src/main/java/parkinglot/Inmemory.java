package parkinglot;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Inmemory  implements  Operation {
	private Queue<Integer> e = new LinkedList<Integer>();
	private Set<Integer> f = new HashSet<Integer>();
	int size ;
	

	public int  getLocation() {
		int loc = e.remove();
		return loc;
		
		
	}

	public void freeLocation(int loc) {
		f.remove(loc);
		e.add(loc);
		
		
	}

	
	

}
