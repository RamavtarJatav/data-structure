package mmt;

public class Array {
    public static void main(String[] args) {
		int count1 = 0,count2 = 0,count3 = 0;
    	int[] arr = { 0,1,2,0,1,1,2,0,0};
		for (int i=0;i<arr.length;i++){
			if( 0==arr[i]) {
				count1++;
			}
			if (1==arr[i]) {
				count2++;
				
			}
			if (2==arr[i]) {
				count3++;
			}
			
		}
		
		for(int i=0;i<count1;i++) {
			arr[i]=0;
			
		}
		for (int i=count1;i<count1+count2;i++) {
			arr[i]=1;
		}
		
		for (int i=count1+count2;i<count1+count2+count3;i++) {
			arr[i]=2;
		}
		
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
