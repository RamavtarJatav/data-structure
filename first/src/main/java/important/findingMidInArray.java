package important;

public class findingMidInArray {
	static void print(int[] a ) {
		for(int i = 0 ; i < a.length ; i++) {
			System.err.print(a[i] + " ");
		}
		System.out.println(); 
		
	}
	
	public static void main(String[] args) {
	  int[] b = {1, 2 ,3 ,4, 5 ,6 ,7, 8, 9};	
	  int[] a = {2 ,3 ,4, 5 ,6 ,7, 8, 9 ,1};	
	  print(b);
	  print(a);
//	  int l = 8;
//	  int h = 7;
	  int l = 8;
	  int h = 3;
	  int x = (l+ h+a.length)/2 -9;
	  System.out.println(a[x]);
	}

}
