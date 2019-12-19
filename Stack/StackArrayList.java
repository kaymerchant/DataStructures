package datastructures.stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class StackArrayList<T> implements Stack<T> {
	ArrayList <T> backingArray;
	
	public StackArrayList() {
		 backingArray = new ArrayList<>();
		 
	}
	
	@Override
	public boolean isEmpty() {
		return (backingArray.size() == 0);
	}

	@Override
	public T pop() {
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
	public void push(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data entered cannot be null");
		}
		else {
			backingArray.add(0, data);
		}
	}

	@Override
	public int size() {
		return backingArray.size();
	}
	
	
}
