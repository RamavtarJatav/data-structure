package hashing;

public class IsArraySubset {
	// simple solution;
	static boolean isSubset(int[] m, int[] s) {
		boolean found = false;
		for (int i = 0; i < s.length; i++) {
			found = false;
			for (int j = 0; j < m.length; j++) {
				if (s[i] == m[j]) {
					found = true;
					j = 0;
					break;
				}
			}
			if(found == false) {
				return found;
			}
		}
		return found;
	}

	// sort the arrays and binary search;
	static boolean isSubset1(int[] m, int[] s) {
		quickSort(m);
		//quickSort(s);
		boolean found = false;
		int n = m.length - 1;
		for (int i = 0; i < s.length; i++) {
			found = false;
			int l = 0;
			int h = n;
			int j = (l+h) / 2;
			while (l < h) {
				if (s[i] == m[j]) {
					found = true;
					break;
				} else if (s[i] < m[j]) {
					
					h = j;
					j = (l+h)/2;
					
						

				} else {
					l= j;
					j = (l + n+1) / 2;
				}

			}
			if(found == false) {
			    return found;
			}

		}
		return found;
	}

	static void quickSort(int[] m) {
		int n = m.length - 1;

		quickSort(m, 0, n);

	}

	static void quickSort(int[] a, int l, int h) {
		if (l < h) {
			int pi = PI(a, l, h);
			quickSort(a, l, pi - 1);
			quickSort(a, pi + 1, h);
		}
	}

	static int PI(int[] a, int l, int h) {
		int pivot = h;
		int pi = l - 1;
		for (int i = l; i < h; i++) {
			if (a[pivot] >= a[i]) {
				pi++;
				int temp = a[i];
				a[i] = a[pi];
				a[pi] = temp;

			}
		}

		// h with pi;
		pi++;
		int temp = a[h];
		a[h] = a[pi];
		a[pi] = temp;
		return pi;
	}
	
	
	
	static boolean isSubset2(int[] m , int[] s) {
		quickSort(m);
		quickSort(s);
		int i = 0;
		int j = 0;
		boolean found = false;
		if(s[i] < m[j])
			return found;
		while(i < s.length && j < m.length) {
			found = false;
			if(s[i] < m[j]){
				i++;
			}else if(s[i] > m[j]) {
				j++;
			}else {
			   i++;
			   j++;
			   found = true;
			}
				
		}
		
		if (i < s.length) {
			found = false;
		}
		return found;
	}

	static void printArray(int[] a) {
		System.out.print("[" + " ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] m = { 9, 15, 2, 17, 14, 1, 4, 8, 18,19 };
		int[] s = {  8, 4, 4};
		 System.out.println(isSubset(m , s));
		quickSort(m);
		
		quickSort(s);
		printArray(m);
		printArray(s);
		System.out.println(isSubset1(m ,s));
		System.out.println(isSubset2(m ,s));
	}

}
