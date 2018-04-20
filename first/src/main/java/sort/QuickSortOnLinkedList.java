package sort;

import thread.Node;

public class QuickSortOnLinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public QuickSortOnLinkedList() {
		head = null;
	}

	void add(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
		}
	}

	void print() {
		if (head == null) {
			System.out.println("[]");
			return;
		}

		System.out.print("[");
		print(head);
		System.out.println("]");
		System.out.println();

	}

	void print(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		print(node.next);
	}

	void quickSort() {
		if (head == null)
			return;
		Node node = head;
		Node pi = prePartitionNode(head, null);
		// System.out.println(pi.data);
		// System.out.print();
		quickSort(head, pi);
		quickSort1(pi);

	}
	
	static void quickSort1(Node pi) {
		Node preprei = pi;
		
 	}

	void quickSort(Node start, Node pi) {
		
		Node pid = prePartitionNode(start, pi);
		
		print(head);

	}

	Node prePartitionNode(Node node, Node pi) {
		if (node == null)
			return null;

		Node pivot = node;
		Node prei = node;
		Node preprei = null;

		while (node.next != pi) {
			print();
			System.out.print("pre iteration=" + node.data + " iteranation node=" + node.next.data);
			System.out.println();

			if (pivot.data > node.next.data) {
				Node first = prei.next;
				Node second = node.next;

				if (first == second) {
					// doing nothing;
				} else if (first.next == second) {
					prei.next = second;
					Node temp = second.next;
					second.next = first;
					first.next = temp;
					node = second;

				} else {
					prei.next = second;
					Node firstAft = first.next;
					Node secondAft = second.next;
					second.next = firstAft;
					node.next = first;
					first.next = secondAft;

				}
				preprei = prei;
				prei = prei.next;
			}

			node = node.next;
		}

		print();
        //if nodes are adjecet
		if (preprei == pivot) {
			
			pivot.next = prei.next;
			prei.next = pivot;

		} else {
        // nodes are not adjecnt
			Node preiaft = prei.next;
			prei.next = pivot.next;
			preprei.next = pivot;
			pivot.next = preiaft;

			
		}
		
		if (pi != null) {
			node.next = pi;
		}
		head = prei;

		return pivot;
	}

	public static void main(String[] args) {

		QuickSortOnLinkedList qks = new QuickSortOnLinkedList();
		// 5 6 10 8 2 3 1 0
		qks.add(9);
		qks.add(18);
		qks.add(3);
		qks.add(6);
		qks.add(2);
		qks.add(10);
		qks.add(4);
		qks.add(8);
		qks.print();
		qks.quickSort();
		qks.print();

	}

}
