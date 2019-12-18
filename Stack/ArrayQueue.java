package datastructures.queue;


import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
	T [] backingArray;
	int size;
	
	public ArrayQueue() {
		backingArray = (T[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	@Override
	public T dequeue() {
		T element = null;
		if(backingArray == null) {
			throw new NoSuchElementException("Stack is empty");
		}
		else {
			element = backingArray[0];
			for(int i = 0; i < size; i++) {
				backingArray[i] = backingArray[i+1];
			}
		}
		size--;
		return element;
	}

	@Override
	public void enqueue(Object data) {
		if(data == null) {
			throw new IllegalArgumentException("Data entered cannot be null");
		}
		else {
			if(size >= backingArray.length) {
				T [] tempBackingArray = (T[]) new Object[backingArray.length * 2];
				for(int i = 0; i < backingArray.length; i++) {
					tempBackingArray[i] = backingArray[i];
				}
				backingArray = tempBackingArray;
			}
			backingArray[size] = (T) data;
			size++;
		}
	}

	@Override
	public boolean isEmpty() {
		return (backingArray == null);
	}

	@Override
	public int size() {
		return size;
	}



}