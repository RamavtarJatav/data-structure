package org.linkedlist;

public class RemoveDuplicateFromSorted {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;

		}
	}

	Node head;
	Node last;

	void add(int data) {
		if (head == null) {
			head = new Node(data);
			last = head;
		} else {
			last.next = new Node(data);
			last = last.next;
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

	void removeDuplicate() {
		if (head == null) {
			return;
		}
		
		if(head.next == null) {
			return;
		}
		Node pre = head;
		Node node = head.next;
		int count = 1;
		while (node!= null) {
			if(node.data == pre.data) {
				count++;
				node = node.next;
			}else {
				if(count > 1) {
					pre.next = node;
					count = 1 ;
					
				}
				pre = node;
				node = node.next;
			}
			
		}
		
		
		if(count > 1) {
			pre.next = null;
		}
		
		
		
	}

	public static void main(String[] args) {
		RemoveDuplicateFromSorted ls = new RemoveDuplicateFromSorted();
		ls.add(0);
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(3);
		ls.add(4);
		ls.add(5);
		ls.add(5);
		ls.add(6);
		ls.print();
		ls.removeDuplicate();
		System.out.println();
		ls.print();

	}

}
