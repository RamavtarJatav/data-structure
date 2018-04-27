package org.linkedlist;

public class Reversek {
	static class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
		
	}
	
	Node head;
	
	
	void add(int data) {
		if (head == null) {
			head = new Node(data);
			
		}else {
			Node temp = new Node(data);
			temp.next =head;
			head = temp;
		}
			
	}
	
	void print() {
	 print(head);
	}
	
	void print(Node node ) {
		if (node == null) {
			return;
		}else {
			System.out.print(node.data+ " ");
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
	} 
	

}
