package test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
  public static void main(String[] args) {
      List<Long> al = new ArrayList<Long>();
	 // long[] al = new long[10000000];
	long startTime = System.currentTimeMillis();
	for(long i = 1000000 ; i < 11000000 ; i++) {
		//al.add(i);
		al.add(i);
	}
	long endTime = System.currentTimeMillis();
	System.out.println(endTime - startTime);
	
	
	
	//System.out.println((double)((endTime - startTime)/60000) );
 }
}
