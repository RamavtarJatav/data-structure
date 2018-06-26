package queue;

public class DequeArray {

	private int[] a;
	int CAPACITY = 1 << 3;
	int front, rear, size;

	DequeArray() {
		a = new int[CAPACITY];
		rear = -1;
	}

	void addFront(int data) {
		if (size == CAPACITY) {
			increaseCapacity();
		}

		if (front != 0) {
			a[--front] = data;
		} else {
			a[front = CAPACITY - 1] = data;
		}
		size++;

	}

	void removeFront() {
		if (size == 0) {
			System.out.println("queue is empty");
			return;
		}
		if (front != CAPACITY - 1) {
			a[front++] = 0;
		} else {
			a[front] = 0;
			front = 0;
		}
		size--;

	}

	void increaseCapacity() {
		CAPACITY = CAPACITY << 1;
		int[] temp = new int[CAPACITY];
		if (rear == size - 1) {
			for (int i = 0; i <= rear; i++) {
				temp[i] = a[i];
			}
		} else {
			for (int i = front; i < size; i++) {
				temp[i - front] = a[i];
			}

			for (int i = 0; i <= rear; i++) {
				int s = size - front;
				temp[s + i] = a[i];
			}

			rear = size - 1;
			front = 0;

		}
		a = temp;
	}

	void addRear(int data) {
		if (size == CAPACITY) {
			increaseCapacity();
		}

		if (rear != CAPACITY - 1) {
			a[++rear] = data;
		} else {
			a[rear = 0] = data;

		}
		size++;

	}

	void removeRear() {
		if (size == 0) {
			System.out.println("queue is empty");
			return;
		}

		a[rear--] = 0;
		size--;
	}

	void print() {
		for (int i = 0; i < CAPACITY; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DequeArray dA = new DequeArray();
		for (int i = 1; i <= 6; i++) {
			dA.addRear(i);

		}
		dA.print();
		dA.removeFront();
		dA.print();
		dA.addFront(1);
		dA.print();
		dA.addFront(-1);
		dA.print();
		dA.addFront(-2);
		dA.print();
		dA.addFront(-3);
		dA.print();
		dA.removeFront();
		dA.print();
		dA.removeFront();
		dA.print();

	}

}
