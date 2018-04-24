package sort;

public class MergesortLinkedList {
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
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
		}
	}

	void print() {
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

	void mergeSort() {
		Node mid = getMid(head);
		
		

	}

	Node getMid(Node node) {
		if (head == null)
			return null;
		Node p1 = head;
		Node p2 = null;
		while (p1 != null) {

			if (p2 == null) {
				p2 = head;
			} else {
				p2 = p2.next;
			}

			if (p1.next != null) {
				p1 = p1.next.next;
			} else {
				p1 = p1.next;
			}

		}
		return p2;
	}

	public static void main(String[] args) {

		MergesortLinkedList ls = new MergesortLinkedList();
		ls.add(5);
		ls.add(4);
		ls.add(3);
		ls.add(10);
		ls.add(8);
		ls.add(6);
		ls.add(7);
		ls.print();
		System.out.println(ls.getMid(ls.head).data);

	}

}
