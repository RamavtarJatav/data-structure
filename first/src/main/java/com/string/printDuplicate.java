package com.string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class printDuplicate {
	
	static void removeDuplicate(String data) {
		HashSet<Character> hashSetO = new HashSet<Character>();
		Set<Character> hashSetD = new LinkedHashSet<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i < data.length(); i++) {
			if(!hashSetO.contains(data.charAt(i))) {
				hashSetO.add(data.charAt(i));
				
			}else {
				hashSetD.add(data.charAt(i));
			}
			
		}
		
		for(char c : hashSetD) {
			System.out.print(c);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);

		while(sc.hasNextLine()) {
			String data = sc.nextLine();
			if(data.equals(" ")) {
				System.exit(0);
			}else {
				removeDuplicate(data);
				
			}
			
			
		}
		sc.close();
	}

}
