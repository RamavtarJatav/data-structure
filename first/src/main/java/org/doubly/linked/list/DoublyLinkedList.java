package org.doubly.linked.list;

public class DoublyLinkedList {
	static class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data = data;
		}
		
	}
	
	Node head;
	Node lasthead;

	
	
	void add(int data) {
		if(head == null) {
			head = new Node(data);
			lasthead = head;
			
		}else {
			Node temp = new Node(data);
			temp.next = head;
			head.prev = temp;
			head = temp;
			
		
			
		}
	}
	
	void print() {
		if(head == null)
			return;
		
		print(head);
		System.out.println();
	}
	
	
	
	void print(Node node) {
		if(node == null) {
           return;			
		}else {
			System.out.print(node.data + " ");
			print(node.next);
		}
	}
	
	void reverseprint() {
		if(lasthead == null) 
			return;
		reverseprint(lasthead);
		
	}
	
	void reverseprint(Node node) {
		if(node == null) {
			return;
		}else {
			System.out.print(node.data+ " ");
			reverseprint(node.prev);
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dls = new 	DoublyLinkedList();
		dls.add(1);
		dls.add(2);
		dls.add(3);
		dls.add(4);
		dls.print();
		dls.reverseprint();
	}

}
