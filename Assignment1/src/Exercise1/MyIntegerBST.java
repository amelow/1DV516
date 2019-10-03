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
	 * The insert method checks if the root is empty, then adds a new node.
	 * Otherwise it calls the add method from the node class and updates the root
	 * node.
	 */
	@Override
	public void insert(Integer value) {
		if (root == null) {
			root = new Node(value);

		} else {
			root.add(value, root);
		}
	}

	/*
	 * Method for computing the most similar is found in the static class at the end
	 * of the code.
	 */
	@Override
	public Integer mostSimilarValue(Integer value) {
		return Compute.mostSimilar(root, value);
	}

	/*
	 * Method prints the levels of the tree structure. Calls upon the computeHeight
	 * method in the static Compute class. The printByLevels method is inspired by
	 * https://www.geeksforgeeks.org/level-order-tree-traversal/
	 */
	@Override
	public void printByLevels() {
		int depthOfTree = Compute.computeDepth(root);
		for (int i = 0; i < depthOfTree; i++) {
			System.out.print("Depth " + (i) + ": ");
			printNodes(root, i);
			System.out.println();

		}

	}

	/*
	 * Recursive help method, which prints the left and right nodes of the parent
	 * node.
	 * 
	 * 1) Base case: Continue till root is null
	 * 
	 * 2) Print the root value when i is equal to 0.
	 * 
	 * 3) Recursive call: Update root of each subtree. If right or left child is
	 * null, that recursive call quits.
	 */
	private void printNodes(Node root, int i) {
		if (root == null) {
			return;
		}
		if (i == 0) {
			System.out.print(" " + root.value);

		} else if (i >= 0) {
			i--;
			printNodes(root.right, i);
			printNodes(root.left, i);

		}
	}

	/*
	 * Code for this inner class is inspired by the slides in this course (1DV516)
	 * as well as the slides of the Java 2 course 1DV507.
	 */
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

	/*
	 * Inner class for various computations throughout the class.
	 */
	private static class Compute {
		static Integer s0;
		static Integer diff;

		/*
		 * Recursive help method for computing the minimum difference.
		 */
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

		/*
		 * Recursive method that calculates the most similar value. This method calls
		 * the recursive help method minDifference
		 */
		static Integer mostSimilar(Node n, Integer i) {
			diff = Integer.MAX_VALUE;
			minDifference(n, i);
			return s0;
		}

		/*
		 * Recursive method to compute the height of the tree.
		 */
		static int computeDepth(Node node) {
			if (node == null)
				return 0;

			return Math.max(computeDepth(node.left), computeDepth(node.right)) + 1;

		}

	}
}
