package queue;

public class LinkedListQueue {

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	Node rear;
	Node front;

	void enqueue(int data) {
		if (rear == null) {
			rear = new Node(data);
			front = rear;
		} else {
			Node temp = new Node(data);
			rear.prev = temp;
			temp.next = rear;
			rear = temp;

		}
	}
	
	void dequeue() {
		if(front == null) 
			return; 
		front = front.prev;
		front.next = null;
			
	}

	void print() {
		if (front == null)
			return;

		print(front);
		System.out.println();
	}

	void print(Node node) {
		System.out.print(node.data + " ");
		if (node.prev != null) {
			print(node.prev);
		}
	}

	void printReverse() {
		if (rear == null)
			return;
		printReverse(rear);
		System.out.println();
	}

	void printReverse(Node node) {
		System.out.print(node.data + " ");
		if (node.next != null) {
			printReverse(node.next);
		}
	}

	public static void main(String[] args) {
		LinkedListQueue lLq = new LinkedListQueue();
		for (int i = 0; i <= 20; i += 2) {
			lLq.enqueue(i);
		}

		lLq.print();
		lLq.dequeue();
		lLq.print();
		lLq.dequeue();
		lLq.print();
		lLq.enqueue(234);
		lLq.print();
		lLq.dequeue();
		lLq.print();
		
		
	}

}
