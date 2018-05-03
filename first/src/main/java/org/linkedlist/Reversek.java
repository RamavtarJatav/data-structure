package org.linkedlist;

public class Reversek {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	Node head;

	static boolean found = false;

	void add(int data) {
		if (head == null) {
			head = new Node(data);

		} else {
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
		}

	}

	void reversek(int k) {
		if (head == null)
			return;

		reversek(head, k);
	}

	void reversek(Node node, int k) {
		Node nodepre = null;
		Node nodeaft = null;

		Node nodei = node;
		int count = 0;
		int count1 = 0;
		// while(count < k && nodei.next != null) {
		while (count1 < k) {
			while (count < k-count1) {

				Node node1 = nodei;
				Node node2 = node1.next;
				nodeaft = node2.next;

				if (nodepre == null) {
					node2.next = node1;
					node1.next = nodeaft;
					head = node2;
				} else {
					nodepre.next = node2;
					node2.next = node1;
					node1.next = nodeaft;
				}

				count++;

				nodepre = node2;

			}
			count1++;
			nodei = head;
			
		}

		// nodei = nodei.next;
		// count++;
		// }
		// int i = k;
		//
		// while (i > 0) {
		// nodei = nodei.next;
		// i--;
		// }
		//
		// nodeaft = nodei;
		//
		// Node temp = reverse(node, --k);
		//
		// temp.next = nodeaft;

	}

	Node reverse(Node node, int k) {

		if (k > 0) {
			if (node.next != null) {
				Node temp = reverse(node.next, --k);
				temp.next = node;
				return node;

			} else {
				return node;
			}

		} else {
			head = node;
			return node;
		}
	}

	void print() {
		print(head);
		System.out.println();
	}

	void print(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.data + " ");
			print(node.next);
		}
	}

	public static void main(String[] args) {
		Reversek ls = new Reversek();
		ls.add(8);
		ls.add(7);
		ls.add(6);
		ls.add(5);
		ls.add(4);
		ls.add(3);
		ls.add(2);
		ls.add(1);
		ls.print();
		ls.reversek(3);
		ls.print();
	}

}
