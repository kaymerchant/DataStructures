package datastructures.stack;

import java.util.NoSuchElementException;

public class StackLinkedList<T> implements Stack<T> {

	class Node {
		Node next;
		T data;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	int size;
	
	public StackLinkedList() {
		head = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public T pop() {
		if(head == null) {
			throw new NoSuchElementException("Stack is empty"); 
		}
		else {
			T element = head.data;
			head = head.next;
			size--;
			return element;
		}
	}

	@Override
	public void push(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data entered is null");
		}
		else {
			Node node = new Node(data);
			if(head == null) {
				head = node;
			}
			else {
				node.next = head;
				head = node;
				size++;
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

}
