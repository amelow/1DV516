package Exercise2;

public class SequenceMain {

	public static void main(String[] args) {
		MySequenceWithMinimum seq = new MySequenceWithMinimum();

		System.out.println("Expected Output of insertRight() method: 5,4,15");
		System.out.println("- Output of insertRight() method - " + "\n");
		seq.insertRight(5);
		System.out.println("Test:" + seq.toString());
		seq.insertRight(4);
		System.out.println("Test:" + seq.toString());
		seq.insertRight(15);
		System.out.println("Test:" + seq.toString());
		/*
		 * Insert left works
		 */
		seq.insertLeft(7);
		seq.insertLeft(5);
		seq.insertLeft(8);
		seq.insertLeft(99);
		System.out.println("Test:" + seq.toString());

		/*
		 * System.out.println("Expected Output of removeRight() method: 5,4,15");
		 * System.out.println("- Output of removeRight() method - " + "\n");
		 */
	}
}