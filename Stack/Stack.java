package datastructures.stack;

public interface Stack<T> {
	
	public static final int INITIAL_CAPACITY = 10;

    /**
     * Return true if this stack contains no elements, false otherwise.
     *
     * This method should be implemented in O(1) time.
     *
     * @return true if the stack is empty; false otherwise
     */
    boolean isEmpty();

    /**
     * Pop from the stack.
     *
     * Removes and returns the top-most element on the stack.
     * This method should be implemented in O(1) time.
     *
     * @return the data from the front of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    T pop();

    /**
     * Push the given data onto the stack.
     *
     * The given element becomes the top-most element of the stack.
     * This method should be implemented in (if array-backed, amortized) O(1)
     * time.
     *
     * @param data the data to add
     * @throws IllegalArgumentException if data is null
     */
    void push(T data);

    /**
     * Return the size of the stack.
     *
     * This method should be implemented in O(1) time.
     *
     * @return number of items in the stack
     */
    int size();

}

