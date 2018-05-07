package org.linkedlist;

public class DeleteAlternate {
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

	void deleteAlternate() {
		if (head == null || head.next == null)
			return;

		Node node = head;
		while (node != null) {
			Node n1 = node.next;
			Node n2 = null;
			if (n1 != null) {
				n2 = n1.next;

			}

			node.next = n2;
			node = n2;

		}

	}
	
	void deleteAlternateRec() {
		if(head  == null || head.next == null)
			return;
		
		deleteAlternateRec(head);
	}
	
	void deleteAlternateRec(Node node){
		 if(node == null || node.next == null)
			 return;
		 
		 node.next = node.next.next;
		 deleteAlternateRec(node.next);
	}

	public static void main(String[] args) {
		DeleteAlternate ls = new DeleteAlternate();
		for (int i = 1; i <= 10; i++) {
			ls.add(i);
		}

		ls.print();
		//ls.deleteAlternate();
		ls.deleteAlternateRec();
		ls.print();
		ls.deleteAlternate();
		ls.print();
	}

}
