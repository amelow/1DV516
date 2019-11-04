
import java.util.ArrayList;
import java.util.List;

public class MyDirectedGraph implements A3Graph {
	private ArrayList<Node> verticeList = new ArrayList<>();
	private int numOfNodes = 0;
	private int numOfEdges = 0;

	public MyDirectedGraph(int amountOfVertices) {
		for (int vertex = 0; vertex < amountOfVertices; vertex++) {
			addVertex(vertex);
		}
	}

	@Override
	public void addVertex(int vertex) {
		Node newVertex = new Node(vertex);
		if (newVertex != null) {
			verticeList.add(newVertex);
		}
	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {

	}

	@Override
	public boolean isConnected() {
		if (numOfEdges == 0 || numOfNodes == 0) {
			return false;
		} else {
			for (int i = 0; i < numOfNodes; i++) {
				if (verticeList.get(i).connectionList.size() == 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isAcyclic() {

		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		return null;
	}

	public static class Node {
		ArrayList<Node> inList = new ArrayList<>();
		ArrayList<Node> outList = new ArrayList<>();
		ArrayList<Node> connectionList = new ArrayList<>();

		int connected;
		Integer value;

		public Node(int v) {
			this.value = v;

		}

	}

}
