package datastructures.BST;

import java.awt.List;

public class BST<T extends Comparable<? super T>> implements BSTInterface<T>{
	
	class Node {
		Node left;
		Node right;
		T key;
		
		public Node(T data) {
			key	= data;
			left = null;
			right = null;
		}
	}
	
	Node root;
	int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	@Override
	public void add(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data cannot be null");
		}
		root = addNode(root, data);
	}
	
	private Node addNode(Node root, T data) {
		if(root == null) {
			root = new Node(data);
			size++;
			return root;
		}
		
		if(root.key == data) {
			throw new IllegalArgumentException("Duplicate data");
		}
	
		
		if(data.compareTo(root.key) < 0) {
			root.left = addNode(root.left, data);
		}
		
		if(data.compareTo(root.key) > 0) {
			root.right = addNode(root.right, data);
		}
		
		return root;
	}
	@Override
	public T remove(T data) {
		root = removeNode(root, data);
		return root.key;
	}

	private Node removeNode(Node root, T data) {
		if(root == null) {
			size--;
			return root;
		}
		
		if(data.compareTo(root.key) < 0) {
			root.left = removeNode(root.left, data);
		}
		else if(data.compareTo(root.key) > 0) {
			root.right = removeNode(root.right, data);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
		
			root.key = minValue(root.right);
			
			root.right = removeNode(root.right, root.key);
		}
		
		return root;
		
	}
	
	private T minValue(Node root) {
		T minValue = root.key;
		
		while(root.left != null) {
			minValue = root.left.key;
			root = root.left;
		}
		
		return minValue;
	}
	@Override
	public T get(T data) {
		root = getNode(root, data);
		return root.key;
	}
	
	private Node getNode(Node root, T data) {
		if(root == null || root.key == data) {
			return root;
		}
		
		if(data.compareTo(root.key) > 0) {
			return root.left = getNode(root.left, data);
		}
		
		if(data.compareTo(root.key) < 0) {
			return root.right = getNode(root.right, data);
		}
		
		return root;
	}

	@Override
	public boolean contains(T data) {
		return containsNode(root, data);
	}
	
	private boolean containsNode(Node root, T data) {
		if(root == null) {
			return false;
		} 

		if(data.compareTo(root.key) < 0) {
			return containsNode(root.left, data);
		}
		
		else if(data.compareTo(root.key) > 0) {
			return containsNode(root.right, data);
		}
		else {
			return true;
		}
	}
	
	@Override
	public int size() {
		return size;
	}

	
	public void preorder() {
		printPreorder(root);
	}
	
	private void printPreorder(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.key + " ");
		
		printPreorder(root.left);
		
		printPreorder(root.right);
	}
	
	public void inorder() {
		printInorder(root);
	}
	
	private void printInorder(Node root) {
		if(root == null) {
			return;
		}
		
		printInorder(root.left);
		
		System.out.print(root.key + " ");
		
		printInorder(root.right);
		
	}
	
	public void postoder() {
		printPostorder(root);
	}
	
	private void printPostorder(Node root) {
		if(root == null) {
			return;
		}
		
		printPostorder(root.left);
		
		printPostorder(root.right);
		
		System.out.print(root.key + " ");
	}
	
	public void levelorder() {
		int height = height();
		
		for(int i = 0; i <= height; i++) {
			printLevelOrder(root, i);
		}
	}
	
	private void printLevelOrder(Node root, int level) {
		if(root == null) {
			return ;
		}
		if(level == 0) {
			System.out.print(root.key + " ");
		}
		else if(level >= 1) {
			printLevelOrder(root.left, level - 1);
			printLevelOrder(root.right, level - 1);
		}
	}
	
	@Override
	public void clear() {
		root = null;
		
	}

	@Override
	public int height() {
		return getHeight(root);
	}

	private int getHeight(Node root) {
		if(root == null) {
			return -1;
		}
		
		int leftRoot = getHeight(root.left);
		int rightRoot = getHeight(root.right);
		
		return Math.max(leftRoot, rightRoot) + 1;
	}
}

	