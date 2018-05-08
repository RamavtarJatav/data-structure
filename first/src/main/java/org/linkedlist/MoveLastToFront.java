package org.linkedlist;

public class MoveLastToFront {
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
		}else {
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
		}
		
	}
	
	
	void print() {
		print(head);
	}
	
	void print(Node node){
		if( node != null) {
			System.out.print(node.data + " ");
			print(node.next);
		}
	}
	
	void swapLastotFirst() {
		if(head == null || head.next == null)
			return;
		
		swapLastFirst(head);
	}
	
	void swapLastFirst(Node node ) {
		 if(node.next.next == null) {
			 Node temp = node.next;
			 node.next = null;
			 temp.next = head;
			 head = temp; ;
		 }else {
			 swapLastFirst(node.next);
		 }
	}
	public static void main(String[] args) {
		MoveLastToFront ls = new MoveLastToFront();
		for(int i =7 ; i > 0 ; i--) {
			ls.add(i);
		}
		ls.print();
		ls.swapLastotFirst();
		ls.print();
	}
}
