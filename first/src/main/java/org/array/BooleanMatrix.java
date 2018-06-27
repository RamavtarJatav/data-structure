package org.array;

public class BooleanMatrix {
	static void print(int[][] a) {
		for(int i = 0 ; i < a.length ; i++) {
			for(int j = 0 ; j < a[i].length ; j++ ) {
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	static void makeijall1(int[][] a) {
		int[][] b = {{0, 0 ,0 ,0 },{0, 0 ,0 ,0 },{0, 0 ,0 ,0 },{0, 0 ,0 ,0 }};
		for(int i = 0 ; i < a.length ; i++) {
			for(int j = 0 ; j < a[i].length ; j++ ) {
				if(a[i][j] == 1) {
					for(int l = 0 ; l < a[i].length ;l++) {
						b[i][l] = 1;
					}
					
					for(int l = 0 ; l < a.length ;l++) {
						b[l][j] = 1;
					}
				}
			}
			
		}
		System.out.println();
		print(b);
	}
	public static void main(String[] args) {
		int[][] a = {{0, 0 ,0 ,0 },{0, 1 ,0 ,0 },{0, 0 ,0 ,0 },{0, 0 ,0 ,0 }};
		print(a);
		makeijall1(a);
	}

}
