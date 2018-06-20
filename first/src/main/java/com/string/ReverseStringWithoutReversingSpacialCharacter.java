package com.string;

public class ReverseStringWithoutReversingSpacialCharacter {

	static String reversewithoutSpacialcharacter(String s) {
		int c = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!checkSpecialCharacter(s.charAt(i))) {
				while (checkSpecialCharacter(s.charAt(c))) {
					sb.append(s.charAt(c));
					c++;
				}
				sb.append(s.charAt(i));
				c++;
			}
		}
		return sb.toString();

	}

	static boolean checkSpecialCharacter(char c) {

		if (((int) c >= 65 && (int) c <= 90) || ((int) c >= 97 && (int) c <= 122) || ((int) c >= 48 && (int) c <= 57)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "c#fgh%ghZ@$f########sdg";
		System.out.println(reversewithoutSpacialcharacter(s));

	}

}
