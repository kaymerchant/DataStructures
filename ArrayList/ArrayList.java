package datastructures.arraylist;

class ArrayList<T> implements ArrayListInteface<T>{
	T [] backingArray;
	int size;
	
	public ArrayList() {
	backingArray = (T[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	public void add(T data) {
		if(data == null) {
			throw new IllegalArgumentException("data entered is null");
		}
		else {
				if(size >= backingArray.length) {
					T [] tempBackingArray = (T[]) new Object[backingArray.length * 2];
					for(int i =0; i < size; i++) {
						tempBackingArray[i] = backingArray[i];
					}
					backingArray = tempBackingArray;
				}
			backingArray[size] = data;
			size++;
				}
		}
	
	
	@Override
	public void addAtIndex(int index, T data) {
		if(data == null) {
			throw new IllegalArgumentException("data entered is null");
		}
		else if(index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
		else {
			if(size >= backingArray.length) {
				T [] tempBackingArray = (T[]) new Object[backingArray.length * 2];
				for(int i = 0 ; i < size; i++) {
					tempBackingArray[i] = backingArray[i];
				}
				backingArray = tempBackingArray;
			}
			for(int i = size ; i > index; i--) {
				backingArray[i] = backingArray[i-1];
			}
			backingArray[index] = data;
			size++;
		}
	}

	@Override
	public void addToFront(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data is null");
		}
		else {
			if(size >= backingArray.length) {
				T [] tempBackingArray = (T[]) new Object[backingArray.length*2];
				for(int i = 0; i < size; i++) {
					tempBackingArray[i] = backingArray[i];
				}
				backingArray = tempBackingArray;
			}
			for(int i =size ; i > 0; i--) {
				backingArray[i] = backingArray[i-1];
			}
			backingArray[0] = data;
			size++;
		}
	}

	@Override
	public void addToBack(T data) {
		if(data == null) {
			throw new IllegalArgumentException("data is null");
		}
		else {
			if(size >= backingArray.length) {
				T [] tempBackingArray = (T[]) new Object[backingArray.length*2];
				for(int i = 0; i < size; i++) {
					tempBackingArray[i] = backingArray[i]; 
				}
				backingArray = tempBackingArray;
				backingArray[size] = data;
				size++;
			}
		}
		
	}

	@Override
	public T get(int index) {
		return backingArray[index];
	}

	@Override
	public T removeAtIndex(int index) {
		if(index < 0 && index > size) {
			throw new IndexOutOfBoundsException("Index out of reach");
		}
		else {
			T element = backingArray[index];
			for(int i = index; i<size; i++) {
				backingArray[i] = backingArray[i+1];
			}
			size--;
			return element;
		}
	}

	@Override
	public T removeFromFront() {
		if(size == 0) {
			return null;
		}
		else {
			T element = backingArray[0];
			for(int i = 0; i < size; i--) {
				backingArray[i] = backingArray[i+1];
			}
			size--;
			return element;
			
		}
	}

	@Override
	public T removeFromBack() {
		if(size == 0) {
			return null;
		}
		else {
			size--;
			return backingArray[size];
		}
		
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		backingArray = (T[]) new Object[INITIAL_CAPACITY];	
		size = 0;
	}

	@Override
	public Object[] getBackingArray() {
		
		return backingArray;
	}
}
	

