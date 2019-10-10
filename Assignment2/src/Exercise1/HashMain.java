package Exercise1;

public class HashMain {

	public static void main(String[] args) {

		Object o = 'o';
		MyHashTable hash = new MyHashTable();
		System.out.println(hash.computeHashCode(87));
		int rand = (int)(Math.random()*(10));
		System.out.println(rand);
	}

}
