package parkinglot;

import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class Inmemory  implements  Operation {
	private List<Integer> e = new LinkedList<Integer>();
	private Map<Integer, Customer> f = new HashMap<Integer,Customer>();
	int size ;
	

	public int  getLocation() {
		int loc = e.remove(0);
		return loc;
		
		
	}

	public void freeLocation(int loc) {
		f.remove(loc);
		e.add(loc);
		
		
	}

	
	

}
