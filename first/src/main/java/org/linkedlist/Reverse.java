package org.linkedlist;

public class Reverse {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	Node head;

	Reverse() {
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
		if (head == null)
			return;
		System.out.print("[ ");
		print(head);
		System.out.print("]");
	}

	void print(Node node) {
		System.out.print(node.data + " ");
		if (node.next != null) {
			print(node.next);
		}
	}
	
	
	void reverse() {
		if (head == null)
			return;
		
		Node temp = reverse(head);
		  temp.next = null;
		

	}

	Node reverse(Node node) {
		if(node.next != null ) {
			Node temp = reverse(node.next);
			
			temp.next = node;
			
			 
			return node;
		}else {
			return head = node;
		}
	}
	public static void main(String[] args) {
		Reverse list = new Reverse();
		for (int i = 0; i < 8; i++)
			list.add(i);
		list.print();
		list.reverse();
		list.print();
		
	}

}
