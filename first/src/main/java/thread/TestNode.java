package thread;

public class TestNode {
	static void print(Node head) {
		System.out.print("[ ");
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;

		}
		System.out.print("]");
	}

	static Node partion(Node head) {
		if (head == null)
			return null;
		Node node = head;
		Node prelow = head;
		Node pivot = head;
		Node preprelow =null;
		while (node.next != null) {
			
			if (pivot.data > node.next.data) {

				Node first = prelow.next;
				Node second = node.next;
				if (node.next == first) {
					// do nothing;
				} else if (first.next == node.next) {
					// swap adjcent
					prelow.next = second;
					Node temp = second.next;
					second.next = first;
					first.next = temp;
					node = second;

				} else if (first.next != second) {
					Node afterfirst = first.next;
					Node aftersecond = second.next;
					
					prelow.next = second;
					second.next = afterfirst;
					
					node.next = first;
					first.next = aftersecond;

				}
				preprelow = prelow ;
				prelow = prelow.next;
			}

			node = node.next;

		}
		System.out.println();
		print(head);
		Node aftepivot = pivot.next;
		Node afterprelow = prelow.next;
	    
	 	prelow.next = pivot.next;
	 	preprelow.next = pivot;
	 	pivot.next = afterprelow ;
	 	head = prelow;
	 
		System.out.println();
		print(head);
		System.out.print("[" + preprelow.data + " ]");
		System.out.println("[ " + afterprelow.data + " ]");
		return head;
		
	    
	    
		
		
	}

	public static void main(String[] args) {

		Node head = new Node(5);
		head.next = new Node(6);
		head.next.next = new Node(10);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(0);
		print(head);
		head = partion(head);
		print(head);

	}

}
