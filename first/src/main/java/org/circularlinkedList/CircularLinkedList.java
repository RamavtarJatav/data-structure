package org.circularlinkedList;

public class CircularLinkedList {
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	Node last;
	
	void addRear(int data) {
		if (last == null ) {
			last = new Node(data);
			last.next = last;
		}else {
			Node temp = new Node(data);
			Node first = last.next;
			last.next = temp;
			temp.next = first;
			last = temp;
		}
		
			
	
	}
	
	void addFront(int data) {
		if(last == null) {
			last = new Node(data);
		}else {
		   Node temp = new Node(data);
		   Node first = last.next;
		   temp.next = first;
		   last.next = temp;
		  // last = last.next;
		}
	}
	
	void removeRear() {
		if (last == null)
			return;
		Node node = last;
		while(node.next != last) {
			node = node.next;
		}
		
		node.next = last.next;
		last = node;
		
	}
	
	void removeFront() {
		if(last == null) {
			return;
		}else {
			last.next = last.next.next;
		}
	}
	
	void print() {
		if(last == null ) 
			return;
		
		print(last.next);
		System.out.println();
	}
	
	void print(Node node) {
		if(node == last) {
			System.out.print(node.data + " ");
			return;
		}else{
			System.out.print(node.data + " ");
			print(node.next);
		}
	}
	
	void reverse() {
		if(last == null) {
			return;
		}else {
			Node temp = reverse(last.next);
			temp.next = last;
			last = temp;
		}
	}
	
	Node reverse(Node node) {
		if(node == last) {
			last = node;
			return node;
		}else {
			Node temp = reverse(node.next);
			temp.next = node;
			return node;
		}
	}
	public static void main(String[] args) {
		CircularLinkedList cls = new CircularLinkedList();
		
		cls.addRear(1);
		//cls.print();
		cls.addRear(2);
		//cls.print();
		cls.addRear(3);
		//cls.print();
		cls.addRear(4);
		cls.print();
//		cls.addFront(5);
//		cls.print();
//		cls.addRear(6);
//		//cls.removeRear();
//		cls.print();
//		cls.removeFront();
//		cls.print();
		cls.reverse();
		cls.print();
		
		
	}
   
	
}
