package datastructures.heap;

public class Max_Heap<T extends Comparable<? super T>> implements HeapInterface<T> {
	
	int size;
	T [] heap;
	
	public Max_Heap() {
		size = 0;
		heap = (T[]) new Comparable [STARTING_SIZE];
	}
	
	private int parent(int pos) { 
			return (pos - 1)/ 2;
	}
	
	private int leftChild(int pos) {
		return (2*pos) + 1;
	}
	
	private int rightChild(int pos) {
		return (2*pos) + 2;
	}
	
	private void swap(int first, int second) {
		T temp = heap[first];
		heap[first] = heap[second];
		heap[second] = temp;
	}
	
	public T get(int pos) {
		return heap[pos];
	}
	
	@Override
	public void add(T item) {
		if(item == null) {
			throw new IllegalArgumentException("Data cannot be null");
		}
		else if(size == 0) {
			heap[0] = item;
			size++;
		}
		else {
			if(size >= heap.length) {
				T [] tempHeap = (T[]) new Comparable [(int) (heap.length * 1.5)];
				for(int i = 0; i < size; i++) {
					tempHeap[i] = heap[i];
				}
				heap = tempHeap;
			}
			heap[size] = item;
			int pos = size;
			int parentPos = parent(pos);
				if(heap[pos].compareTo(heap[parentPos]) >= 0) {
					while(heap[pos].compareTo(heap[parentPos]) > 0) {
						swap(pos, parentPos);
						pos = parentPos;
						parentPos = parent(pos);
					}
				}
				size++;
		}
	}

	@Override
	public T remove() {
		int root = 0;
		T element = heap[0];
		heap[root] = heap[size - 1];
		size--;
		heapify(root);
		
		return element;
	}

	private void heapify(int root) {
		int leftChild = leftChild(root);
		int rightChild = rightChild(root);
		int pos = 0;
		
			if(leftChild < size && heap[root].compareTo(heap[leftChild]) < 0) {
				pos = leftChild;
			}
			
			if(rightChild < size && heap[pos].compareTo(heap[rightChild]) < 0) {
				pos = rightChild;
			}
			
			if(pos != 0) {
				swap(root, pos);
				root = pos;
				heapify(root);
				}		
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		heap = (T[]) new Comparable[STARTING_SIZE];
		size = 0;
		
	}

	@Override
	public Comparable[] getBackingArray() {
		return heap;
	}

}
