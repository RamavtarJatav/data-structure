package org.linkedlist;

public class MegerSortedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node add(Node node, int data) {
		if (node == null) {
			node = new Node(data);
			return node;

		}

		Node temp = new Node(data);
		temp.next = node;
		return temp;

	}

	static void print(Node node) {

		if (node == null) {
			return;
		}

		if (node.next == null) {
			System.out.print(node.data + " ");

			return;
		} else {
			System.err.print(node.data + " ");
			print(node.next);
		}

	}

	static Node merge(Node head1, Node head2) {
		Node head3 = null;
		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 != null && head2 == null) {

			return head1;
		} else if (head1 == null && head2 != null) {
			return head2;
		} else if (head1 != null && head2 != null) {
			
			Node temp= null;

			while (head1 != null && head2 != null) {

				if (head1.data <= head2.data) {
					if (head3 == null) {
						head3 = head1;
						temp = head1;
					} else  {
						temp.next = head1;
						temp = temp.next;
					}

					head1 = head1.next;
				} else {
					if (head3 == null) {
						head3 = head2;
						temp = head2;
					} else {
						temp.next = head2;
						temp = temp.next;
					}
					head2 = head2.next;
				}

			}

			if (head1 == null && head2 != null) {
				temp.next = head2;
			}

			if (head1 != null && head2 == null) {
				temp.next = head1;
			}

		}
		return head3;

	}

	public static void main(String[] args) {
		Node head1 = null;
		Node head2 = null;
		Node head3 = null;
		for (int i = 14; i > 0; i-= 2) {
			Node temp = add(head1, i);
			head1 = temp;
		}
		print(head1);
		for (int i = 10; i > 0; i-=3) {
			Node temp = add(head2, i);
			head2 = temp;
		}
		System.out.println();
		print(head2);
		System.out.println();
        head3 = merge(head1, head2);
		print(head3);

	}

}
