package Exercise1;

public class TreeMain {

	public static void main(String[] args) {
		MyIntegerBST tree = new MyIntegerBST();
		tree.insert(5);
		System.out.println("Current Node: " + tree.getNodeValue());
		tree.insert(4);
		tree.insert(7);
		System.out.println("Current Node: " + tree.getNodeValue());
		System.out.println("Size: " + tree.size());
	}

}
