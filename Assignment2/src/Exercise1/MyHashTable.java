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

		return false;
	}

	@Override
	public int getLengthOfArray() {

		return 0;
	}

	private class Node {
		Object value;
		int numeric;

		Node(Object v, int n) {
			value = v;
			numeric = (int)Math.random()*size;
		}
	}

	private static class ComputeHash {
		static int hashcode;
		static int i;
		static int m;

	}
}