package org.array;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {
		int[] a = {20,4,2,8,11,19};
		for(int i = 0 ; i  < a.length-1 ; )
		Arrays.sort(a);
		for(int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i]+ " ");
		}
	}

}
