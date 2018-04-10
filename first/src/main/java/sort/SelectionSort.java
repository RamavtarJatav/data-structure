package sort;

public class SelectionSort {
	static void selectionSort(int[] a) {
		int minIndex ;
		
		for (int j = 0; j < a.length; j++) {
			minIndex = j;
			for (int i = j; i < a.length; i++) {
				if (a[minIndex] > a[i]) {
					minIndex = i;
				}

			}
			int temp = a[j];
			a[j] = a[minIndex];
			a[minIndex] = temp;

		}
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 5, 2, 6, 1, 9, 4, 3, 17, 12 };
		print(a);
		selectionSort(a);
		print(a);
	}

}
