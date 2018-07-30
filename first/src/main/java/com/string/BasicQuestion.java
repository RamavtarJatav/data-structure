package com.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicQuestion {
	static void printDuplicate(String s) {
		char[] c = new char[127];
		// int[] ci = new int[127];
		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (c[(int) s.charAt(i)] == 1) {
				System.out.print(s.charAt(i) + " ");
			} else {
				c[(int) s.charAt(i)] = 1;
			}
		}
	}

	static void printNonDuplicate(String s) {
		int n = s.length();
		char[] ch = new char[n];
		int[] count = new int[n];
		int chnum = -1;

		for (int i = 0; i < n; i++) {
			boolean found = false;
			char c = s.charAt(i);
			for (int j = 0; j <= chnum; j++) {
				if (c == ch[j]) {
					count[j] = ++count[j];
					found = true;
				}
			}

			if (!found) {
				count[++chnum] = 1;
				ch[chnum] = c;
			}
		}

		for (int i = 0; i <= chnum; i++) {
			if (count[i] == 1) {
				System.out.print(ch[i]);
			}
		}

		System.out.println();
		for (int i = 0; i <= chnum; i++) {
			if (count[i] > 1) {
				System.out.println(ch[i]);
			}
		}
	}

	static void isDigit(String s) {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) < 48 || s.charAt(i) > 57) {
				System.out.println("not digitss");
				return;
			}

		}

		System.out.println("have digit");
	}

	static void reverseString(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}

		System.out.println(sb.toString());
	}

	static StringBuilder sb1 = new StringBuilder();

	static void reverseStringRecusrsion(String s) {
		int n = s.length();
		char[] rev = s.toCharArray();
		reverseStringRecusrsion(rev, --n, 0);
		System.out.println(String.copyValueOf(rev));
	}

	static void reverseStringRecusrsion(char[] rev, int n, int m) {
		char temp = rev[n];
		rev[n] = rev[m];
		rev[m] = temp;
		if (n <= m)
			return;

		reverseStringRecusrsion(rev, --n, ++m);
	}

	static void countVowelConsonent(String s) {
		int n = s.length();
		int countc = 0;
		int countv = 0;
		for (int i = 0; i < n; i++) {
			int ch = s.charAt(i);
			if ((ch >= 'A' && ch <= 'Z' || (ch >= 'a' && ch <= 'z'))) {
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
						|| ch == 'O' || ch == 'U') {
					countv++;
				} else {
					countc++;
				}
			}
		}

		System.out.println("vowel= " + countv);
		System.out.println("consonent= " + countc);
	}

	static void convertStringtoInt(String s) {

		int n = s.length();
		if (n == 0)
			return;
		int num = 0;
		for (int i = 0; i < n; i++) {
			int ch = s.charAt(i);
			if (ch >= 48 && ch <= 57) {
				int digit = ch - 48;
				num = num * 10 + digit;
			} else {
				System.out.println("not digit");
				return;
			}
		}

		System.out.println(num);
	}

	static List<String> permutation(String s) {
		List<String> list1 = new ArrayList<String>();
		int n = s.length();
		if (n == 1) {
			list1.add(s);
			return list1;
		}
		char ch = s.charAt(0);
		List<String> list = permutation(s.substring(1));

		for (String str : list) {
			int strn = str.length();
			for (int i = 0; i <= strn; i++) {
				list1.add(str.substring(0, i) + ch + str.substring(i));
			}
		}
		return list1;
	}

	// tofind if third string shuffle of first and second

	static void isShuffle(String a, String b, String c) {
		int al = a.length();
		int bl = b.length();
		int cl = c.length();
		if (al + bl != cl) {
			System.out.println("not shuffle");
			return;
		}
		// char[] ab = new char[al+bl];
		// int[] abcount = new int[al+bl];
		//
		// for(int i = 0 ; i < al ; i++) {
		//
		// }

		Map<Character, Integer> abMap = new LinkedHashMap<Character, Integer>();
		// Map<Character, Integer> cMap = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < al; i++) {
			Character ch = a.charAt(i);
			Integer count = abMap.get(ch);
			if (count == null) {
				abMap.put(ch, 1);
			} else {
				abMap.put(ch, count + 1);
			}
		}

		for (int i = 0; i < bl; i++) {

			Character ch = b.charAt(i);
			Integer count = abMap.get(ch);
			if (count == null) {
				abMap.put(ch, 1);
			} else {
				abMap.put(ch, count + 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : abMap.entrySet()) {
			System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
		}

		int i;
		for (i = 0; i < cl; i++) {
			Character ch = c.charAt(i);
			Integer count = abMap.get(ch);
			if (count == null) {
				System.out.println("not shuffle");
				return;
			} else if (count != 1) {
				abMap.put(ch, count - 1);
			} else {
				abMap.remove(ch);
			}

		}

		if (i != cl) {
			System.out.println("not shuffle");
			return;
		}

		if (!abMap.isEmpty()) {
			System.out.println("not shuffle");
			return;
		}

		System.out.println("shuffle");

	}
	// permutation
	// all possible string of length from given string

	// static void permutationGivenLength(String s, int n) {
	// Set<String> comb = new HashSet<String>();
	// int sl = s.length();
	// for (int i = 0; i < sl; i++) {
	// for (int j = 0; j < sl; j++) {
	// for (int k = 0; k < sl; k++) {
	// if (i != j && j != k && i != k) {
	// comb.add(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(j)) +
	// String.valueOf(s.charAt(k)));
	// }
	// }
	// }
	// }
	//
	// for (String str : comb) {
	// System.out.print(str + " ");
	// }
	// }

	static List<String> permutationGivenLength(String s, int n) {
		List<String> comb = new ArrayList<String>();
		int sl = s.length();
		if (n == 1) {
			for (int j = 0; j < sl; j++) {
				comb.add(String.valueOf(s.charAt(j)));
			}
            int c= 0;
			for (String str : comb) {
				System.out.print(str + " ");
				c++;
			}
			System.out.println();
			System.out.println(c);
			
			return comb;
		}
        n = n-1;
		for (int i = 0; i < sl; i++) {
			char ch = s.charAt(i);
			String newStr = s.substring(0, i) + s.substring(i + 1);
			List<String> comb1 = permutationGivenLength(newStr, n);
			for (String str : comb1) {
				//int strl = str.length();
				//for (int j = 0; j < strl; j++) {
				if(!comb.contains(String.valueOf(ch) + str))
				comb.add(String.valueOf(ch) + str);
				
				//}
			}

		}
        int count = 0;
		for (String str : comb) {
			System.out.print(str + " ");
			count++;
		}
		
		System.out.println();
		System.out.println(count);
		return comb;
	}

	public static void main(String[] args) {
		// printDuplicate("prritnt");
		// printNonDuplicate("abcdd");
		// reverseString("axdffdf");
		// reverseStringRecusrsion("abcdss");
		// isDigit("111a");
		// countVowelConsonent("avcddeAouOcd");
		// convertStringtoInt("11");
		// List<String> list1 = permutation("abcd");
		// for (String strf : list1) {
		// System.out.print(strf + " ");
		// }

		// isShuffle("abcl", "defx", "daefcbxm");
		permutationGivenLength("abab", 2);

	}

}
