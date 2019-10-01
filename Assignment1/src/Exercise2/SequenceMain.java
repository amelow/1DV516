package Exercise2;
/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */

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
		seq.insertRight(4);
		System.out.println("Test:" + seq.toString());
		seq.removeLeft();
		seq.removeRight();
		System.out.println(seq.toString());
		System.out.println("Min. value in sequence: " + seq.findMinimum());
		/*
		 * System.out.println("Expected Output of removeRight() method: 5,4,15");
		 * System.out.println("- Output of removeRight() method - " + "\n");
		 */
	}
}