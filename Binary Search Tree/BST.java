package datastructures.BST;


import java.util.*;

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
	List printList;
	
	public BST() {
		root = null;
		size = 0;
		printList = new ArrayList<T>();
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

	@Override
	public List preorder() {
		return printPreorder(root);
	}
	
	private List printPreorder(Node root) {
		if(root == null) {
			return null;
		}
		
		printList.add(root.key);
		
		printPreorder(root.left);
		
		printPreorder(root.right);
		
		return printList;
	}
	
	@Override
	public List inorder() {
		return printInorder(root);
		
	}
	
	private List printInorder(Node root) {
		if(root == null) {
			return null;
		}
		
		printInorder(root.left);
		
		printList.add(root.key);
		
		printInorder(root.right);
		
		return printList;
	}
	
	@Override
	public List postorder() {
		return printPostorder(root);
	}
	
	private List printPostorder(Node root) {
		if(root == null) {
			return null;
		}
		
		printPostorder(root.left);
		
		printPostorder(root.right);
		
		printList.add(root.key);
		
		return printList;
	}
	
	public List levelorder() {
		int height = height();
		
		for(int i = 0; i <= height; i++) {
			printLevelOrder(root, i);
		}
		
		return printList;
	}
	
	private List printLevelOrder(Node root, int level) {
		if(root == null) {
			return null;
		}
		if(level == 0) {
			printList.add(root.key);
		}
		else if(level >= 1) {
			printLevelOrder(root.left, level - 1);
			printLevelOrder(root.right, level - 1);
		}
		
		return printList;
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

	