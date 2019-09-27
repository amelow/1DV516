package Exercise1;

public class TreeMain {

	public static void main(String[] args) {
		MyIntegerBST tree = new MyIntegerBST();
		tree.insert(4);
		tree.insert(7);
		tree.insert(5);
		tree.insert(2);
		tree.insert(4);
		tree.insert(7);
		System.out.println("Current node: " + tree.getValue());
		System.out.println("Size: " + tree.size());
	}

}
