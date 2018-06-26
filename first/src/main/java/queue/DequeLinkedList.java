package queue;

public class DequeLinkedList {
	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	Node front, rear;
	int size;

	void addFront(int data) {

	}

	void addRear(int data) {
		if(rear == null) {
			rear = new Node(data);
			front = rear;
		}else {
			Node temp = new Node(data);
			temp.next = rear;
			temp.prev = front;
			rear = temp;
		}
			

	}

	void removeFront(int data) {

	}

	void removeRear(int data) {

	}
	
	void printFromFront() {
		if(front == null)
			return;
		printFromFront(front);
	}
	
	void printFromFront(Node node) {
		System.out.print(node.data);
		if(node.next != null ) {
			printFromFront(node.next);
			
		}
	}

	public static void main(String[] args) {
		DequeLinkedList dLL = new DequeLinkedList();
		for(int i = 0 ; i < 10 ; i++) {
			dLL.addRear(i);
		}
		dLL.printFromFront();
	}

}
