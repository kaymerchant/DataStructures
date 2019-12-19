package datastructures.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {
	LinkedList <T> backingArray;
	
	public LinkedListQueue() {
		backingArray = new LinkedList<>();
	}
	
	@Override
	public T dequeue() {
		if(backingArray.size() == 0) {
			throw new NoSuchElementException("Queue is null"); 
		}
		else {
			T element = backingArray.get(0);
			backingArray.removeFirst();
			return element;
		}
	}

	@Override
	public void enqueue(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data cannot be null");
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
	

