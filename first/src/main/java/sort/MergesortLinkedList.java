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

		head = sortUtil(head);
	}

	Node sortUtil(Node start) {

		if (start == null || start.next == null)
			return start;

		Node mid = getMid(start);
		Node midNext = mid.next;
		mid.next = null;
		Node left = sortUtil(start);
		Node right = sortUtil(midNext);
		print();
		return merge(left, right);
		
	}

	Node merge(Node left, Node right) {
		// Node preNode1 =null;
		Node node1 = left;

		// Node preNode2 = null;
		Node node2 = right;

		Node result = null;
		Node last = null;

		while (node1 != null && node2 != null) {

			if (node1.data >= node2.data) {
                if(result == null) {
                	result = node2;
                	last = result;
                	
                }else {
                	last.next = node2;
                	last = last.next;
                }
                node2 = node2.next;
			}else {
				if(result == null) {
                	result = node1;
                	last = result;
                }else {
                	last.next = node1;
                	last = last.next;
                }
                node1 = node1.next;
			}
			
			
		}
		
		
		while(node1 != null) {
			if(result == null) {
            	result = node1;
            	last = result;
            }else {
            	last.next = node1;
            	last = last.next;
            }
			node1 = node1.next;
		}
		
		while(node2 != null) {
			if(last == null) {
            	last = node2;
            	result = last;
            }else {
            	last.next = node2;
            	last = last.next;
            }
            node2 = node2.next;
			
		}
		
		return result;

	}

	Node getMid(Node start) {
		if (start == null)
			return null;
		Node p1 = start;
		Node p2 = null;
		while (p1 != null) {

			if (p2 == null) {
				p2 = start;
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
		ls.add(11);
		ls.add(13);
		ls.add(7);
		ls.add(9);

		ls.add(12);
		ls.add(14);
		ls.add(8);
		ls.add(10);
		ls.print();
		ls.sort();
		ls.print();
		// System.out.println(ls.getMid(ls.head ,null).data);

	}

}
