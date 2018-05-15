package important;

public class fibonacci {
	public static void main(String[] args) {
		int i = 30;
		int m = 0;
		int n = 1;
		System.out.print(m+ " ");
		System.out.print(n+ " ");
		while(n < 30) {
			
			System.out.print(m + n + " ");
		    int temp = m;
			m = n;
			n = temp+n;
		}
	}

}
