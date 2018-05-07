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
	Node[] altenateSublist(){
		if(head == null )
			return null;
		
		Node head1 = null;
		Node head2 = null ;
		Node node = head;
		while(node != null ) {
			Node node1 = null;
		    Node node2 = null;
		    if(head1 == null ) {
		    	head1 = node;
		    	
		    }else {
		    
		    }
		    
		    
		    if(head2 == null) {
		    	head2 = node.next;
		    }
		}
		return null;
		
	}
	public static void main(String[] args) {
		DeleteAlternate ls = new DeleteAlternate();
		for (int i = 1; i <= 13; i++) {
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
