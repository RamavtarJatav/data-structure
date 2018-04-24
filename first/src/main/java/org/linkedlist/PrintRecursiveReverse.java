package org.linkedlist;

public class PrintRecursiveReverse {

	Node head;
	Node last;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	void printReverse() {
        
	}

	void add(int data) {
		if (head == null) {
			head = new Node(data);
		    last = head;
		}else {
			last.next = new Node(data);
			last = last.next;
		}
		
		
	}
	
	
	void print() {
		if(head == null) 
			return;
	    
		Node node = head; 
		print(head);
	}
    
	void print(Node node) {
		if(node == null) {
			return;
		}else {
			
			print(node.next);
			System.out.print(node.data + " ");
		}
	}
	public static void main(String[] args) {
		PrintRecursiveReverse ls = new PrintRecursiveReverse();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		ls.print();
	} 

}
