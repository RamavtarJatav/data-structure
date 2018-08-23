package org.array;

public class SubSeqMaxIncreSum {
	static int sebSeqMaxIncreasingSum(int[] a) {
		int n = a.length;
		int maxSum = 0;
		int nextStartInd = 0;

		for (int j = 1; j < n; j++) {
			int prev = a[0];
			int sum = a[0];
			for (int i = j; i < n; i++) {
				if (a[i] > prev) {
					sum = sum + a[i];
					prev = a[i];
				} else if (nextStartInd == 0) {
					nextStartInd = i;
				}
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] a = { 1, 101, 2, 3, 100, 4, 5 };
		System.out.println(sebSeqMaxIncreasingSum(a));
		StringBuilder sb;

	}

}
