package com.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrintNonrepeated {
	static void nonRepeated(String s) {
		Map<Character , Integer> sM = new LinkedHashMap<Character , Integer>(); 
		Integer  c = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			c = sM.get(s.charAt(i));
			if(c == null) {
				sM.put(s.charAt(i), 1);
			}else {
				sM.put(s.charAt(i), c+1);
			}
			
		}
		
		for(Map.Entry<Character, Integer> chMap : sM.entrySet()) {
		    if(chMap.getValue() == 1) {
		    	System.out.print(chMap.getKey());
		    }
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		String s = "ramavtar";
		nonRepeated(s);
		
		
	}

}
