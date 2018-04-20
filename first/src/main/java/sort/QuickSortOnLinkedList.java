package sort;

import thread.Node;

public class QuickSortOnLinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public QuickSortOnLinkedList() {
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
		if (head == null) {
			System.out.println("[]");
			return;
		}

		System.out.print("[");
		print(head);
		System.out.println("]");
		System.out.println();

	}

	void print(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		print(node.next);
	}

	void quickSort() {
		if (head == null)
			return;
		
		quickSort(null , head, null);
	
		

	}

	void quickSort(Node preStart, Node start, Node aftEnd) {
;
		Node pid = partitionNode1(preStart, start, aftEnd);
		System.out.println(pid.data);
		if ( (head.next.data != pid.data) ) {
			quickSort(null, head, pid);
		}
		if (pid.next != null || pid.next.next != null) {
			quickSort(pid, pid.next, aftEnd);
		}
	}

	Node partitionNode1(Node preStart, Node start, Node aftEnd) {
		Node pivot = start;
		Node prei = start;
		Node node = start;
		Node preprei = preStart;
		while (node.next != aftEnd) {

			print();
			System.out.print("pre iteration=" + node.data);
			System.out.print(" iteranation node=" + node.next.data);
			System.out.print(" pivot node =" + pivot.data);
			System.out.println();

			if (pivot.data > node.next.data) {
				Node first = prei.next;
				Node second = node.next;

				if (first == second) {
					// doing nothing;
				} else if (first.next == second) {
					prei.next = second;
					Node temp = second.next;
					second.next = first;
					first.next = temp;
					node = second;

				} else {
					prei.next = second;
					Node firstAft = first.next;
					Node secondAft = second.next;
					second.next = firstAft;
					node.next = first;
					first.next = secondAft;

				}
				preprei = prei;
				prei = prei.next;
			}

			node = node.next;
		}

		if (prei == pivot) {
			return pivot;
		}
		if (preprei == pivot) {

			pivot.next = prei.next;
			prei.next = pivot;

		} else {
			// nodes are not adjecnt
			Node preiaft = prei.next;
			prei.next = pivot.next;
			preprei.next = pivot;
			pivot.next = preiaft;

		}

		if (preStart == null) {
			head = prei;
		}else {
			preStart.next = prei;
		}
		
		if(aftEnd != null ) {
			//node.next = aftEnd;
		}
		
		print();
		return pivot;
        
		
	}

//	Node partitionNode(Node node, Node pi, Node end) {
//		if (node == null)
//			return null;
//
//		Node pivot = node;
//		Node prei = node;
//		Node preprei = null;
//		if (pi == null || pi.next != node) {
//			while (node.next != pi) {
//				print();
//				System.out.print("pre iteration=" + node.data);
//				System.out.print(" iteranation node=" + node.next.data);
//				System.out.println();
//
//				if (pivot.data > node.next.data) {
//					Node first = prei.next;
//					Node second = node.next;
//
//					if (first == second) {
//						// doing nothing;
//					} else if (first.next == second) {
//						prei.next = second;
//						Node temp = second.next;
//						second.next = first;
//						first.next = temp;
//						node = second;
//
//					} else {
//						prei.next = second;
//						Node firstAft = first.next;
//						Node secondAft = second.next;
//						second.next = firstAft;
//						node.next = first;
//						first.next = secondAft;
//
//					}
//					preprei = prei;
//					prei = prei.next;
//				}
//
//				node = node.next;
//			}
//
//			print();
//			// if nodes are adjecet
//			if (prei == pivot) {
//				return pivot;
//			}
//			if (preprei == pivot) {
//
//				pivot.next = prei.next;
//				prei.next = pivot;
//
//			} else {
//				// nodes are not adjecnt
//				Node preiaft = prei.next;
//				prei.next = pivot.next;
//				preprei.next = pivot;
//				pivot.next = preiaft;
//
//			}
//
//			head = prei;
//			return pivot;
//		} else {
//			preprei = pi;
//			while (node.next != null) {
//				if (pivot.data > node.next.data) {
//					Node first = prei.next;
//					Node second = node.next;
//
//					if (first == second) {
//						// doing nothing;
//					} else if (first.next == second) {
//						prei.next = second;
//						Node temp = second.next;
//						second.next = first;
//						first.next = temp;
//						node = second;
//
//					} else {
//						prei.next = second;
//						Node firstAft = first.next;
//						Node secondAft = second.next;
//						second.next = firstAft;
//						node.next = first;
//						first.next = secondAft;
//
//					}
//					preprei = preprei.next;
//					prei = prei.next;
//				}
//
//				node = node.next;
//			}
//
//			if (prei == pivot) {
//				return pivot;
//			}
//
//			if (preprei == pivot) {
//
//				pivot.next = prei.next;
//				prei.next = pivot;
//
//			} else {
//				// nodes are not adjecnt
//				Node preiaft = prei.next;
//				prei.next = pivot.next;
//				preprei.next = pivot;
//				pivot.next = preiaft;
//
//			}
//
//			pi.next = prei;
//			return pivot;
//
//		}
//
//	}

	public static void main(String[] args) {

		QuickSortOnLinkedList qks = new QuickSortOnLinkedList();
		// 5 6 10 8 2 3 1 0
		qks.add(9);
		qks.add(10);
		qks.add(3);
		qks.add(6);
		qks.add(2);
		qks.add(18);
		qks.add(4);
		qks.add(8);
		qks.add(15);
		qks.add(25);
		qks.add(22);
		qks.print();
		qks.quickSort();
		qks.print();

	}

}
