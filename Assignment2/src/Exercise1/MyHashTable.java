package Exercise1;

/*
 * Authors: Håkan Johansson, Amelie Löwe.
 */
import java.util.Hashtable;

public class MyHashTable<T> implements A2HashTable<T> {

	private Object[] hashTable;
	private int size;
	private int count;

	public MyHashTable() {
		count = 0;
		size = 11;
		hashTable = new Object[size];
	}

	public int getCount() {
		return count;
	}

	public int getSize() {
		return size;
	}

	public Object getHashTable() {
		return hashTable;
	}

	@Override
	public void insert(Object element) {
		int pos = computeHashCode(element);
		int i = 0;
		if (count == size - 1) {

			System.out.println("rehash1");
			hashTable = rehash();
		}

		while (hashTable[pos] != null) {
			i++;

			pos = quadraticProbing(pos, i);
			System.out.println("Pos: " + pos);
			if (i == (int) Math.sqrt(size)) {
				System.out.println("rehash2");

//				hashTable.rehash();
			}
//			System.out.println(pos);
//			System.out.println(size);
//			System.out.println("Size: " + size);
//			System.out.println("Position: " + pos);

		}

		hashTable[pos] = element;
		count++;
	}

	@Override
	public void delete(Object element) {

	}

	@Override
	public boolean contains(Object element) {
		/*
		 * Update to fit quadratic probing
		 */
		int pos = computeHashCode(element);
		return hashTable[pos] == element;
	}

	@Override
	public int getLengthOfArray() {

		return 0;
	}

	public int computeHashCode(Object element) {
		return element.hashCode() % size;
	}

	public int quadraticProbing(int pos, int i) {
		System.out.println("Quad and size: " + (int) ((pos + Math.pow(i, 2)) % size) + ", " + size);
//		int quad = (int)((pos + Math.pow(i, 2)) % size);
		return ((int) (pos + Math.pow(i, 2))) % size;
//		return (int)(element.hashCode() + Math.pow(i, 2)) % size;
	}

	/*
	 * This code is taken from Håkans Java 2 assignment.
	 */
//	public static int gcd(int a, int b) {
//		int r = 0;
//		if (a < 0) {
//			a = (-1) * a;
//		}
//		if (b < 0) {
//			b = (-1) * b;
//		}
//		if (a % b == 0) {
//			return b;
//		} else {
//			r = a % b;
//			return gcd(b, r);
//		}
//
//	}

//	private Object[] rehash() {
//		Object[] tempHash = hashTable;
////		hashTable = new Object[size*2];
//		count = 0;
//		size = size * 2;
//
//		hashTable = new Object[size];
//		int i = 0;
//		int pos = 0;
//
//		for (int j = 0; j < hashTable.length; j++) {
//
//			if (tempHash[j] == null) {
//
//				continue;
//			}
//
////			Object temp = hashTable[j];
//
////			newHash[]
////			if (temp != null) {
////				pos = computeHashCode(temp);
////			}
//			pos = computeHashCode(tempHash[j]);
//			while (hashTable[pos] != null) {
////				i++;
//				pos = quadraticProbing(pos, i);
//
//			}
//			System.out.println("hej");
////			newHash[pos] = temp;
//			insert(tempHash[j]);
//			count++;
//		}
//		return hashTable;
//	}

//	private boolean isPrime(int n) {
//		int p = 2;
//		
//		for (int i = 0; i < (int) Math.sqrt(p); i++) {
//			p = p + 2;
//			if (p % 2 == 0 || p % 5 == 0) {
//				p++;
//			}
//			
//		}
//		return true;
//
//	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append('{');
		for (int i = 0; i < hashTable.length - 1; i++) {
			build.append(hashTable[i] + ", ");
		}

		build.append(hashTable[hashTable.length - 1] + "}");
		return build.toString();

	}

}
