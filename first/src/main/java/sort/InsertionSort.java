package sort;

public class InsertionSort {
	static void insertionSort(int[] a ) {
		
		for (int i = 0 ; i < a.length ; i++) {
			for (int j = 0 ; j < i ; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j] ;
					a[j] = temp;
				}
			}
		}
	}
	
	static void print(int a[]) {
		for (int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		 int[] a = {6, 4, 2, 8, 9, 1, 3, 11};
		 print(a);
		 insertionSort(a);
		 print(a);
	}

}
