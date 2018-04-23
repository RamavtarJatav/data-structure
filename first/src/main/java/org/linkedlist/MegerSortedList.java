package org.linkedlist;

public class MegerSortedList {
	static class Node{
		int data;
		Node next ;
		Node(int data){
			this.data = data;
		}
	}
	
	static Node add(Node node, int data) {
		if(node == null) {
			node = new Node(data);
			return node;
		
			
		}
		
	     Node temp = new Node(data);
	     temp.next = node;
	     return temp;
	     
			
			
	}
	
	static void print(Node node ) {
		
		if(node == null) {
			return;
		}
		
		
		if (node.next == null ) {
			System.out.print(node.data +" ");
			
			return;
		}else {
			System.err.print(node.data + " ");
			print(node.next);
		}
		
	}
	
	
	static Node merge(Node head1 , Node head2) {
		if(head1 == null && head2 == null) {
			return null;
		}else if (head1 != null && head2 == null ) {
			
	      return head1;
		}else if(head1 == null && head2 != null) {
			return head2;
		}else if (head1 != null && head2 != null){
			Node head3 = null;
			
			while(head1 != null && head2 != null) {
				
				if(head1.data <= head2.data) {
					if(head3 == null) {
					   head3 = head1;
					}else {
						head3.next = head1;
					}
					
				}
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return head2;
		
		
	}
	public static void main(String[] args) {
		Node head1 = null ;
		Node head2 = null;
		Node head3 = null;
        for (int i = 5 ; i > 0 ; i--) {
        	Node temp = add(head1, i);
        	head1 = temp;
        }
        print(head1);
        for (int i = 10 ; i > 5 ; i--) {
        	Node temp = add(head2, i);
        	head2 = temp;
        }
        System.out.println();
        print(head2);
	
	}

}
