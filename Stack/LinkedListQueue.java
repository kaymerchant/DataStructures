package datastructures.queue;

import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {
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
	
	public LinkedListQueue() {
		this.head = null;
		this.size = 0;
	}
	
	
	@Override
	public T dequeue() {
		if(head == null) {
			throw new NoSuchElementException("Queue is null"); 
		}
		else {
			T element = head.data;
			head = head.next;
			size--;
			return element;
		}
	}

	@Override
	public void enqueue(T data) {
		Node node = null;
		if(data == null) {
			throw new IllegalArgumentException("Data cannot be null");
		}
		else {
			if(head == null) {
				head = new Node(data);
			}
			else {
				node = head;
				while(node.next != null) {
					node = node.next;
				}
				node.next = new Node(data);
			}
			size++;
		}
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return size;
	}


	
	
}
