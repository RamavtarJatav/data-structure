package org.array;

public class SubArraySumEqualtoGivenSum {
	static void found(int[] a, int sum) {
		int sum1 = 0;
		int is = 0;
		int ie = 0;
		int n = a.length;
		while (sum != sum1 && ie < n) {
			while (sum1 < sum) {
				sum1 = sum1 + a[ie];
				ie++;
			}
			while (sum1 > sum) {
				sum1 = sum1 - a[is];
				is++;
			}
		}
		if (sum == sum1) {
			System.out.println(true + " " + is + " " + (ie-1));

		} else {
			System.out.println(false);
		}
	}

	public static void main(String[] args) {
		int sum = 32;
		int[] a = { 2, 5, 4, 6, 4, 14, 19, 21 };
		found(a, 32);
		int n = a.length;
		int sum1 = 0;
		boolean found = false;
		int sind = 0;
		int eind = 0;

		int i = 0;
		while (i < n) {
			sind = i;
			for (int j = i; j < n; j++) {
				if (sum1 < sum) {
					sum1 = sum1 + a[j];
				} else if (sum1 > sum) {
					sum1 = 0;
					break;
				} else {
					found = true;
					eind = j - 1;
					break;
				}
			}

			if (found) {
				// System.out.println(found);
				break;
			} else {
				i++;
			}
		}

		if (found) {
			System.out.println(found + " " + sind + " " + eind);
		}else {
			System.out.println(found);
		}
	}

}
