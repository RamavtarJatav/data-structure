package org.linkedlist;

public class IntersectionSorted {
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	Node head;
	
	void add(int data) {
		if(head == null) {
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
    
	void print(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			print(node.next);
		}
		
	}
	
	
	static Node intersection(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return null;
		
		Node node1 = head1;
		Node node2 = head2;
		Node node3 = null;
		Node last = null;
		while(node1 != null && node2 != null) {
			if (node1.data == node2.data) {
		         if(node3 == null) {
		        	 node3 = node1;
		        	 last = node3;
		         }else {
		        	 last.next = node1;
		        	 last = last.next;
		         
		        	 
		         }
		         node1 = node1.next;
		         node2 = node2.next;
			}else if(node1.data < node2.data) {
				node1 = node1.next;
			}else {
				node2 = node2.next;
			}
		}
		
		last.next = null;
		return node3;
	}
	
	
	//static void 
	
	public static void main(String[] args) {
		IntersectionSorted ls1 = new IntersectionSorted();
		IntersectionSorted ls2 = new IntersectionSorted();
		for(int i = 10 ; i > 0 ; i--) {
			ls1.add(i);
		}
		
		for(int i = 15 ; i > 0 ; i=i-2) {
	       ls2.add(i);		
		}
		ls1.print();
		System.out.println();
		ls2.print();
		Node  head3 =IntersectionSorted.intersection(ls1.head, ls2.head);
		
		IntersectionSorted ls3 = new IntersectionSorted();
		ls3.head = head3;
		System.out.println();
		ls3.print();
		
	}
	
	
	
}
