package org.linkedlist;

public class ReverseAlternatekNode {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node head;

	void add(int data) {
		if (head == null) {
			head = new Node(data);

		} else {
			add(head, data);
		}
	}

	void add(Node node, int data) {
		if (node.next == null) {
			node.next = new Node(data);
		} else {
			add(node.next, data);
		}
	}

	void print() {
		if (head == null)
			return;

		print(head);
		System.out.println();
	}

	void print(Node node) {
		System.out.print(node.data + " ");
		if (node.next != null) {
			print(node.next);
		}
	}

	void reverseAlternatk(int k) {
		if (head == null)
			return;
		head = reverseAlternatk(head, k);

	}

	Node reverseAlternatk(Node node, int k) {
		print();
		int count = 0;
		Node current = node;
		Node next = null;
		Node pre = null;
		while (current != null && count < k) {
			next = current.next;
			count++;
			current.next = pre;
			pre = current;
			current = next;
		}
		//
		node.next = next;

		int count1 = 0;
		while (next != null && count1 < k - 1) {
			next = next.next;
			count1++;
		}

		Node temp = null;
		if (next != null) {
			if (next.next != null) {
				temp = reverseAlternatk(next.next, k);
			}
			
			next.next = temp;
		}

		

		return pre;
	}

	public static void main(String[] args) {
		ReverseAlternatekNode ls = new ReverseAlternatekNode();
		for (int i = 1; i <= 3 ; i++) {
			ls.add(i);
		}

		ls.print();

		ls.reverseAlternatk(3);
		ls.print();

	}

}
