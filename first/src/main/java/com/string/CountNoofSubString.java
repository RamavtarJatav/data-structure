package com.string;

public class CountNoofSubString {
	static int substringCount(String str, String subString) {
		int i=0;
		int j=0; 
		int count = 0;
		while (j < subString.length()  && i < str.length()) {
			if(subString.charAt(j) == str.charAt(i)) {
				System.out.print(str.charAt(i));
				j++;
				i++;
			}else {
				i++;
			}
			
			if (j==subString.length()) {
				System.out.println("end of subString ");
				j = 0;
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		String str1 = "ramavtar ram ram";
		String str2 = "ram";
		
		System.out.println("count =" +substringCount(str1 , str2));
		
		
	}

}
