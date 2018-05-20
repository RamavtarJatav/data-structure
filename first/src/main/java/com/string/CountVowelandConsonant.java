package com.string;

public class CountVowelandConsonant {
	static int countletter(String s) {
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			if (((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90)
					|| ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122)) {
				c++;

			}
		}
		return c;
	}

	static int countvowel(String s) {
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((int) s.charAt(i) == 65 || (int) s.charAt(i) == 69 || (int) s.charAt(i) == 73 || (int) s.charAt(i) == 79
					|| (int) s.charAt(i) == 85 || (int) s.charAt(i) == 97 || (int) s.charAt(i) == 101
					|| (int) s.charAt(i) == 105 || (int) s.charAt(i) == 111 || (int) s.charAt(i) == 117) {
				c++;

			}
		}
		return c;

	}
	
	static int countConsonant(String s) {
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!((int) s.charAt(i) == 65) || !((int) s.charAt(i) == 69) || !((int) s.charAt(i) == 73) || !((int) s.charAt(i) == 79)
					|| !((int) s.charAt(i) == 85) || !((int) s.charAt(i) == 97) || !((int) s.charAt(i) == 101)
					|| !((int) s.charAt(i) == 105) || !((int) s.charAt(i) == 111) || !((int) s.charAt(i) == 117)) {
				c++;

			}
		}
		return c;

	}

	public static void main(String[] args) {
		String s = "AxeB9s...zaZ123(<}";
		System.out.println(countletter(s));
		System.out.println(countvowel(s));
		//System.out.println(countConsonant(s));
	}

}
