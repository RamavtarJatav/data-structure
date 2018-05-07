package org.linkedlist;

import org.linkedlist.DeleteAlternate.Node;

public class AlternateSublist {
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

	Node[] altenateSublist() {
		if (head == null)
			return null;

		Node head1 = null;
		Node last1 = null;
		Node head2 = null;
		Node last2 = null;
		Node node = head;
		while (node != null) {
			
			if (head1 == null) {
				head1 = node;
				last1 = node;

			} else {
				last1.next = node;
				last1 = last1.next;

			}

			if (node.next != null) {
				node = node.next;
			}else {
				break;
			}
			if (head2 == null) {
				head2 = node;
				last2 = node;

			} else {
				last2.next = node;
				last2 = last2.next;

			}
			
			
			node = node.next;
		}
		
		last2.next = null;
		
		last1.next = null;
		
		Node[] a =  new Node[2];
		a[0] = head1;
		a[1] = head2;
		return a;

	}

	public static void main(String[] args) {
		AlternateSublist ls = new AlternateSublist();
		for (int i = 1; i <= 12; i++) {
			ls.add(i);
		}

		ls.print();
		// ls.deleteAlternate();
		
		Node[] a = ls.altenateSublist();
		ls.print(a[0]);
		System.out.println();
		ls.print(a[1]);
	}

}
