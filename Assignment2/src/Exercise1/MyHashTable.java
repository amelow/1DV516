package Exercise1;

public class MyHashTable<T> implements A2HashTable<T> {

	private Object[] hashTable;
	private int size;
	private int count;

	public MyHashTable() {
		count = 0;
		size = 10;
		hashTable = new Object[size];
	}

	@Override
	public void insert(Object element) {
		
	}

	@Override
	public void delete(Object element) {

	}

	@Override
	public boolean contains(Object element) {
		int pos = computeHashCode(element);
//		element = new Node(element, count);
//		int pos = computeHashCode();
//		return hashTable[computeHashCode(element)];
		return true;
	}

	@Override
	public int getLengthOfArray() {

		return 0;
	}

	public int computeHashCode(Node n) {
		return n.numeric % size;
	}

	public int quadraticProbing(int value, int i) {
		return (int) (value + Math.pow(i, 2)) % size;
	}

	private void reHash() {
		Object []temp = hashTable;
		Object [] newHash = new Object[size*2];
		int i = 0;
		
		for(Object n : temp) {
			
			if(n == null) {
				continue;
			}
			
			while (i < temp.length) {
				
			}
		}
		
	}

	private class Node {
		Object value;
		int numeric;

		Node(Object v, int n) {
			value = v;
			numeric = (int) (Math.random() * (size));
		}
	}

	/*
	 * private static class ComputeHash { static int hashCode; static int i; static
	 * int m;
	 * 
	 * int computeHashCode() { hashCode = (int)Math.floorMod(i, m); return hashCode;
	 * } }
	 */
}
