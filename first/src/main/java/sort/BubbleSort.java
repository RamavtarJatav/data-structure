package sort;

public class BubbleSort {
    static void sort(int[] a){
        for (int j = 0; j < a.length-1 ; j++)
    	for (int i = 0;i < a.length-1-j;i++) {
    		if (a[i]>a[i+1]) {
    			int temp = a[i];
    			a[i]=a[i+1];
    			a[i+1]= temp;
    		}
    	}
    	
    }
    
    static void print(int[] a) {
    	
    	for(int i = 0 ; i < a.length ; i++  ) {
    		System.out.print(a[i] + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		int[] a = {6,4,3,1,7,9,2};
		print(a);
		sort(a);
		print(a);
		
	}

   
}
