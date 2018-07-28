package test;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LinkedMap {
	public static void main(String[] args) {
		Map<Character , Integer> lm = new LinkedHashMap<Character , Integer>();
		lm.put('c', 1);
		lm.put('a', 2);
		lm.put('m', 3);
		lm.put('b', 4);
		
		BigInteger big =  new BigInteger("11111111");
		BigInteger big1 = new BigInteger("222222");
		big.add(big1);
		System.out.println(big1);
		
		
		
		
//       Set<Character> set = lm.keySet();  
//       Iterator<Character> i = set.iterator();
//       while(i.hasNext()) {
//    	  System.out.print(i.next() + " ");
//       }
//		for(Map.Entry<Character, Integer> entry : lm.entrySet()) {
//			System.out.println(entry.getKey());
//			
//			
//		}
	}

}
