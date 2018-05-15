package org.array;

public class Rotationbyd {

	static void rotateleft(int[] a, int d) {
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = a[i];
		}

		int i = 0;
		for (i = 0; i < a.length - d; i++) {

			a[i] = a[i + d];

		}

		for (int j = 0; j < d; j++) {
			a[j + i] = temp[j];
		}

	}

	static void jugglingleftrotate(int[] a, int d) {
		int gcd = getgcd(a.length, d);
		int j = 0; 
		
		while (j < d){
			int temp = a[j];
			int i = 0;
			
			int g = 0;
			for (i = j-g-1; i < a.length - gcd; i = i + gcd) {
				print(a);
				a[i] = a[i + gcd];

			}
			a[i-gcd] = temp;
			if(g < gcd-1) {
				g = g+1;
			}else {
				g = 0;
			}
         
			
			// a[i+1] = temp;
         j++;
		}

	}
	
	static void reversalleftAlg(int[] a , int d) {
		reverse(a , 0 , d-1);
		reverse(a , d , a.length-1);
		reverse(a , 0 , a.length-1);
		
	}
	
	static void reversalrightAlg(int[] a , int d) {
		reverse(a , 0 , a.length-d-1);
		reverse(a , a.length-d , a.length-1);
		reverse(a , 0 , a.length-1);
		
	}
	
	static void reverse(int[] a , int is , int ie) {
	 while(is < ie) {
		 int temp = a[is];
		 a[is] = a[ie];
		 a[ie] = temp;
		 is++;
		 ie--;
	 }
	}
	
	

	static void rotateright(int[] a, int d) {
		int[] temp = new int[d];

		for (int i = 0; i < d; i++) {
			temp[i] = a[a.length - d + i];
		}

		for (int i = a.length - 1; i - d >= 0; i--) {
			a[i] = a[i - d];
		}

		for (int i = 0; i < d; i++) {
			a[i] = temp[i];
		}
	}

	static int getgcd(int a, int b) {
		if ((a % b) == 0) {
			return b;
		} else {
			return getgcd(b, a % b);
		}
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 ,9 };
		print(a);
		// rotateleft(a , 3);
		//jugglingleftrotate(a, 3);
		//reversalleftAlg(a , 3);
         reversalrightAlg(a ,3);
		// print(a);
		// System.out.println(getgcd(a.length , 3));
		// rotateright(a , 1);
		print(a);
	}

}
