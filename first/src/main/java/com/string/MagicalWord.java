package com.string;

import java.util.Scanner;

public class MagicalWord {
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
				boolean primegt = false;
				while (((ch + gt) >= 49 && (ch + gt) <= 58) || ((ch + gt) >= 65 && (ch + gt) <= 90)
						|| ((ch + gt) >= 91 && (ch + gt) <= 122)) {

					if ((ch + gt) >= 49 && (ch + gt) <= 58) {
						int diff = 65 - gt - ch;
						gt = gt + diff;
						continue;
					}
					int chsr = (int) Math.sqrt(ch + gt);
					if ((ch + gt) % 2 != 0 && (ch + gt) % 3 != 0) {
						primegt = true;

					} else {
						primegt = false;
						if ((gt + ch) == 90) {
							gt = gt + 7;
						} else {
							gt++;
						}

						continue;
					}
					int k = 1;
					while ((6 * k - 1) <= chsr || (6 * k + 1) <= chsr) {
						if ((ch + gt) % (6 * k - 1) != 0 && (ch + gt) % (6 * k + 1) != 0) {

							primegt = true;

						} else {
							primegt = false;
							break;

						}
						k++;
					}

					if (primegt) {
						break;
					}
					if ((gt + ch) == 90) {
						gt = gt + 7;
					} else {
						gt++;
					}

				}
				int lt = 0;
				boolean primelt = false;
				while (((ch - lt) >= 65 && (ch - lt) <= 90) || ((ch - lt) >= 97 && (ch - lt) <= 122)) {

					int chr = (int) Math.sqrt(ch - lt);
					if ((ch - lt) % 2 != 0 && (ch - lt) % 3 != 0) {
						primelt = true;

					} else {
						if ((ch - lt) == 97) {
							lt = lt + 7;
						} else {
							lt++;
						}
						primelt = false;
						continue;

					}

					int k = 1;
					while ((6 * k - 1) <= chr || (6 * k + 1) <= chr) {
						if ((ch - lt) % (6 * k - 1) != 0 && (ch - lt) % (6 * k + 1) != 0) {
							primelt = true;
						} else {
							primelt = false;
							break;
						}
						k++;
					}

					if (primelt) {
						break;
					}
					if ((ch - lt) == 97) {
						lt = lt + 7;
					} else {
						lt++;
					}
				}
				if (primelt && primegt) {
					if (lt <= gt) {
						sb.append((char) (ch - lt));
					} else {
						sb.append((char) (ch + gt));
					}

				} else if (primegt && !primelt) {
					sb.append((char) (ch + gt));
				} else if (!primegt && primelt) {
					sb.append((char) (ch - lt));
				}
			}

			System.out.println(sb.toString());

		}

		// Write your code here
		sc.close();
	}

}
