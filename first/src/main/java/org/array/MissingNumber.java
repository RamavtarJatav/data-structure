package org.array;

public class MissingNumber {
	public static void main(String[] args) {
		int[] a = {1 ,2 ,3 ,4};
		 int n = a.length;
		 int sum = 0 ;
	    for(int i = 0 ; i < n ; i++) {
	    	sum = sum+a[i];
	    }
	    
	    int idsum = ((n+1)*(n+1+1))/2;
	    int missNum = idsum- sum;
	    System.out.println(missNum);
	}

}
