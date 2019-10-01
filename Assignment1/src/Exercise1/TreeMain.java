package Exercise1;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class TreeMain {
	/*
	 * Main method for the MyIntegerBST class
	 */
	public static void main(String[] args) {
		MyIntegerBST tree = new MyIntegerBST();
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(5);
		tree.insert(7);

		System.out.println("- Output of PrintByLevels() method - " + "\n");
		tree.printByLevels();
		/* Expected Output
		 * Depth 0: 3 
		 * Depth 1: 4 2 
		 * Depth 2: 5 1
		 * Depth 3: 7
		 */
		System.out.println("\n" + "- Output of mostSimilarValue() method - " + "\n");
		System.out.println("1.Output of mostSimilarValue(3)--> " + tree.mostSimilarValue(3)); //Expected Output: 3
		System.out.println("2.Output of mostSimilarValue(-4)--> " + tree.mostSimilarValue(-4));//Expected Output: 1
		System.out.println("3.Output of mostSimilarValue(6)--> " + tree.mostSimilarValue(6));//Expected Output: 7

	}

}
