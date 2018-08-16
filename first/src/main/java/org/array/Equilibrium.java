package org.array;

public class Equilibrium {
	static int equilibriumPoint(int[] a) {
		int iu = a.length - 1;
		int il = 0;
		int suml = a[0];
		int sumu = a[iu];
		boolean equ = false;
		if(iu == 0) {
			return 0;
		}
		if(iu%2 == 1) {
			return -1;
		}
		while (il + 2 <= iu ) {
			if (suml < sumu) {
				suml = suml + a[++il];
			} else if (suml >= sumu) {
				sumu = sumu + a[--iu];
			}
		}
		if (sumu == suml) {
			return il+1;
		} else {
			return -1;
		}

	}

	static void print(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//int[] a = { 3, 4, 1, 6, 8, 1, 2, 22,1 };
		int[] a = {32, 41, 34, 26, 34, 30 ,10 ,11 ,23 ,20 ,10 ,12 ,25, 5 ,7 ,41, 7 ,43, 25};
		
		print(a);
		System.out.println(equilibriumPoint(a));
	}

}
