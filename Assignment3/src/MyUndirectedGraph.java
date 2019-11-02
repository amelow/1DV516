
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyUndirectedGraph implements A3Graph {
	private ArrayList<Node> verticeList = new ArrayList<>();
//	private List<Node> verticeList;
	private int numOfNodes = 0;
	private int numOfEdges = 0;

	MyUndirectedGraph(int size) {
		for (int vertex = 0; vertex <= size; vertex++) {
			addVertex(vertex);
		}

	}

	@Override
	public void addVertex(int vertex) {
		Node newVertex = new Node(vertex);
		if (newVertex != null) {
			verticeList.add(newVertex);
		}

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
		for (Node n : verticeList) {
			int i = n.value;
			if (i == sourceVertex) {
				List<Integer> inList = new ArrayList<Integer>();
				inList.add(targetVertex);
			} else if (i == targetVertex) {
				List<Integer> outList = new ArrayList<Integer>();

			}
		}
		/*
		 * for (int i = 0; i < verticeList.size(); i++) { if (i == sourceVertex) {
		 * 
		 * } else if (i == targetVertex) { // newConnection(sourceVertex);
		 * 
		 */

		numOfEdges++;
	}

	@Override
	public boolean isConnected() {
		boolean isConnected = false;

		return false;
	}

//An acyclic graph is a graph with no cycles.
	@Override
	public boolean isAcyclic() {
		/*
		 * PsudoCode 1: If graph !contain nodes== acyclic 2: if graph !contain leafs
		 * ==cyclic
		 * 
		 * 
		 */
		if (numOfEdges == 0) {
			return false;
		}
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

	public static class Node {
		public List<Integer> inList = new ArrayList<Integer>();
		public List<Integer> outList = new ArrayList<Integer>();
		int connected;
		Integer value;

		public Node(int v) {
			this.value = v;
		}

		void newConnection(int connection) {
			if (inList.contains(connection)) {
				System.out.println("already exists");

			} else {
				inList.add(connection);
			}

		}
	}
}
