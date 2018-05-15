package org.array;

public class SearchinRotated {
	static void rotateleft(int[] a, int d) {
		reverse(a, 0, d - 1);
		reverse(a, d, a.length - 1);
		reverse(a, 0, a.length - 1);

	}

	static void reverse(int[] a, int is, int ie) {
		while (is < ie) {
			int temp = a[is];
			a[is] = a[ie];
			a[ie] = temp;
			is++;
			ie--;
		}
	}

	static int searchPivot(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return i + 1;
			}

		}
		return a.length;

	}

	static boolean search(int[] a, int data) {
		int ip = searchPivot(a);
		 
		int m = 0;
		int l = ip;
		int h = ip-1;
		while (l < h || l > h) {
			
			if(l < h) {
				m = ((l + h) / 2);
			}else {
				m = ((l+h)/2)+l;
				m = m - a.length;
			}
	
			
			if (data == a[m]) {
				return true;
			} else if (data > a[m]) {
				l = m + 1;

			} else {
				h = m - 1;
			}

		}

		return false;

	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		print(a);
		rotateleft(a, 3);
		print(a);
		System.out.println(searchPivot(a));
		search(a, 9);

	}

}
