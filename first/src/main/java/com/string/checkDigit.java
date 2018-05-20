package com.string;

public class checkDigit {
	static boolean isDigit(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println((int)(s.charAt(i)));
			if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3'
					|| s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7'
					|| s.charAt(i) == '8' || s.charAt(i) == '9') {

			} else {
				return false;
			}
		}
		return true;
	}
	
	
   static boolean isDigit1(String s) {
	   for(int i = 0 ; i < s.length() ; i++) {
		   if(!((int)(s.charAt(i)) >= 48)  || !((int)(s.charAt(i)) <= 57)) {
			   return false;
		   }
	   }
	return true;
   }
	public static void main(String[] args) {
		String s = "12345x";
		System.out.println(isDigit1(s));

	}

}
