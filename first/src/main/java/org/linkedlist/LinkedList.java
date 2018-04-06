package org.linkedlist;

public class LinkedList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		for (int i = 9; i >= 0; i--)
			list.add(i);
		list.printList();
		// list.removeAtPosition(8);
		// list.remove(1);
		// System.out.println(list.size());
		// System.out.println(list.sizeRecursve());
		// System.out.println(list.searchRecursive(10));
		// System.out.println(list.searchRecursive(17));
		// System.out.println(list.searchRecursive(0));
		// System.out.println(list.searchRecursive(35));
		// System.out.println(list.search(1));
		// System.out.println(list.search(10));
		// System.out.println(list.search(23));
		// list.swapNode(10, 8);
		//list.swapOddEven();
		Node node =list.nthNode(10);
		System.out.println(node.data);
		list.printList();

	}

	Node head = null;

	public void swap() {
		Node node = head;
		for (int j = 0; j <= 8; j = j + 2) {
			int n = j;
			Node odd = null;
			Node beforNode = null;
			if (n == 0) {
				odd = node;
				Node even = odd.next;
				node = even.next;
				odd.next = node;
				even.next = odd;
				head = even;
			} else {
				beforNode = head;
				for (int i = 0; i < n - 1; i++) {
					beforNode = beforNode.next;
				}
				odd = beforNode.next;
				Node even = odd.next;
				node = even.next;
				odd.next = node;
				even.next = odd;
				beforNode.next = even;
			}
		}
	}

	public void swapOddEven() {
		Node odd = null;
		Node head1 = null;
		odd = head;
		Node even = odd.next;
		head1 = even.next;
		odd.next = head1;
		even.next = odd;
		head = even;

		Node beforNode = head.next;
		while (beforNode.next.next != null) {
			odd = beforNode.next;
			even = odd.next;
			head1 = even.next;
			odd.next = head1;
			even.next = odd;
			beforNode.next = even;
			beforNode = beforNode.next.next;

		}
	}

	public Node nthNode(int n) {

		if (head != null) {

			if (--n >= 0) {
				return nthNode(head.next, n);

			} else {
				return head;
			}

		}
		return null;
	}

	public Node nthNode(Node node, int n) {
		if (node != null) {

			if (--n >= 0) {
				return nthNode(node.next, n);

			} else {
				return node;
			}

		}
		return null;
	}

	// Node node1 = head;
	// for (int i = 0; i < n; i++) {
	// node1 = node1.next;
	// }

	// //node1 = node;
	// Node node2 =node1.next;
	//
	// node2.next=node;

	// head=node1;

	// Node node = head;
	// Node odd = node;
	// Node even = odd.next;
	// node = even.next;
	// odd.next = node;
	// even.next = odd;
	// node = even;
	// head = node;
	//
	//
	//
	// node = head.next.next;
	// odd = node;
	// even = odd.next;
	// node = even.next;
	// odd.next = node;
	// even.next = odd;
	// node = even;
	// head.next.next = node;
	//
	//
	//
	//
	//
	//
	//
	// node = head.next.next.next.next;
	// odd = node;
	// even = odd.next;
	// node = even.next;
	// odd.next = node;
	// even.next = odd;
	// node = even;
	// head.next.next.next.next = node;

	public void add(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node node = new Node(data);
			node.next = head;
			head = node;
		}
	}

	public void removeAtPosition(int position) {
		if (position < 0) {
			System.out.println("position is negative");
		} else {
			if (head == null) {
				System.out.println("list is empty");
			} else {
				if (--position <= -1) {
					head = head.next;
				} else {
					removeAtPosition(head, position);

				}
			}

		}

	}

	public void removeAtPosition(Node node, int position) {
		if (--position <= -1) {
			if (node.next != null) {
				node.next = node.next.next;

			} else {
				System.out.println("invalid position");
			}
		} else {
			if (node.next != null) {
				removeAtPosition(node.next, position);
			} else {
				System.out.println("invalid postion");
			}

		}

	}

	public void remove(int index) {
		Node node = head;
		if (index == 0) {
			head = node.next;

		} else {
			while (node != null) {

				if (--index <= 0) {
					node.next = node.next.next;
					break;
				}
				node = node.next;

			}
		}

	}

	public int size() {
		Node node = head;
		int i = 0;
		while (node != null) {
			i++;
			node = node.next;
		}
		return i;

	}

	public int sizeRecursve() {
		if (head != null) {
			return (1 + sizeRecursve(head.next));
		}
		return 0;
	}

	public int sizeRecursve(Node node) {
		if (node != null) {
			return 1 + sizeRecursve(node.next);
		} else {
			return 0;
		}
	}

	public void printList() {
		Node node = head;
		System.out.print("[");
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
			if (node != null)
				System.out.print(",");
		}
		System.out.print("]");
	}

	public boolean search(int data) {
		Node node = head;
		while (node != null) {
			if (node.data == data) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public boolean searchRecursive(int data) {
		if (head == null) {
			System.out.print("empty list ");
			return false;
		} else {
			return searchRecursive(head, data);

		}
	}

	public boolean searchRecursive(Node node, int data) {
		if (node != null) {
			if (node.data == data) {
				return true;
			} else {
				return searchRecursive(node.next, data);
			}
		} else {
			return false;
		}
	}

	// public void swapNode(int x, int y) {
	// if (head == null) {
	// System.out.println("list empty");
	//
	// } else {
	//
	// Node node = head;
	// Node beforeFirst = null;
	// Node beforeSecond = null;
	// boolean firstb = false;
	// if (!firstb) {
	// if (node.data == x) {
	// beforeFirst = null;
	// firstb = true;
	// }
	//
	// if (node.data == y) {
	// beforeFirst = null;
	// firstb = true;
	//
	// }
	// }
	//
	// while (node.next != null) {
	// if (!firstb) {
	// if (node.next.data == x) {
	// beforeFirst = node;
	// firstb = true;
	// }
	//
	// if (node.next.data == y) {
	// beforeFirst = node;
	// firstb = true;
	// }
	// } else {
	// if (node.next.data == x) {
	// beforeSecond = node;
	// break;
	//
	// }
	//
	// if (node.next.data == y) {
	// beforeSecond = node;
	// break;
	// }
	//
	// }
	// node = node.next;
	// }
	//
	// if (beforeFirst == null) {
	// Node firstNode = head;
	// Node secondNode=beforeSecond.next;
	// secondNode.next=head.next;
	//
	//
	// }
	//
	// }
	// }
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;

	}

}
