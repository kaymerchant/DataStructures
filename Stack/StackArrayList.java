package datastructures.stack;

import java.util.NoSuchElementException;

public class StackArrayList<T> implements Stack<T> {
	T [] backingArray;
	int size;
	
	public StackArrayList() {
		 backingArray = (T[]) new Object[INITIAL_CAPACITY];
		 size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public T pop() {
		T element = null;
		if(backingArray == null) {
			throw new NoSuchElementException("Stack is empty");
		}
		else {
			element = backingArray[0];
			for(int i = 0; i < backingArray.length - 1; i++) {
				backingArray[i] = backingArray[i+1];
			}
		}
		size--;
		return element;
	}

	@Override
	public void push(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data entered cannot be null");
		}
		else if(size == 0) {
			backingArray[0] = data;
			size++;
		}
		else {
			if(size >= backingArray.length) {
				T [] tempBackingArray = (T[]) new Object [backingArray.length * 2];
				for(int i = 1; i < backingArray.length; i++) {
					tempBackingArray[i] = backingArray[i-1];
				}
				backingArray = tempBackingArray;
			}
			for(int i = size ; i > 0; i--) {
				backingArray[i] = backingArray[i-1];
			}
			backingArray[0] = data;
			size++;
		}
	}

	@Override
	public int size() {
		return size;
	}
	
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.println(backingArray[i]);
		}
	}

}
