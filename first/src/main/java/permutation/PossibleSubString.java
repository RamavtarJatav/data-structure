package permutation;

import java.util.ArrayList;
import java.util.List;

public class PossibleSubString {

	static List<String> possibleSubString(String s, int l) {
		List<String> subStrList = new ArrayList<String>();
		int n = s.length();
		for (int i = 0; i <= n - l; i++) {
			subStrList.add(s.substring(i, i + l));
		}
		return subStrList;
	}

	static void possibleSubString(String s) {
		for (int i = 0; i <= s.length(); i++) {
			List<String> subStrList = possibleSubString(s, i);
			for (String str : subStrList) {
				System.out.print(str + " ");
			}
		}
	}

	static List<String> possibleSubStr(String s, int k) {

		if (k == 1) {
			int n = s.length();
			List<String> subStrList = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				subStrList.add(String.valueOf(s.charAt(i)));
			}

			return subStrList;
		}

		int n = s.length();
		List<String> subStrLi = possibleSubStr(s, k - 1);
		for (int i = 0; i <= n - k; i++) {
			subStrLi.add(s.substring(i, k + i));
		}
		return subStrLi;

	}

	public static void main(String[] args) {
		// possibleSubString("abcde");
		String s = "abcde";
		List<String> subStrLi = possibleSubStr("abcde", s.length());

		for (String str : subStrLi) {
			System.out.print(str + " ");
		}

	}

}
