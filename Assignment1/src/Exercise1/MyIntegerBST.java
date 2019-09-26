package Exercise1;

public class MyIntegerBST implements A1Tree {

	private Node root;
	private int size;

	public MyIntegerBST() {
		this.size = 0;
		this.root = null;
		
	}

	@Override
	public void insert(Integer value) {

	}

	@Override
	public Integer mostSimilarValue(Integer value) {

		return null;
	}

	@Override
	public void printByLevels() {

	}

	private class Node {
		private int value;
		private int size;
		private Node left;
		private Node right;
	}

}
