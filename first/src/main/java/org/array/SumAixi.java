package org.array;

public class SumAixi {
	static int getMaxSum(int[] a) {

		int n = a.length;
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < n; j++) {

			int sum = 0;
			for (int i = 0; i < n - j; i++) {
				sum = sum + a[i] * (i + j);
			}

			for (int i = 0; i < j; i++) {

				sum = sum + a[(n - j + i)] * i;
			}
			System.out.println(sum);
			if (max < sum) {
				
				max = sum;

			}
		}
		return max;

	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 2};
		getMaxSum(a);

	}

}
