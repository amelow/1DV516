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
			size++;
		} else {
			root.add(value, root);

		}
	}

	
	@Override
	public Integer mostSimilarValue(Integer value) {
		if (root.right == null) {
			return root.value;

		} 
		/*
		 * Fix this shit
		 */
		else if (root.left == null) {
			return root.value;

		} else if (Math.abs(value - root.right.value) <= Math.abs(value - root.left.value) && root.right != null
				|| root.left != null) {

			System.out.print("hej");
			root = root.right;
			

			System.out.println("|s0 - value| = " + Math.abs(root.value - value));
			return mostSimilarValue(value);

		} else {
//			System.out.println("hej");
			root = root.left;
			return mostSimilarValue(value);

		}

	}
//	}

	/*
	 * Change printByLevels,printNodes, computeDepth to make it iterative
	 */
	@Override
	public void printByLevels() {
		int depth = computeDepth(root);
		for (int i = 1; i <= depth; i++) {
			System.out.print("Depth " + (i - 1) + ": ");
			printNodes(root, i);
			System.out.print("\n");
		}

	}

	private void printNodes(Node root, int i) {
		if (root == null)
			return;
		if (i == 1)
			System.out.print(root.value + " ");
		else if (i > 1) {
			printNodes(root.left, i - 1);
			printNodes(root.right, i - 1);
		}

	}

	private int computeDepth(Node root) {
		if (root == null)
			return 0;
		else {

			int calcLeft = computeDepth(root.left);
			int calcRight = computeDepth(root.right);

			if (calcLeft > calcRight)
				return (calcLeft + 1);
			else
				return (calcRight + 1);
		}
	}

	public int getSize() {
		return size;
	}

	private class Node {
		Integer value;
		Node left = null;
		Node right = null;

		Node(int v) {
			value = v;
		}

		void add(Integer n, Node node) {

			if (n < value) {
				if (left == null) {
//					size++;
					left = new Node(n);
				} else {
					left.add(n, node);
				}
			} else if (n > value) {
				if (right == null) {
//					size++;
					right = new Node(n);
				} else {
					right.add(n, node);
				}
			}

		}

	}

}
