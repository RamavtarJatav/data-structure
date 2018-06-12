package greedy;

public class LargestGapInArray {

	public static void main(String[] args) {
		int[] a = { 2, 5, 7, 1, 9 };
		int n = a.length;
//		int min = Integer.MAX_VALUE;
//		int max =  Integer.MIN_VALUE;
		int min = 2^31-1;
		int max = -2^31; 
		
		for (int i = 0; i < n; i++) {
			if (a[i] < min) {
				min = a[i];
			}

			if (a[i] > max) {
				max = a[i];
			}
		}

		System.out.println(max - min);

	}

}
