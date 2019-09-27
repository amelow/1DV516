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
		if (root == null) {
			root = new Node(value);

		} else {
			root.add(value, root);

		}
	}

	public Integer getValue() {
		return root.value;
	}

	@Override
	public Integer mostSimilarValue(Integer value) {

		return null;
	}
	

	@Override
	public void printByLevels() {
		int d = size;
		for (int i = 1; i <= d; i++) {
			System.out.println("Depth " + (i - 1) + ":");
			printingLeafs(root, d);

		}

	}

	/*
	 * int d = 0; int m; for (int i = 1; i < size; i++) { if (i % m == 0) { d++; }
	 * else { System.out.println(m); } }
	 */

	private void printingLeafs(Node root, int level) {

	}

	public int size() {
		return size;
	}

	private class Node {
		Integer value;
		Node left = null;
		Node right = null;

		Node(int v) {
			value = v;
		}

		Node add(Integer n, Node node) {

//			Node current = root;
			int comp = n - value;
//			if (comp == 0) {
//				return null;
//			}
			if (node == null) {
				size++;
				return new Node(n);
			}
			if (comp < 0) {
				node = add(n, node.left);

			} else if (comp > 0) {
				node = add(n, node.right);
			} else {
				return null;
			}

			value = n;

			return null;
		}

	}

}
