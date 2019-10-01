package Exercise1;

public class TreeMain {

	public static void main(String[] args) {
		MyIntegerBST tree = new MyIntegerBST();
		tree.insert(3);
		tree.insert(0);
		tree.insert(4);
		tree.insert(5);
		tree.insert(7);

		System.out.println("Size: " + tree.getSize());
		System.out.println("- Output of PrintByLevels() method - " + "\n");
		tree.printByLevels();

		System.out.println("- Output of mostSimilarValue() method - " + "\n");
//		System.out.println("1. Expected Output of mostSimilarValue(3)--> "+tree.mostSimilarValue(3));
		System.out.println("2. Expected Output of mostSimilarValue(5)--> " + tree.mostSimilarValue(5));
		System.out.println("3. Expected Output of mostSimilarValue(6)--> " + tree.mostSimilarValue(6));

	}

}
