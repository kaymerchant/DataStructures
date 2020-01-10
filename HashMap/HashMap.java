package datastructures.hashmap;

import java.util.*;

public class HashMap<K,V> implements HashMapInterface<K, V> {
	
	class HashNode<K,V> {
		K key;
		V value;
		HashNode <K,V> next;
		
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private HashNode<K,V> [] table;
	int size;
	
	public HashMap() {
		table = new HashNode[INITIAL_CAPACITY];
		size = 0;
	}
	
	private int bucket(K key) {
		int hashNumber = key.hashCode()%table.length;
		return hashNumber;
	}
	
	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		if(key == null || value == null) {
			throw new IllegalArgumentException("Err, data cannot be null");
		}
		
		if((double)(size + 1)/ (double)(table.length) > MAX_LOAD_FACTOR) {
			resizeBackingTable(2 * table.length + 1);
		}
		
		int bucket = bucket(key);
		
		HashNode<K,V> existing = table[bucket];
		
		if(existing == null) {
			table[bucket] = new HashNode<K, V>(key, value);
			size++;
		}
		else {
			while(existing.next != null) {
				if(existing.key.equals(key)) {
					existing.value = value;
					return value;
				}
				existing = existing.next;
			}
			
			if(existing.key.equals(key)) {
				existing.value = value;
			}
			else {
				existing.next = new HashNode<K, V>(key, value);
				size++;
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		if(key == null) {
			throw new IllegalArgumentException("Err, key is null");
		}
		
		int bucket = bucket(key);
		
		HashNode<K,V> existing = table[bucket];
		HashNode<K,V> prev = null;
		
		if(existing == null) {
			throw new java.util.NoSuchElementException("Err, key not found");
		}
		else {
			while(existing != null) {
				if(existing.key.equals(key)) {
					break;
				}
				prev = existing;
				existing = existing.next;
			}
			
			if(prev != null) {
				prev.next = existing.next; 
			}
			else {
				table[bucket] = null;
			}
		}
		size--;
		return existing.value;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		if(key == null) {
			throw new IllegalArgumentException("Err, key is null");
		}
		else {
			int bucket = bucket(key);
			
			HashNode<K,V> existing = table[bucket];
			
			while(existing != null) {
				if(existing.key.equals(key)) {
					return existing.value;
				}
				existing = existing.next;
			}
			throw new java.util.NoSuchElementException("No such key found");
		}
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		if(key == null) {
			throw new IllegalArgumentException("Err, key is null");
		}
		else {
			int bucket = bucket(key);
			
			HashNode<K,V> existing = table[bucket];
			
			while(existing != null) {
				if(existing.key.equals(key)) {
					return true;
				}
				existing = existing.next;
			}
			return false;
		}
	
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		table = new HashNode[INITIAL_CAPACITY];
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		HashSet<K> keySet = new HashSet<K>(size);
		for(HashNode<K,V> item : table) {
			if(item != null) {
				keySet.add(item.key);
				while(item.next != null) {
					item = item.next;
					keySet.add(item.key);
				}
			}
		}
		return keySet;
	}

	@Override
	public List<V> values() {
		// TODO Auto-generated method stub
		ArrayList<V> values = new ArrayList<>();
		for(HashNode<K, V> item : table) {
			if(item != null) {
				values.add(item.value);
				while(item.next != null) {
					item = item.next;
					values.add(item.value);
				}
			}
		}
		return values;
	}

	private V putArray(K key, V value) {
		
		int bucket = bucket(key);
		
		HashNode<K,V> existing = table[bucket];
		
		if(existing == null) {
			table[bucket] = new HashNode<K, V>(key, value);
			size++;
		}
		else {
			while(existing.next != null) {
				existing = existing.next;
			}
			existing.next = new HashNode<K, V>(key, value);
			size++;
		}
		return null;
	}
	@Override
	public void resizeBackingTable(int length) {
		// TODO Auto-generated method stub
		size = 0;
		HashNode<K,V> [] backingArray = table;
		table = new HashNode[length];
		for(HashNode<K,V> item : backingArray) {
			if(item != null) {
				putArray(item.key, item.value);
				while(item.next != null) {
					item = item.next;
					putArray(item.key, item.value);
				}
			}
		}
	}
}
	