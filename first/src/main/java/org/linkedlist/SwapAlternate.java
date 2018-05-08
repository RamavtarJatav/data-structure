package org.linkedlist;

public class SwapAlternate {
	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}

	}

	Node head;

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
		if (head == null)
			return;

		print(head);
		System.out.println();
	}

	void print(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			print(node.next);
		}

	}

	void swapAlternate() {
		if (head == null || head.next == null) {
			return;
		}

		Node pre = null;
		Node node1 = head;
		Node node2 = node1.next;
		Node next = node2.next;
		
		while (node1 != null && node2 != null) {
			if (pre == null) {
				node2.next = node1;
				node1.next = next;
				head = node2;
			} else {
				pre.next = node2;
				node2.next = node1;
				node1.next = next;
			}

			pre = node1;
			node1 = next;
			if (node1 != null) {
				node2 = next.next;
			}
			if (node2 != null)
				next = node2.next;

		}
	}

	public static void main(String[] args) {
		SwapAlternate ls = new SwapAlternate();
		for (int i = 1; i > 0; i--) {
			ls.add(i);
		}

		ls.print();
		ls.swapAlternate();
		ls.print();
	}

}
