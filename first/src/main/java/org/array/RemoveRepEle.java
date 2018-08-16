package org.array;

public class RemoveRepEle {
	static void print(int[] a) {
		int n = a.length;
		for(int i = 0 ; i < n ; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {10 , 20, 40 , 20 ,10 ,60 , 80 , 100, 80, 42};
        int n  = a.length;
        print(a);
		for(int i = 0 ; i < n ; i++) {
		    for(int j = i+1 ; j < n ; j++) {
		    	
		    		if(a[i] == a[j]) {
		    			a[j] = 0;
		    	}
		    }
		    	
		    
		}
		print(a);
		
		for(int i   = n-1 ; i >= 0 ; i--) {
		     if(a[i] == 0) {
		    	 for(int j = i-1 ; j >= 0 ; j-- ) {
		    		 if(a[j] != 0) {
		    			 int temp = a[i];
		    			 a[i] = a[j];
		    			 a[j] = temp;
		    			 break;
		    		 }
		    	 }
		     }
		}
		
		print(a);
		
	}
	

}
