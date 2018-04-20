package com.string;

public class Compare {
	 static boolean compare(String str1 , String str2) {
		 int i = 0,j = 0;
		 
		 while(i < str1.length() && j < str2.length()) {
			if(str1.charAt(i) != str2.charAt(j)) {
				return false;
			}
			i++;
			j++;
		 }
		 
		 
		 return true;
	 }
	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "abcd";
		System.out.println(compare(str1, str2));
	    char ch = 'A';
	    char ch1 = 'A';
	    if (ch1 == ch) {
	    	System.out.println(true);
	    }
	}
	

}
