package datastructures.heap;

import datastructures.heap.Min_Heap;

public class MinPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>{
	Min_Heap <T> priorityQueue;
	
	public MinPriorityQueue() {
		priorityQueue = new Min_Heap<>();
	}
	
	@Override
	public void enqueue(T item) {
		priorityQueue.add(item);
	}

	@Override
	public T dequeue() {
		return priorityQueue.remove();
	}

	@Override
	public boolean isEmpty() {
		return priorityQueue.size == 0;
	}

	@Override
	public int size() {
		return priorityQueue.size;
	}

	@Override
	public void clear() {
		priorityQueue = new Min_Heap<>();
		priorityQueue.size = 0;
	}

	@Override
	public HeapInterface<T> getBackingHeap() {
		return priorityQueue;
	}

}
