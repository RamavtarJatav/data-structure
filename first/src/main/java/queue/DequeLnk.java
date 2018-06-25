package queue;

public class DequeLnk {
	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	Node front, rear;

	void addRear(int data) {
		if (rear == null) {
			rear = new Node(data);
			front = rear;
		} else {
			Node temp = new Node(data);
			temp.next = rear;
			rear.prev = temp;
			rear = temp;
		}
	}

	void removeFront() {
         if(front == null)
        	return;
         front = front.prev;
         front.next = null;
	}

	void addFront(int data) {
		if (front == null) {
			front = new Node(data);
			rear = front;
		} else {
			Node temp = new Node(data);
			temp.prev = front;
			front.next = temp;
			front = temp;
		}

	}

	void removeRear() {
		if(rear == null) 
			return;
		rear = rear.next;
		rear.prev = null;

	}

	void printFromFront() {
		if (front == null)
			return;

		printFromFront(front);
		System.out.println();

	}

	void printFromFront(Node node) {
		System.out.print(node.data + " ");
		if (node.prev != null) {
			printFromFront(node.prev);
		}
	}

	void printFromRear() {
		if (rear == null)
			return;
		printFromRear(rear);
		System.out.println();
	}

	void printFromRear(Node node) {
		System.out.print(node.data + " ");
		if (node.next != null) {
			printFromRear(node.next);
		}
	}

	public static void main(String[] args) {
		DequeLnk deque = new DequeLnk();
		for (int i = 0; i <= 10; i++)
			deque.addRear(i);

		for (int i = 11; i <= 20; i++)
			deque.addFront(i);

		deque.printFromFront();
		deque.removeFront();
		deque.printFromFront();
		deque.removeFront();
		deque.printFromFront();
		deque.removeRear();
		deque.printFromFront();
		deque.removeRear();
		deque.printFromFront();
		
		
		

	}

}
