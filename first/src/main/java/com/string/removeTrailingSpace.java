package com.string;

public class removeTrailingSpace {
	static String removeTrailSpaces(String str) {
		int i = str.length()-1;
		while (i >= 0) {
			if (!Character.isWhitespace(str.charAt(i))) {
				break;
			}
			i--;
		}
		StringBuilder stb = new StringBuilder();
		for(int j = 0 ; j <= i ; j++) {
			stb.append(str.charAt(j));
		}
		return stb.toString();
		
	}
  public static void main(String[] args) {
	String str = "    xxxxx xxx xxx  ";
	System.out.println(removeTrailSpaces(str) + "y");
	
}
}
