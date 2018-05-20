package org.array;

public class CompactingArray {
	static String[] compactArray(int[] a) {
		String[] sA = new String[16];

		int prei = 0;
		int i = 0;
		int j = 0;
		if(a.length == 1 ) {
			sA[0] = Integer.toString(a[0]);
		}else if(a.length == 2) {
			sA[0] = Integer.toString(a[0]);
			sA[1] = Integer.toString(a[1]);
		}

		while (i < a.length - 1) {
			if (a[i] == (a[i + 1] - 1)) {
				i++;
			} else {
				if (i - prei == 0) {
					sA[j] = Integer.toString(a[i]);
				} else if (i - prei == 1) {
					sA[j] = Integer.toString(a[prei]);
					j = j + 1;
					sA[j] = Integer.toString(a[i]);
				} else {
					sA[j] = Integer.toString(a[prei]) + "-" + Integer.toString(a[i]);
				}

				i++;
				prei = i;
				j++;

			}

		}

		if (i - prei == 0) {
			sA[j] = Integer.toString(a[i]);
		} else if (i - prei == 1) {
			sA[j] = Integer.toString(a[prei]);
			j = j + 1;
			sA[j] = Integer.toString(a[i]);
		} else {
			sA[j] = Integer.toString(a[prei]) + "-" + Integer.toString(a[i]);
		}

		return sA;
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	static void print(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] a = { -3, -2, -1, 1, 2, 3, 4, 10, 20, 21, 22, 22, 23,24, 28, 29,30,31,33,38 };
		print(a);
		print(compactArray(a));
	}

}
