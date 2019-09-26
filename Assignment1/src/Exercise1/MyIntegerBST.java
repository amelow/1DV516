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
			root.add(value);
		}
		size++;
	}

	public int getNodeValue() {
		return root.value;
	}

	@Override
	public Integer mostSimilarValue(Integer value) {

		return null;
	}

	@Override
	public void printByLevels() {

	}

	public int size() {
		return size;
	}

	private class Node {
		int value;
		Node left;
		Node right;

		Node(int v) {
			value = v;
			left = null;
			right = null;
		}

		void add(Integer n) {
			int comp = value - root.value;

			if (comp == 0) {
				return;
			}
			if (comp < 0) {
				if (left == null) {
					left = new Node(n);
				} else {
					left.add(n);
				}
			} else if (comp > 0) {
				if (right == null) {
					right = new Node(n);
				} else {
					right.add(n);
				}

			}

			size++;

		}

	}

}
