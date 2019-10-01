package Exercise1;
/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */

public class MyIntegerBST implements A1Tree {
	private Node root;

	/* Constructor for the BST class */
	public MyIntegerBST() {
		this.root = null;
	}

	/*
	 * The insert method checks if the root is empty and then adds a new node. If
	 * the tree already has a root, it calls the
	 */
	@Override
	public void insert(Integer value) {
		if (root == null) {
			root = new Node(value);

		} else {
			root.add(value, root);
		}
	}

	@Override
	public Integer mostSimilarValue(Integer value) {
		return Compute.mostSimilar(root, value);
	}

	public Integer mostSimilarValue(Node n, Integer value) {
		return Math.abs(n.value - value);
	}

	@Override
	public void printByLevels() {
		int heightOfTree = Compute.computeHeight(root);
		for (int i = 1; i <= heightOfTree; i++) {
			System.out.print("Depth " + (i - 1) + ": ");
			printNodes(root, i);
			System.out.println();
		}

	}

	private void printNodes(Node root, int i) {
		if (root == null) {
			return;
		}
		if (i == 1)
			System.out.print(root.value + " ");
		else if (i >= 0) {
			printNodes(root.right, i - 1);
			printNodes(root.left, i - 1);

		}
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
					left = new Node(n);
				} else {
					left.add(n, node);
				}
			} else if (n > value) {
				if (right == null) {
					right = new Node(n);
				} else {
					right.add(n, node);
				}
			}

		}
	}

	private static class Compute {
		static Integer s0;
		static Integer diff;

		static void minDifference(Node n, Integer i) {
			if (n == null) {
				return;
			}

			if (diff >= Math.abs(n.value - i)) {
				s0 = n.value;
				diff = Math.abs(n.value - i);
			}

			if (i < n.value) {
				minDifference(n.left, i);
			} else {
				minDifference(n.right, i);
			}
		}

		static Integer mostSimilar(Node n, Integer i) {
			diff = Integer.MAX_VALUE;
			minDifference(n, i);
			return s0;
		}

		static int computeHeight(Node node) {
			int calcRight;
			int calcLeft;
			if (node == null) {
				return 0;
			} else {
				calcRight = computeHeight(node.right);
				calcLeft = computeHeight(node.left);

				if (calcLeft >= calcRight) {
					return (calcLeft + 1);
				} else {
					return (calcRight + 1);
				}

			}
		}

	}
}
