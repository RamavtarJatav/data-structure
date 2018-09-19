package org.array;

public class MatrixSpiralTraversal {
	static void matrixSpiralTraversal(int[][] a) {
		int R = a.length;
		int C = a[0].length;
		int N = 0; int S = R-1;
		int W = 0 ; int E = C-1;
//		while (N < S && W < E) {
//			for(int j = W ; j <= E  ;j++ ) {
//				System.out.print(a[N][j]+" ");
//			}
//			i++;
//			
//			for(int k = i ; k < R ; k++ ) {
//				System.out.print(a[k][j-1]+" ");
//			}
//		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12} , {13,14,15,16}};
		matrixSpiralTraversal(a);
	}

}
