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
		System.out.println(); 
		
		
	}

	void print(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.data + " ");
			print(node.next);
		}
	}

	void sort() {
		sortUtil(null, head, null);
	}

	void sortUtil(Node pre, Node start, Node end) {

		Node mid = getMid(start, end);
		//if (start.next != end) {
		//	sortUtil(pre, start, mid);
		//	sortUtil(mid, mid.next, end);
			merge(pre,start, mid , end);
	//	}
	}

	void merge(Node pre , Node start, Node mid , Node end) {
		Node node1 = start;
		Node node2 = mid.next;
	//	while(node1.next != mid || node2.next != end)  
		
			if(node1.data >= node2.data) {
			   Node temp = node1.next;
			   Node temp1 = node2.next;
			   if(pre == null){
				  node2.next = node1.next;
				  mid.next = node1;
				  node1.next = temp1;
				  head = node2;
			   }
				//pre.next = node2;
				//node2.next = node1.next;
			   
	}
		

	}

	Node getMid(Node start, Node end) {
		if (start == null)
			return null;
		Node p1 = start;
		Node p2 = null;
		while (p1 != end) {

			if (p2 == null) {
				p2 = start;
			} else {
				p2 = p2.next;
			}

			if (p1.next != end) {
				p1 = p1.next.next;
			} else {
				p1 = p1.next;
			}

		}
		return p2;
	}

	public static void main(String[] args) {

		MergesortLinkedList ls = new MergesortLinkedList();
		ls.add(13);
		ls.add(11);
		ls.add(9);
		ls.add(7);
		
		ls.add(14);
		ls.add(12);
		ls.add(10);
		ls.add(8);
		ls.print();
		ls.sort();
		ls.print();
	//	System.out.println(ls.getMid(ls.head ,null).data);

	}

}
