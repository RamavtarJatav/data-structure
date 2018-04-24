package org.linkedlist;

import java.util.Stack;

public class Palindrome {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	Node mid;
	Node head;

	Palindrome() {
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
		print(head);

	}

	void print(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.data + " ");
			print(node.next);
		}
	}

	// Node reverse() {
	// Node middle = getmiddle();
	//
	//
	// }

	boolean checkpalindromeUsingStack() {
		boolean palindrome = true;
		if (head == null)
			return false;
		mid = getmiddle();
		// System.out.println(mid.data);
		System.out.println(mid.data);
		 Node node = head;
		 
		 
		 if (mid.next == null) {
			 return true;
		 }
		 Node temp= reverse(mid.next);
		 
		 temp.next =null;
         
		 Node p1 = head;
		 Node p2 = mid.next;
		 while(p2 != null) {
			 if(p2.data != p1.data) {
				 palindrome = false;
				 break;
			 }
			 p2 = p2.next;
			 p1 = p1.next;
		 }
		 
		 temp =reverse(mid.next);
		 temp.next =null;
		 
		return palindrome;

	}

	Node reverse(Node node) {
		if (node.next == null) {
			mid.next = node;
			return node;
		} else {
			Node temp1 = reverse(node.next);
			temp1.next = node;
			return node;
		}

	}

	Node getmiddle() {
		Node node1 = head;
		Node node2 = null;
		while (node1 != null) {

			if (node1.next != null) {

				if (node2 == null) {
					node2 = node1;
				}else {
					node2 = node2.next;
				}
				node1 = node1.next.next;
				

			} else {
				if(node2 == null) {
					node2 = node1;
				}else {
					node2 = node2.next;
				}
				node1 = node1.next;
			
			}

		}

		return node2;
	}

	public static void main(String[] args) {
		Palindrome ls = new Palindrome();
		ls.add(1);
		ls.add(2);
//		
		ls.add(3);
//	
 	    ls.add(2);
	     ls.add(1);
		ls.print();
		System.out.println(ls.checkpalindromeUsingStack());
		System.out.println();
		ls.print();
		// System.out.println(ls.getmiddle().data);

	}

}
