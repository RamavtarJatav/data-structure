package com.string;

import java.util.HashMap;
import java.util.Map;

public class PanDigitNumber {
	static boolean isPandigit(int d) {
		Map<Integer, Integer> sd = new HashMap<Integer, Integer>();
	
		int d1 = d;
		
		while(d1 != 0) {
			int r = d1%10;
			Integer c = sd.get(r);
			if(c == null) {
				sd.put(r, 1);
			}else {
				sd.put(r, c+1);
			}
			
		    d1 = d1/10;
		
			
		}
		
		for(Map.Entry<Integer, Integer> entry : sd.entrySet()) {
			System.out.print(entry.getKey() + "  " + entry.getValue() + "  ");
			if (entry.getValue() > 1) {
				return false;
			}
			
		}
		
		return true;
		
	}
	public static void main(String[] args) {
	   int d  = 2345566;
	   System.out.println(isPandigit(d));
	   
		
	}

}
