package org.array;

public class KedaneAlogrthm {

	static void maxsumContiguousArray(int[] a) {
		int n = a.length;
		int maxsum = a[0];
		int insum = a[0];
		int i = 1;
		while (i < n) {
			int num = a[i];

			if (insum >= 0) {
				if (insum + num > insum) {
					insum = insum + num;
					if (insum > maxsum) {
						maxsum = insum;
					}

				} else if (insum + num > 0 && insum + num < insum) {
					insum = insum + num;
				} else if (insum + num <= 0) {
					insum = 0;
				}
			} else if (insum < 0) {
				if (num >= 0) {
					insum = num;
					if(maxsum  < insum) {
						maxsum = insum;
					}
				} else if (num < 0) {
					if (num > insum) {
						insum = num;
						if (insum > maxsum) {
							maxsum = insum;
						}
					}
				}
			}
          i++;
		}
		System.out.println(maxsum);
	}

	public static void main(String[] args) {
		int[] a = { -9, 11, -8, -3, 9, 6 };
		maxsumContiguousArray(a);

	}

}
