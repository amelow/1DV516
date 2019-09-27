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
			
			root = new Node(value, null, null);

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

	}

	public int size() {
		return size;
	}

	private class Node {
		int value;
		Node left;
		Node right;

		Node(int v, Node l, Node r) {
			value = v;
			left = l;
			right = r;
		}

		Node add(Integer n, Node current) {
			int comp = n - value;

			if (current == null) {
				size++;
				return new Node(n, null, null);
			}

			if (comp == 0) {
				return null;
			} else if (comp < 0) {
				current.left = add(n, current.left);

			} else if (comp > 0) {
				current.right = add(n, current.right);

			}
			
			current.value = n;
			return current;
		}

	}

}
