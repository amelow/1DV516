package Exercise1;

public class HashMain {

	public static <T> void main(String[] args) {

		double max_load = 0.5;
		Object o = "Håkan";
		MyHashTable<T> hash = new MyHashTable<T>(max_load);

		for (int i = 0; i < 100; i++) {
			System.out.println("Size: " + hash.getLengthOfArray());
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
		System.out.println("Number of elements in array: " + hash.getCount());
		System.out.println(hash.contains(y));
	}

}
