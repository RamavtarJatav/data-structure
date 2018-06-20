package org.array;

public class ArrayListImp {
	int[] array;
	int size = 0;
	int intialCapacity = 1 << 2;
	int CAPACITY;

	ArrayListImp() {
		CAPACITY = intialCapacity;
		array = new int[CAPACITY];

	}

	void add(int data) {
		if (size == CAPACITY) {
			CAPACITY = CAPACITY << 1;
			int[] temp = new int[CAPACITY];
			for (int i = 0; i < size; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[size] = data;
		size++;

	}

	void remove(int data) {
		if(isEmpty())
			return;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] == data) {
				index = i;
				break;
			}
		}
		
		
		for (int i = index; i < size-1; i++) {
			 array[i] = array[1+i];
		}
		array[size-1] = 0;
		size--;
		
	}
	
	boolean isEmpty() {
		return (size == 0) ;
	}

	void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayListImp aL = new ArrayListImp();
		System.out.println(aL.isEmpty());
		for (int i = 1; i <= 4; i++) {
			aL.add(i);
		}
		
		aL.remove(1);
		aL.remove(2);
		aL.remove(3);
		aL.remove(4);
		aL.print();
		System.out.println(aL.size);
		System.out.println(aL.isEmpty());
		
	}

}
