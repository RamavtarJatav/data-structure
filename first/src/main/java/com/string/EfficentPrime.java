package com.string;

import java.util.Scanner;

public class EfficentPrime {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int j = 0; j < T; j++) {
			int l = sc.nextInt();
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < l; i++) {
				int ch = (int) s.charAt(i);

				int gt = 1;

				while (ch+gt <= 122) {
					boolean prime = true;
					;
					int chsr = (int) Math.sqrt(ch + gt);
					if ((ch + gt) % 2 == 0 || (ch + gt) % 3 == 0) {
						prime = false;
						gt++;
						continue;
					}
					int k = 1;
					while ((6 * k - 1) <= chsr || (6 * k + 1) <= chsr) {
						if ((ch + gt) % (6 * k - 1) == 0 || (ch + gt) % (6 * k + 1) == 0) {
							prime = false;
							gt++;
							break;
						}
						k++;
					}

					if (prime) {
						break;
					}
					gt++;

				}
				int lt = 0;
				while ((ch-lt) >= 65) {
					boolean prime = true;
					;
					int chr = (int) Math.sqrt(ch - lt);
					if ((ch - lt) % 2 == 0 || (ch - lt) % 3 == 0) {
						prime = false;
						lt++;
						continue;
					}

					int k = 1;
					while ((6 * k - 1) <= chr || (6 * k + 1) <= chr) {
						if ((ch - lt) % (6 * k - 1) == 0 || (ch - lt) % (6 * k + 1) == 0) {
							prime = false;
							lt++;
							break;
						}
						k++;
					}

					if (prime) {
						break;
					}
					lt++;
				}

				if (lt <= gt) {
					sb.append((char) (ch - lt));
				} else {
					sb.append((char) (ch + gt));
				}
			}

			System.out.println(sb.toString());

		}

		// Write your code here
		sc.close();
	}

}
