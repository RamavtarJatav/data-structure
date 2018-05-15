package important;

public class factorial {
	static int k = 0;
	static int fact(int j, int r) {
		if( j == r ) {
			return j;
		}else {
			return j*fact(j-1, r); 
		}
	}
	public static void main(String[] args) {
		int i= 6;
		int r = 2;
		k = 6-r+1;
		System.out.println(fact(i, k));
	}

}
