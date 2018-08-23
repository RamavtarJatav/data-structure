package sort;

public class Sort012 {

	static void sort0s1s2s(int[] a) {
		int n = a.length;

		quickSort(a, 0, n - 1);

	}

	static void sortEfficently(int[] a) {
		int n = a.length;
		int i0 = -1;
		int e2 = n;
		int i = 0 ;
		while(i < n && i < e2) {
			if (a[i] == 0) {
				i0++;
				int temp = a[i];
				a[i] = a[i0];
				a[i0] = temp;
				i++;

			} else if (a[i] == 2 ) {
				e2--;
				int temp = a[i];
				a[i] = a[e2];
				a[e2] = temp;

			}else {
				i++;
			}
		}

	}

	static void quickSort(int[] a, int si, int ei) {
		int i = 0;
		for (i = si; i <= ei; i++) {
			if (a[i] == 1) {
				break;
			}
		}
		int idx = -1;
		int j = si;
		int pv = a[i];
		while (j <= ei) {
			if (a[j] < pv) {
				if (idx + 1 == i) {
					idx++;
				}

				idx++;
				int temp = a[j];
				a[j] = a[idx];
				a[idx] = temp;
			}
			j++;
		}
		if (idx <= i) {
			idx++;
		}
		a[i] = a[idx];
		a[idx] = pv;

	}

	static void print(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 0, 0, 2, 2, 2, 2, 2, 2, 1, 1, 0, 2, 0, 1, 1, 2, 1, 0, 2, 1, 0 };
		print(a);
		sortEfficently(a);
		print(a);
	}

}
