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

		head = reversek(head, k);
	}

	Node reversek(Node node, int k) {

		Node current = node;
		Node prev = null;
		Node next = null;
		int i = 0;
		while (i < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			i++;
		}

		if (next != null)
			next = reversek(next, k);

		node.next = next;

		return prev;

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
