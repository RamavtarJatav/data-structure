package stack;

public class StackLinkedListImp {
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}

	Node head;

	void push(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node temp = new Node(data);
		temp.next = head;
		head = temp;

	}

	Integer pop() {
		if (head == null)
			return null;
		
		int data = head.data;
		head = head.next;
		return data;

	}
	
	void print() {
		if (head == null )
			return;
		print(head);
		System.out.println();
	}
	
	void print(Node node) {
		System.out.print(node.data +" ");
		if(node.next != null) {
			print(node.next);
		}
	}
	
	
	public static void main(String[] args) {
		StackLinkedListImp SLL = new StackLinkedListImp();
		SLL.push(1);
		SLL.push(2);
		SLL.push(3);
		SLL.push(4);
		SLL.print();
		SLL.pop();
		SLL.pop();
		SLL.pop();
		SLL.pop();
		SLL.pop();
		SLL.push(4);
		SLL.push(4);
		SLL.push(4);
		SLL.push(4);
		
		
		SLL.print();
		
		
	}

}
