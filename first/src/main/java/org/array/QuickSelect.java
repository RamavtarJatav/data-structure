package org.array;

public class QuickSelect implements Cloneable {
	static void quickSelect(int[] a, int k) {
		int pv = a[k - 1];
		int n = a.length;
		int ind = -1;
		for (int i = 0; i < n; i++) {

			if (pv > a[i]) {
				ind++;
				if (ind == k - 1) {
					ind++;
				}
				int temp = a[ind];
				a[ind] = a[i];
				a[i] = temp;
			}
			//print(a);
		}
		if (ind + 1 <= k - 1) {
			ind++;
		}
		
		
		a[k - 1] = a[ind];
		a[ind] = pv;
		
		

	}

	static void print(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 5, 3, 9, 6, 12, 13, 8, 7, 4 };
		print(a);
		quickSelect(a, 3);
		print(a);

	}

}
