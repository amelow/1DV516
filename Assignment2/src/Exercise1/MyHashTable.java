package Exercise1;

/*
 * Authors: Håkan Johansson, Amelie Löwe.
 */
public class MyHashTable<T> implements A2HashTable<T> {

	private Object[] hashTable;
	private int size;
	private int count;
	private double max_load;

	public MyHashTable(double max_load) {
		count = 0;
		size = 11;
		this.max_load = max_load;
		hashTable = new Object[size];
	}

	public int getCount() {
		return count;
	}

	public Object getHashTable() {
		return hashTable;
	}

	@Override
	public void insert(Object element) {
		int pos_start = computeHashCode(element);
		int pos = computeHashCode(element);
		int i = 1;

		if (pos_start < 0 || pos < 0) {
			pos_start = -pos_start;
			pos = -pos;
		}

		while (hashTable[pos] != null) {

			pos = quadraticProbing(pos_start, i);

			if (pos_start == pos || max_load <= count / size) {
				count = 0;
				pos_start = computeHashCode(element);
				rehash();
			}
			i++;
		}

		hashTable[pos] = element;
		count++;

	}

	@Override
	public void delete(Object element) {
		int pos_start = computeHashCode(element);
		int pos = computeHashCode(element);
		for (int i = 0; i < hashTable.length; i++) {
			pos = quadraticProbing(pos_start, i);
			if (hashTable[pos] == null) {
				continue;
			}

			if (hashTable[pos].equals(element)) {
				hashTable[pos] = null;
			}
		}
		count--;
	}

	@Override
	public boolean contains(Object element) {
		int pos_start = computeHashCode(element);
		boolean found = false;

		for (int i = 0; i < size; i++) {
			int pos = quadraticProbing(pos_start, i);
			if (hashTable[pos] == null) {
				continue;
			} else if (hashTable[pos].equals(element)) {
				found = true;
				return found;
			}

		}
		return found;
	}

	@Override
	public int getLengthOfArray() {
		return size;
	}

	public int computeHashCode(Object element) {
		int hash = element.hashCode() % size;

		if (hash < 0) {
			hash = -hash;
		}
		return hash;
	}

	public int quadraticProbing(int pos, int i) {
		int hash = ((int) (pos + Math.pow(i, 2))) % size;

		if (hash < 0) {
			hash = -hash;
		}
		return ((int) (pos + Math.pow(i, 2))) % size;

	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append('{');
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] == null) {
				continue;
			}
			build.append(hashTable[i] + ", ");
		}

		build.delete(build.length() - 2, build.length() - 1);

		build.append("}");
		return build.toString();

	}

	private void rehash() {
		size = size * 2 + 1;
		Object[] temp = hashTable;
		hashTable = new Object[size];

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == null) {
				continue;
			}

			insert(temp[i]);

		}

	}
}
