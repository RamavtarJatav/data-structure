package org.array;

public class ArrayDiagonalPrint {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int i = 0;
		int j = 0;
		int r = 0;
		int c = 0;

		while (i < a.length && j < a[i].length) {
			while (i >= 0 && j <= c) {
				System.out.print(a[i][j] + " ");
				i--;
				j++;
			}
			System.out.println();

			r++;
			c++;
			i = r;
			j = 0;

		}
		r = a.length - 1;
		c = 1;
		i = r;
		j = c;

		while (i < a.length && j < a[i].length) {
			while (i >= 0 && j <= a[i].length - 1) {
				System.out.print(a[i][j] + " ");
				i--;
				j++;
			}

			System.out.println();
			c++;
			j = c;
			i = r;
		}

	}

}
