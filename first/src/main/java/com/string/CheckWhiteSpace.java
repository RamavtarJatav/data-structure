package com.string;

public class CheckWhiteSpace {
	static void checkWhiteSpaces(String str) {
		for(int i = 0 ; i < str.length()  ; i ++) {
			if(Character.isWhitespace(str.charAt(i))) {
				System.out.println("index of whitespace = " + i );
			}
		}
	}
	public static void main(String[] args) {
		String str = "rama vtar";
		checkWhiteSpaces(str);
		
	}

}
