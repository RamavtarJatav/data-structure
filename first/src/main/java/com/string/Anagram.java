package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Anagram {
	static boolean checkAnagram(String s1, String s2) {
		Set<Character> chSet = new HashSet<Character>();
		for (int i = 0; i < s1.length(); i++) {
			chSet.add(s1.charAt(i));
		}

		for (int i = 0; i < s2.length(); i++) {
			if (!chSet.contains(s2.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	static boolean checkAnagramDup(String s1, String s2) {
		Map<Character, Integer> hashS1 = new HashMap<Character, Integer>();
		//Map<Character, Integer> hashS2 = new HashMap<Character, Integer>();
		Integer c = 0;
		for (int i = 0; i < s1.length(); i++) {
			
			  c=hashS1.get(s1.charAt(i));
			  if(c == null) {
				  hashS1.put(s1.charAt(i), 1);
			  }else {
				  hashS1.put(s1.charAt(i), c + 1);
			  }
			
			
		}
		
		for (int i = 0; i < s2.length(); i++) {
			if(!hashS1.containsKey(s2.charAt(i))){
				return false;
			}else {
				c = hashS1.get(s2.charAt(i));
				if(c == 1) {
					hashS1.remove(s2.charAt(i));
				}else {
					hashS1.put(s2.charAt(i) , c-1);
				}
				
			}
			
		}
		
		if(hashS1.isEmpty()) {
			return true;
		}else {
			return false;
		}
		

	}

	public static void main(String[] args) {
		String s1 = "spars";
		String s2 = "sapr";
		System.out.println(checkAnagram(s1, s2));
		System.out.println(checkAnagramDup(s1, s2));
	}

}
