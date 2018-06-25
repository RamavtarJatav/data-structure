package org.array;

public class Array2DSpiralPrint {
	public static void main(String[] args) {
		int[][] a2d = { { 1, 2, 3, 13 },
				        { 4, 5, 6, 14},
				        { 7, 8, 9, 15}, 
				        { 10, 11, 12 ,16 } };
	    //row
		int k = 0 ;
	    int l = a2d.length ;
	    //column
	    int m = 0;
	    int n = a2d[0].length;
	    while(k < l && m < n) {
	    	for(int i = m ; i < n ; i++) {
	    		System.out.print(a2d[k][i] +" ");
	    	}
	    	k++;
	    	for(int i = k ; i < l ; i++) {
	    		System.out.print(a2d[i][n-1] +" ");
	    	}
	    	n--;
	    	for(int i = n-1 ; i >= m ; i--) {
	    		System.out.print(a2d[l-1][i]+" ");
	    	}
	    	l--;
	    	for(int i = l-1 ; i >=k ;i--) {
	    		System.out.print(a2d[i][m] +" ");
	    	}
	    	m++;
	    	
	    }
    
	}
}
