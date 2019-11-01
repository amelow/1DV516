
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyUndirectedGraph implements A3Graph {
	public ArrayList<Node> verticeList;
	private int numOfNodes = 0;
	private int numOfEdges = 0;

	MyUndirectedGraph(int size) {
		for (int i = 1; i <= size; i++)
			addVertex(i);
	}

	@Override
	public void addVertex(int vertex) {
//		Node newV = new Node(vertex);
//		 verticeList.add(newV);
		verticeList.add(new Node(vertex));

		System.out.println("VerticeList: " + verticeList.size());
		numOfNodes++;

	}

	public int getAmountOfNodes() {
		return numOfNodes;
	}

	public int getAmountOfEdges() {

		return numOfEdges;
	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		System.out.println("Edge between vertex " + sourceVertex + " and vertex " + targetVertex);
		/*
		 * for (Node node : verticeList) { if (sourceVertex == node.value) {
		 * 
		 * }
		 * 
		 * }
		 */
		numOfEdges++;
	}

	@Override
	public boolean isConnected() {
		boolean isConnected = false;

		return false;
	}

	@Override
	public boolean isAcyclic() {

		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {

		return null;
	}

	@Override
	public boolean hasEulerPath() {

		return A3Graph.super.hasEulerPath();
	}

	@Override
	public List<Integer> eulerPath() {

		return A3Graph.super.eulerPath();
	}

	private class Node {
		public List<Integer> edgeList = new ArrayList<Integer>();
		int connected;
		Integer value;

		public Node(int v) {
			this.value = v;
		}
	}
}
