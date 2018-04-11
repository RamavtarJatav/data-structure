package sort;

public class HeapSort{

	static void maxHeap(int[] a) {
		/*
		 * 5 / \ 7 1 /\ /\ 11 3 4 8 / 19
		 * 
		 */

		int n = a.length - 1;
		for (int j = 0; j <= a.length - 1; j++) {
			for (int i = n - j; i > 0; i--) {
				if (a[i] > a[(i - 1) / 2]) {
					int temp = a[i];
					a[i] = a[(i - 1) / 2];
					a[(i - 1) / 2] = temp;
				}

			}

			int temp = a[0];
			a[0] = a[a.length - 1 - j];
			a[a.length - 1 - j] = temp;
		}
 	}
   
	static void heapSort(int[] a ) {
		int n = a.length-1;
		heapify(a, n);
		//swap first and last element
		int temp = a[0];
		a[0] = a[n];
		a[n] = temp;
		heapSort(a, n-1);
		
	}
	
	static void heapSort(int[] a , int  n) {
		if(n > 0) {
		heapify(a, n);
		int temp = a[0];
		a[0] = a[n];
		a[n] = temp;
		heapSort(a, n-1);
		}
	}
	static void heapify(int[] a, int n) {
		for (int i = n; i > 0; i--) {
			if (a[i] > a[(i - 1) / 2]) {
				int temp = a[i];
				a[i] = a[(i - 1) / 2];
				a[(i - 1) / 2] = temp;
			}

		}
	}

	static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3 };
		printArray(a);
		//maxHeap(a);
		//heapify(a, a.length-1);
        heapSort(a);
		printArray(a);

	}

}
