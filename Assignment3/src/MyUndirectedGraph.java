
import java.util.List;

public class MyUndirectedGraph implements A3Graph {
	private List<Node> verticeList;
	private int numOfNodes = 0;
	private int numOfEdges = 0;

	MyUndirectedGraph() {

	}

	@Override
	public void addVertex(int vertex) {
		Node newV = new Node(vertex);
		verticeList.add(newV);

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
		public List<Integer> edgeList;
		int connected;
		Integer value;

		public Node(int v) {
			this.value = v;
		}
	}
}
