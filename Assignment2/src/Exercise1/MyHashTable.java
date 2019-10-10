package Exercise1;

public class MyHashTable<T> implements A2HashTable<T> {

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

		Object value = null;

		Node(int v) {
			value = v;
		}
	}

	private static class ComputeHash {
		static int hashcode;
		static int i;
		static int m;

	}
}
