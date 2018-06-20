package queue;

public class ArrayQueue {
	int[] array;

	int front, rear, capacity, size;

	ArrayQueue(int capacity) {
		this.capacity = capacity;
		this.front = -1;
		this.rear = 0;
		this.size = 0;
		array = new int[capacity];

	}

	void enqueue(int data) {
		if (size == capacity) {
			capacity = capacity << 1;
			int[] temp = new int[capacity];
			if (rear <= front) {
				for (int i = 0; i <= front; i++) {
					temp[i] = array[i + rear];
				}
			} else {
				int j= 0;
				for (j = 0 ; j < size - rear; j++) {
					temp[j] = array[rear+j];
				}
				for (int i = 0; i <= front; i++) {
					temp[i+j] = array[i];
				}
			}
			array = temp;
			rear = 0;
			front = size - 1;

		} else if (size < capacity){
			if (front == capacity - 1) {
				front = -1;
			}
		}

		array[++front] = data;
		size++;

	}

	Integer dequeue() {
		if (isEmpty())
			return null;
		int ele = array[rear];
		if (rear == capacity - 1) {
			rear = 0;
		} else {
			rear++;
		}
        size--;
		return ele;
	}

	boolean isEmpty() {
		return (size == 0);
	}

	void print() {
		if (isEmpty())
			return;
		if (rear <= front) {
			for (int i = rear; i <= front; i++) {
				System.out.print(array[i] + " ");
			}
		} else {
			for (int i = rear; i < capacity; i++) {
				System.out.print(array[i] + " ");
			}

			for (int i = 0; i <= front; i++) {
				System.out.print(array[i] + " ");
			}

		}

	}

	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue(4);
		aq.enqueue(1);
		aq.enqueue(2);
		aq.enqueue(3);
		aq.enqueue(4);

		aq.dequeue();
		aq.dequeue();
		aq.enqueue(1);
		aq.enqueue(2);
	    aq.enqueue(5);
	    aq.enqueue(6);
	    aq.dequeue();
		aq.dequeue();
	    aq.enqueue(7);
	    aq.enqueue(8);
	    
		aq.print();

	}

}
