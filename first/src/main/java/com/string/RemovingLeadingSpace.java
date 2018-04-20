package com.string;

public class RemovingLeadingSpace {
	static String removeLeadingSpace(String str) {
		int i = 0;
		boolean start = false;
		StringBuilder stb = new StringBuilder();

		while (i < str.length()) {
			if (!start) {
				if (Character.isWhitespace(str.charAt(i))) {

				} else {
					start = true;
					break;
				}

			} 
			i++;
		}
		
		while(i < str.length()) {
			stb.append(str.charAt(i));
			i++;
		}
		
		return stb.toString();

	}
	
	

	public static void main(String[] args) {
		String str = " x xxxx xxx x";
		System.out.println(removeLeadingSpace(str));
	}
	

}
