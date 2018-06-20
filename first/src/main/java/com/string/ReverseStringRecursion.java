package com.string;

public class ReverseStringRecursion {
	
	static void reverseRecursion(String s) {
		reverseRecursion(s , s.length()-1);
	}
	
	static void reverseRecursion(String s , int ind) {
		if(ind < 0) {
			return;
		}else {
			System.out.print(s.charAt(ind));
			reverseRecursion(s , ind-1);
		}
	}
	public static void main(String[] args) {
		String s = "ramavtar jatav";
		reverseRecursion(s);
		
	}

}
