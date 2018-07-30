package org.array;

public class ArrayQuestion {

	static void arrayai(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int d = a[i];
			// swap
			if (d != -1 && d < a.length) {
				int temp = a[d];
				a[d] = d;
				a[i] = temp;
			}

		}
	}

	static void print(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	static void evenodd(int[] a) {
		int n = a.length;
		for (int j = 0; j < n; j++)
			for (int i = 0; i < n - 1 - j; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}

			}
       
		print(a);
		int[] b = new int[n];
		int d = (n+1) / 2;
		int m = d;
		for (int i = 1; i < n; i += 2) {
			b[i] = a[m++];
			print(b);
		}
		int l = d-1;
		for (int i = 0; i < n; i += 2) {
			b[i] = a[l--];
		}
        
		//a = new int[n];
		print(b);

	}

	public static void main(String[] args) {
		int[] a = { 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4 };
		// print(a);
		// arrayai(a);
		// print(a);
		// arrayai(a);
		print(a);
		evenodd(a);
		print(a);

	}

}
