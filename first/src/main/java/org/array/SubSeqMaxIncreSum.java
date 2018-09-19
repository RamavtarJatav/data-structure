package org.array;

public class SubSeqMaxIncreSum {
	static int sebSeqMaxIncreasingSum(int[] a) {
		int n = a.length;
		int maxSum = 0;
		int nstId = 0;
		boolean nnstId = true;
		
		while (nnstId) {
			nnstId = false;
			int prev = a[nstId];
			int sum = a[nstId];
			for (int i = nstId - 1; i >= 0; i--) {
				if (a[i] < prev) {
					sum = sum + a[i];
					prev = a[i];
				}
			}
			for (int i = nstId + 1; i < n; i++) {
				if (a[i] > prev) {
					sum = sum + a[i];
					prev = a[i];
				} else if (!nnstId) {
					nstId = i;
					nnstId = true;
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
