package com.string;

public class RemoveWhiteSpace {
	static String  removeWhitespace(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) != ' ') {
				sb.append(String.valueOf(s.charAt(i)));
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = " rama vta   jat av ";
		System.out.println(removeWhitespace(s));
	}

}
