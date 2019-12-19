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
	
	public void print() {
		for(int i = 0; i <backingArray.size(); i++) {
			System.out.println(backingArray.get(i));
		}
	}
	public static void main(String [] args) {
		Stack <Integer> q = new StackLinkedList<>();
		q.push(4);
		q.push(3);
		q.push(5);
		System.out.println(q.pop());
		//q.print();
		//System.out.println(q.size());
	}

}
