package com.string;

public class Compare {
	static String compare(String str1, String str2) {
		int i = 0, j = 0;

		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) < str2.charAt(j)) {
		         return str2;
			}else if (str1.charAt(i) > str2.charAt(j)) {
				return str1;
			}
			i++;
			j++;
		}

		if (i < str1.length()) {
			return str1;
		}
		if (j < str2.length()) {
			return str2;
		}

	    return str1;
	}

	public static void main(String[] args) {
		String str1 = new String("abcd");
		String str2 = new String("abc");
		System.out.println(compare(str1, str2));

	}

}
