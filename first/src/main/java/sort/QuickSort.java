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
	
	static int removeDuplicate(int[] a){
	       int n = a.length;
	       int delc = 0;
	       for(int i = 0 ; i < n-delc ; i++){
	          for(int j = i+1  ; j < n  ;j++){
	             if(a[i] == a[j]){
	                 for(int k = j ; k < n-1-delc ; k++){
	                     a[k] = a[k+1];
	                 }
	                 delc++;
	             }
	         }
	    }
	    
	    return delc;
	    
	}

	public static void main(String[] args) {
		int[] a = { 8,11,21,10,15,20, 8, 15,9,11};
		print(a);
		quickSort(a);
		System.out.println(removeDuplicate(a));
		
		print(a);

	}
}
