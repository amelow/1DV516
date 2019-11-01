
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyUndirectedGraph implements A3Graph {
	ArrayList<Node> verticeList = new ArrayList<Node>();

	MyUndirectedGraph() {

	}

	@Override
	public void addVertex(int vertex) {

	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {

	}

	@Override
	public boolean isConnected() {

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
		Integer value;
		private LinkedList<Integer> nodeList = new LinkedList<>();

		public Node(int v) {
			this.value = v;
		}

	}
}
