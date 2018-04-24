package org.linkedlist;

public class RemoveDuplicateFromUnsorted {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;

		}
	}

	Node head;
	Node last;

	void add(int data) {
		if (head == null) {
			head = new Node(data);
			last = head;
		} else {
			last.next = new Node(data);
			last = last.next;
		}
	}

	void print() {
		if (head == null) {
			return;
		}

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

	void removeDuplicates() {
		if (head == null) {
			return;
		}
		Node node1 = head;

		while (node1 != null ) {

			Node node2 = node1.next;
			Node pre = node1;
			int count = 1;
			while (node2 != null) {
				if (node1.data == node2.data) {
					count++;

				} else {
					if (count > 1) {
						pre.next = node2;
						count = 1;
					}

					pre = node2;

				}

				node2 = node2.next;
			}
			
			if(count > 1) {
				pre.next = null;
			}

			node1 = node1.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicateFromUnsorted ls = new RemoveDuplicateFromUnsorted();
		ls.add(5);
		ls.add(4);
		ls.add(5);
		ls.add(5);
		ls.add(4);
		ls.add(18);
		ls.add(20);
		ls.add(3);
		ls.add(3);
		ls.add(4);
		ls.add(4);
		ls.print();
		
		ls.removeDuplicates();
		ls.print();

	}

}
