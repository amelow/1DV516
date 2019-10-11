package Exercise1;

public class HashMain {

	public static <T> void main(String[] args) {

		Object o = "Håkan";
		MyHashTable<T> hash = new MyHashTable<T>();

		for (int i = 0; i < 3; i++) {
			System.out.println(hash.computeHashCode(o));
//			System.out.println("Size: " + hash.getSize());
			hash.insert(o);
		}

//		
//	Object a = "Amelie";
//		hash.insert(a);
//		hash.insert(a);
//		hash.insert(a);

		System.out.println("Amount of objects: " + hash.getCount());

		System.out.println("Contains object: " + hash.contains(o));

		System.out.println("Array: " + hash.toString());
	}

}
