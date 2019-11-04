
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyUndirectedGraph implements A3Graph {
	private ArrayList<Node> verticeList = new ArrayList<>();
	private int numOfNodes = 0;
	private int numOfEdges = 0;

	MyUndirectedGraph(int amountOfVertices) {
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
		numOfNodes++;
	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {

		verticeList.get(sourceVertex).connectionList.add(verticeList.get(targetVertex));
		verticeList.get(targetVertex).connectionList.add(verticeList.get(sourceVertex));
		System.out.println("Source: " + sourceVertex);
		System.out.println("Target: " + targetVertex);
		numOfEdges++;
	}

	public void removeEdge(int sourceVertex, int targetVertex) {
		System.out.println("----------------");

		verticeList.get(sourceVertex).connectionList.remove(verticeList.get(targetVertex));
		verticeList.get(targetVertex).connectionList.remove(verticeList.get(sourceVertex));
		System.out.println("Source: " + sourceVertex);
		System.out.println("Target: " + targetVertex);

		numOfEdges--;
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
		for (int i = 0; i < verticeList.size() - 1; i++) {
			Node current = verticeList.get(i);
			Node nextOfStart = verticeList.get(i - (i - 1));
			for (int j = 0; j < current.connectionList.size(); j++) {
			}

		}
		return false;

	}

	@Override
	public List<List<Integer>> connectedComponents() {

		return null;
	}

	/*
	 * The solution is based on the definition of the Eulers path: "A graph has an
	 * Euler path if and only if there are at most two vertices with odd degree."
	 * found on the webpage: http://discrete.openmathbooks.org/dmoi2/sec_paths.html
	 */
	@Override
	public boolean hasEulerPath() {
		int amountOfOddVertices = 0;
		boolean result = false;
		if (!isConnected()) {
			return result;
		}
		for (int i = 0; i < verticeList.size(); i++) {
			if (verticeList.get(i).connectionList.size() % 2 == 1) {
				amountOfOddVertices++;
			}
			if (amountOfOddVertices <= 2) {
				result = true;
				return result;
			}
		}
		result = false;
		return result;

	}

	@Override
	public List<Integer> eulerPath() {

		return A3Graph.super.eulerPath();
	}

	public static class Node {
		ArrayList<Node> connectionList = new ArrayList<>();

		int connected;
		Integer value;

		public Node(int v) {
			this.value = v;

		}

	}
}
