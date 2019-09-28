package Exercise2;

public class SequenceMain {

	public static void main(String[] args) {
		MySequenceWithMinimum seq = new MySequenceWithMinimum();

		System.out.println("Expected Output of insertRight() method: 5,4,15");
		System.out.println("- Output of insertRight() method - " + "\n");
		seq.insertRight(5);
		seq.insertRight(4);
		seq.insertRight(15);
		System.out.print(seq.toString());

		/*
		 * System.out.println("Expected Output of removeRight() method: 5,4,15");
		 * System.out.println("- Output of removeRight() method - " + "\n");
		 */
	}
}