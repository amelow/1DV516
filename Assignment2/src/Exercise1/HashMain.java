package Exercise1;

public class HashMain {

	public static <T> void main(String[] args) {
		final int NUM_INSERTIONS = 10000;
		final double MAX_LOAD = 0.75;

		Object o = "H�kan";
		MyHashTable<T> hash = new MyHashTable<T>(MAX_LOAD);

		for (int i = 0; i < NUM_INSERTIONS; i++) {
			System.out.println("Size: " + hash.getLengthOfArray());
			hash.insert(o);
			hash.insert(Math.random() * 100);
		}

		Object a = "Amelie";
		Object y = 52.3;

		System.out.println(hash.computeHashCode(y));
		hash.insert(a);
		hash.insert(a);
		hash.insert(a);
		hash.insert(y);
		System.out.println("Number of elements in array: " + hash.getCount());
		System.out.println(hash.toString());
		System.out.println(hash.contains(y));
		hash.delete(y);
		hash.delete(a);
		hash.delete(o);
		System.out.println(hash.contains(o));
		System.out.println("Number of elements in array: " + hash.getCount());
		System.out.println(hash.contains(y));
	}

}