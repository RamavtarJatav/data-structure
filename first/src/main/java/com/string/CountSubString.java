package com.string;

public class CountSubString {
	static int subStringCount(String str) {
		int n = str.length();
		return ((n*(n+1))/2);
		
	}
	public static void main(String[] args) {
		String str = "ramav";
		System.out.println(subStringCount(str));
	}

}
