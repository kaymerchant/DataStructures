package datastructures.queue;


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
	ArrayList<T> backingArray;
	
	
	public ArrayQueue() {
		backingArray = new ArrayList<>();
	}
	
	@Override
	public T dequeue() {
		T element = null;
		if(backingArray.size() == 0) {
			throw new NoSuchElementException("Stack is empty");
		}
		else {
			element = backingArray.get(0);
			backingArray.remove(0);
			}
		return element;
	}

	@Override
	public void enqueue(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data entered cannot be null");
		}
		else {
			backingArray.add(data);
		}
	}

	@Override
	public boolean isEmpty() {
		return (backingArray.size() == 0);
	}

	@Override
	public int size() {
		return backingArray.size();
	}
	
	
}