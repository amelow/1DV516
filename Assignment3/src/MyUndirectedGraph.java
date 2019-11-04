
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

	public int getAmountOfNodes() {
		return numOfNodes;
	}

	public int getAmountOfEdges() {

		return numOfEdges;
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
		boolean isConnected = false;

		return isConnected;
	}

	@Override
	public boolean isAcyclic() {
		boolean isVisited = false;
		if (numOfEdges == 0) {
			return false;
		} else if (numOfNodes == 0) {
			return true;
		}

		for (int i = 0; i < verticeList.size(); i++) {
			if (verticeList.get(i).connectionList.size() < 2) {
				continue;
			}
			for (int j = 0; j < verticeList.get(i).connectionList.size(); j++) {
				removeEdge(verticeList.get(i).connected, verticeList.get(i).connectionList.get(j).connected);

			}

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
		ArrayList<Node> connectionList = new ArrayList<>();

		int connected;
		Integer value;

		public Node(int v) {
			this.value = v;

		}

	}
}
