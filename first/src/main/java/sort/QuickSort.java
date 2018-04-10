package sort;

public class QuickSort {
	static void quickSort(int[] a, int low, int high) {
		if (low < high) {

			int pivot = high;
			int i = low-1;
			int j = low;
			while ( j <= high-1) {
				if (a[pivot] >= a[j]) {
					i++;
			     	int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
				}
				j++;
				print(a);
			}

			int temp = a[pivot];
			a[pivot] = a[i+1];
			a[i+1] = temp;
			print(a);
			quickSort(a, 0, i);
			quickSort(a, i + 2, high);
		}

	}

	static void quickSort(int[] a) {
		quickSort(a, 0, (a.length - 1));
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 21,10,15,20, 8 ,9,11};
		print(a);
		quickSort(a);
		print(a);

	}
}
