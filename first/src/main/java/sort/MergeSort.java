package sort;

public class MergeSort {
	static void merge(int[] a, int l, int m, int r) {

		int sL = m - l + 1;
		int sR = r - m;
		int[] L = new int[m - l + 1];
		int[] R = new int[r - m];

		for (int i = 0; i < m - l + 1; i++) {
			L[i] = a[i + l];
		}
		print(L);
		for (int i = 0; i < r - m; i++) {
			R[i] = a[m + i + 1];
		}
		print(R);
		int i = l;
		int j = 0;
		int k = 0;
		while (j < sL && k < sR) {
			if (L[j] < R[k]) {
				a[i] = L[j];
				i++;
				j++;
			} else if (L[j] > R[k]) {
				a[i] = R[k];
				i++;
				k++;
			}else {
				a[i]=L[j];
				i++;
				a[i]=R[k];
				i++;
				j++;
				k++;
				
				
			}
		}

		while (j < sL) {

			a[i] = L[j];
			i++;
			j++;

		}
		while (k < sR) {
			a[i] = R[k];
			i++;
			k++;
		}

	}

	static void sort(int[] a, int l, int r) {
		int m = (l + r) / 2;
		if (l < r) {
			sort(a, l, m);
			sort(a, m + 1, r);
			merge(a, l, m, r);
		}
	}

	static void print(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 8, 10, 4,3,9,1,11,2,6, 11};
		print(a);
		sort(a, 0, a.length - 1);
		print(a);
		

	}
}
