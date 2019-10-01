package Exercise2;
/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */

public class SequenceMain {

	public static void main(String[] args) {
		MySequenceWithMinimum seq = new MySequenceWithMinimum();

		System.out.println("- Output of insertRight() method - ");
		seq.insertRight(5);
		seq.insertRight(4);
		seq.insertRight(15);
		System.out.println("InsertRight: " + seq.toString() + "\n");
		System.out.println("- Output of insertLeft() method - ");
		seq.insertLeft(7);
		seq.insertLeft(5);
		seq.insertLeft(8);
		seq.insertLeft(99);
		seq.insertRight(4);
		System.out.println("InsertLeft: " + seq.toString() + "\n");
		seq.removeLeft();
		System.out.println("After removeLeft() method: " + seq.toString());
		seq.removeRight();
		System.out.println("After removeRight() method: " + seq.toString() + "\n");
		System.out.println("Min. value in sequence: " + seq.findMinimum());

	}
}