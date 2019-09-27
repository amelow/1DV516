package Exercise1;

public class TreeMain {

	public static void main(String[] args) {
		MyIntegerBST tree = new MyIntegerBST();
		tree.insert(4);
		System.out.println("Current node: " + tree.getValue());
		tree.insert(7);
		System.out.println("Current node: " + tree.getValue());
		tree.insert(5);
		System.out.println("Current node: " + tree.getValue());
		
		tree.insert(2);
		System.out.println("Current node: " + tree.getValue());
		tree.insert(4);
		System.out.println("Current node: " + tree.getValue());
//		tree.insert(7);
//		System.out.println("Current node: " + tree.getValue());
		
		System.out.println("Size: " + tree.size());
		System.out.println("- Output of PrintByLevels() method - ");
		tree.printByLevels();
	}

}
