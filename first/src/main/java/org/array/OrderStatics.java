package org.array;

import java.util.PriorityQueue;

public class OrderStatics {

	// kth smallest array

	static void kthSmallest(int[] a, int k) {
		int n = a.length - 1;
		minHeapify(a, n, k);
	}

	static void minHeapify(int[] a, int n, int k) {
		if (k > 0) {
			for (int i = n; i > 0; i--) {
				int j = (i - 2) / 2;
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			int temp = a[0];
			a[0] = a[n];
			a[n] = temp;
			if (n > 0) {
				minHeapify(a, --n, --k);
			}
		} else {
			return;
		}
	}

	static void print(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	// kth smallest in 2D array

	static HeapNode[] kthsmallest2dArray(int[][] a, int k) {
		int n = a.length;
		int size = n * n;
		HeapNode[] heapNodes = new HeapNode[size];
		int i = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {

				heapNodes[i++] = new HeapNode(a[r][c], r, c);
			}
		}

		buildminHeap(heapNodes, size - 1, k);
		return heapNodes;
	}

	static void buildminHeap(HeapNode[] heapNodes, int n, int k) {
		if (k > 0) {
			for (int i = n; i > 0; i--) {
				int j = (i - 2) / 2;
				if (heapNodes[j].data > heapNodes[i].data) {
					HeapNode temp = heapNodes[j];
					heapNodes[j] = heapNodes[i];
					heapNodes[i] = temp;
				}
			}

			HeapNode temp = heapNodes[0];
			heapNodes[0] = heapNodes[n];
			heapNodes[n] = temp;
			buildminHeap(heapNodes, --n, --k);
		}
	}

	static class HeapNode {
		int data;
		int row;
		int column;

		public HeapNode(int data, int row, int column) {
			this.data = data;
			this.row = row;
			this.column = column;
		}

		@Override
		public int hashCode() {
			return data;
		}

		@Override
		public boolean equals(Object ob) {
			if (ob instanceof HeapNode) {
				HeapNode oth = (HeapNode) ob;
				this.data = oth.data;
				return true;
			} else {
				return false;
			}
		}

	}

	// ques3 largest 3 elements
	public static void largest3Elements(int[] a) {
		int x = Integer.MIN_VALUE;
		int y = Integer.MIN_VALUE;
		int z = Integer.MIN_VALUE;
		int n = a.length;
		if( n < 3 ) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if (a[i] > x) {
				y = x ;
				z = y;
				x = a[i];
				
			} else if (a[i] > y) {
				z = y;
				y = a[i];
			} else if (a[i] > z) {
				z = a[i];
			}
		}
		
		System.out.println(x +" " + y + " " +z+ " ");
	}
	
	//ques  4 median of stream
	
	static void medianOfStream(int[] a) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int n = a.length;
		float median = a[0] ;
		minHeap.add(a[0]);
		for (int i = 1 ; i < n ; i++) {
			float el = a[i];
			if(el < a[i])
			
			if(maxHeap.size() > minHeap.size()) {
			  
			}
			
		}
	}

	public static void main(String[] args) {

		// ques 1
		// int[] a = { 2, 7, 4, 1, 9, 6, 18, 12, 3 };
		// print(a);
		// kthSmallest(a, 2);
		// print(a);
		// System.out.println(a[a.length - 2]);

		// que2
		// int mat[][] = { {10, 20, 30, 40},
		// {15, 25, 35, 45},
		// {25, 29, 37, 48},
		// {32, 33, 39, 50},
		// };
		//
		// HeapNode[] h = kthsmallest2dArray(mat, 8);
		// System.out.println(h[mat.length * mat.length- 8].data);
		
		//que 3 
		   int[] a = { 2, 7, 4, 1, 9, 6, 18, 12, 3 };
		   largest3Elements(a);	

	}

}
