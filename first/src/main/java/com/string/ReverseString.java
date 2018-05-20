package com.string;

public class ReverseString {
	static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1 ; i >= 0 ; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	
	}
	
	static StringBuilder sb = new StringBuilder();
	
	static String reverseRecursive(String s) {
		
		return reverseRecursive(s, s.length()-1);
		
	}
	
	static String reverseRecursive(String s , int i) {
		   if(i == 0 ) {
			   return String.valueOf(s.charAt(i));
		   }else {
			return String.valueOf(s.charAt(i))+ reverseRecursive(s , i-1);
		   }
		
	}
	public static void main(String[] args) {
		String s = "ramavtar jatav";
		System.out.println(s);
		System.out.println(reverse(s));
		System.out.println(reverseRecursive(s));
		
		
	}

}
