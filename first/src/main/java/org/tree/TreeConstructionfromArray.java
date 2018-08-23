package org.tree;

public class TreeConstructionfromArray {
	static void print(int[] a) {
		int n = a.length;
		for(int i = 0 ; i < n ;i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// in this array root is sum of its childern//
		int a[] = { 1, 2, 3, 4, 5, 6, 7,8  };
		//      1
		//      / \
		//     2   3 
		//    / \  /\
		//   4  5  6 7
		//  /
		// 8
		
		print(a);
		int n = a.length;
		for (int i = n - 1; i > 0; i--) {
			a[(i - 1) / 2] = a[i] + a[(i - 1) / 2];
		}
		print(a);
		
		
		for(int i = 0 ; (2*i+ 1) < n ; i++) {
             			 
			 a[i] = a[i]-a[2*i+ 1];
			 if(2*i+ 2 < n) {
				 a[i]  = a[i]- a[2*i+ 2];
			 }
		}
		print(a);
	}

}
