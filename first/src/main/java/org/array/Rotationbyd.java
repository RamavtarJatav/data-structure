package org.array;

public class Rotationbyd {
	
	static void rotateleft(int[] a , int d) {
		int[] temp = new int[d];
		for (int i = 0 ; i < d ; i++) {
			temp[i] = a[i];
		}
		
		int i = 0;
		for( i = 0 ; i < a.length-d ; i++) {
			
			a[i] = a[i+d];
			
		}
		
		for(int j = 0 ; j < d ; j++) {
			a[j+i] = temp[j]; 
		}
		
	}
	
	
	static void rotateright(int[] a , int d ) {
		int[] temp = new int[d];
		
		
		for(int i = 0  ; i < d ; i++) {
			temp[i] = a[a.length-d+i];
		}
		
		for(int i = a.length-1 ; i-d >= 0 ; i--) {
			a[i] = a[i-d];
		}
		
		for(int i = 0 ; i < d ; i++ ) {
			a[i] = temp[i];
		}
	}
	
	 static void print(int[] a ) {
		for(int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i]  + " ");
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {1, 2 ,3 ,4 ,5 , 6, 7};
		print(a);
		rotateleft(a , 3);
		print(a);
		rotateright(a , 1);
		print(a);
	}

}
