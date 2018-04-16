package org.linkedlist;

public class Intesection {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;

		}

	}

	static Node intersectionList(Node l1, Node l2) {
		Node n1 = l1;
		Node n2 = l2;
		Node n3 = null;
		while (n1 != null) {

			while (n2 != null) {
				if (n1.data == n2.data) {
					if (n3 == null) {
						n3 = new Node(n1.data);
					} else {

						Node temp = n3;
						n3 = new Node(n1.data);
						n3.next = temp;

					}
				}

				n2 = n2.next;
			}
			n1 = n1.next;
			n2 = l2;
		}
		return n3;

	}

	static Node union(Node l1, Node l2) {
		Node n1 = l1;
		Node n2 = l2;
		Node n3 = l1;

		boolean found = false;
		while (n2 != null) {
			while (n1 != null) {
				if (n2.data == n1.data) {
					found = true;
					break;
				}
				n1 = n1.next;
			}
			if (!found) {
				Node temp = new Node(n2.data);
				temp.next = n3;
				n3 = temp;
			}
			n2 = n2.next;
			n1 = l1;
			found = false;

		}
		return n3;

	}

	static void mergeInterUnion(Node l1, Node l2) {
		quickSort(l1);
	}

	static void quickSort(Node head) {

		Node pivot = head;

		Node preIndex = head;
		Node index = preIndex.next;
		Node postIndex = index.next;

		Node preStart = head;
		Node start = preStart.next;
		Node postStart = start.next;

		while (start != null) {

			if (pivot.data > start.data) {
				if (index == start) {
					//do nothing
                
				} else if (index.next == start) {
					preIndex.next = start;
					start.next = index;
					index.next = postStart;
					
				}else {

					preStart.next = index;
					index.next = postStart;

					preIndex.next = start;
					start.next = postIndex;

				

					// swap

				}
				preIndex = preIndex.next;
				index = index.next;
				postIndex = postIndex.next;

			}
			
			printList(head);
			System.out.println();
			preStart = preStart.next;
			start = start.next;
			postStart = postStart.next;

		}

	}

	static void printList(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		printList(root.next);
	}

	public static void main(String[] args) {
		Node linkedList1 = new Node(8);
		linkedList1.next = new Node(12);
		linkedList1.next.next = new Node(2);
		linkedList1.next.next.next = new Node(4);
		linkedList1.next.next.next.next = new Node(3);

		Node linkedList2 = new Node(10);
		linkedList2.next = new Node(15);
		linkedList2.next.next = new Node(4);
		linkedList2.next.next.next = new Node(20);
		// Node n3 = intersectionList(linkedList1, linkedList2);
		// printList(n3);
		// printList(union(linkedList1, linkedList2));
		printList(linkedList1);
		System.out.println();
		mergeInterUnion(linkedList1, linkedList2);
		printList(linkedList1);
	}

}
