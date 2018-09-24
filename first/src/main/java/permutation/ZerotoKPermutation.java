package permutation;

import java.util.ArrayList;
import java.util.List;

public class ZerotoKPermutation {

	static List<String> zerotokPermutation(String s, int k) {
		List<String> listPer = new ArrayList<String>();
		int n = s.length();
		if (k == 1) {
			for (int i = 0; i < n; i++) {
				listPer.add(String.valueOf(s.charAt(i)));
			}
			return listPer;
		}

		for (int i = 0; i < n; i++) {
			char a = s.charAt(i);
			String nStr = s.substring(0, i) + s.substring(i + 1, n);
			List<String> listPerOld = zerotokPermutation(nStr, k-1);
			for (String str : listPerOld) {
				listPer.add(String.valueOf(a) + str);
			}

		}
		return listPer;
	}

	static List<String> permautation(String s) {

		List<String> listPerm = new ArrayList<String>();
		if (s.length() == 1) {
			listPerm.add(s);
			return listPerm;
		}

		String firstChar = s.substring(0, 1);
		String remainString = s.substring(1);
		List<String> listPermOld = permautation(remainString);

		for (String str : listPermOld) {
			int strLen = str.length();

			// listPerm.add(firstChar+str);

			for (int i = 0; i <= strLen; i++) {
				String befStr = str.substring(0, i);
				String aftStr = str.substring(i, strLen);
				String newStr = befStr + firstChar + aftStr;
				listPerm.add(newStr);
			}
			// listPerm.add(str +firstChar);
		}

		return listPerm;

	}

	public static void main(String[] args) {
		List<String> listPerm = zerotokPermutation("abcdefghijklmno", 15);
		// List<String> listPerm = permautation("abcd");
		int i = 0;
		for (String str : listPerm) {
			System.out.print(str + " ");
			i++;
		}
		System.out.println("\n"+i);
	}

}
