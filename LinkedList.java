package datastructures.linkedlist;



public class LinkedList<T> implements LinkedListInterface<T>{
	class Node{
		Node next;
		T data;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	static int size = 0;
	
	@Override
	public void addAtIndex(int index, T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data entered cannot be null");
		}
		else if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		else {
			Node node = new Node(data);
			Node curr = head;
			Node prev = null;
			for(int i = 0; i < index; i++){
				prev = curr;
				curr = curr.next;
			}
			prev.next = node;
			node.next = curr;
		}
		size++;
		
	}

	@Override
	public void addToFront(T data) {
		Node node = new Node(data);
		if(data == null) {
			throw new IllegalArgumentException("Data entered is null");
		}
		else {
			if(head == null) {
				head = node;
				}
			else {
			node.next = head;
			head = node;
			
		}
		size++;
		}
	}

	@Override
	public void addToBack(T data) {
		Node node = null;
		if(data == null) {
			throw new IllegalArgumentException("Data entered cannot be null");
		}
		else {
			if(head == null) {
				head = node;
			}
			else {
				node = head;
				while(node.next != null) {
					node = node.next;
				}
				node.next = new Node(data);
			}
		}
		size++;
	}

	@Override
	public T removeAtIndex(int index) {
		T element = null;
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		else {
			if(index == 0) {
				removeFromFront();
			}
			else {
				Node curr = head;
				Node prev = null;
				for(int i = 0; i < index; i++) {
					prev = curr;
					element = curr.next.data;
					curr = curr.next;
				}
				prev.next = curr.next;
			}
		}
		size--;
		return element;
	}

	@Override
	public T removeFromFront() {
		T element = head.data;
		head = head.next;
		size--;
		return element;
	}

	@Override
	public T removeFromBack() {
		T element = null;
		Node curr = head;
		Node prev = null;
		while(curr.next != null) {
			prev = curr;
			element = curr.data;
			curr = curr.next;
		}
		prev.next = null;
		size--;
		return element;
	}

	@Override
	public boolean removeAllOccurrences(T data) {
		boolean flag = false;
		int counter = 0;
		if(data == null) {
			throw new IllegalArgumentException("data cannot be null");
		}
		else {
			Node curr = head;
			Node prev = null;
			for(int i = 0; i < size; i++) {
				if(curr != null && curr.data != data) {
					prev = curr;
					curr = curr.next;
					flag = false;
				}
				else{
					curr = curr.next;
					prev.next = curr;
					flag = true;
					counter++;
				}
			}
		}
		size -= counter;
		return flag;
	}

	@Override
	public T get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		else {
			T element = null;
			Node node = head;
			for(int i = 0; i <= index; i++) {
				element = node.data;
				node = node.next;
			}
			return element;
		}
	}

	@Override
	public Object[] toArray() {
		T [] array = (T[]) new Object [size];
		Node node = head;
		for(int i = 0; i < size; i++) {
			array[i] = node.data;
			node = node.next;
			
		}
		return array;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

}
	

