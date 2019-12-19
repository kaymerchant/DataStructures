package datastructures.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackLinkedList<T> implements Stack<T> {
	LinkedList <T> backingArray;
	
	public StackLinkedList() {
		backingArray = new LinkedList<>();
	}
	
	@Override
	public boolean isEmpty() {
		return (backingArray.size() == 0);
	}

	@Override
	public T pop() {
		if(backingArray.size() == 0) {
			throw new NoSuchElementException("Stack is empty"); 
		}
		else {
			T element = backingArray.get(0);
			backingArray.removeFirst();
			return element;
		}
	}

	@Override
	public void push(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data entered is null");
		}
		else {
			backingArray.addFirst(data);
			}
		}
	

	@Override
	public int size() {
		return backingArray.size();
	}
	

}
