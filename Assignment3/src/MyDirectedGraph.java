
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyDirectedGraph implements A3Graph {
	private List<List<Integer>> vertice = new ArrayList<List<Integer>>();
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
			vertice.add(newVertex);
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
//				if (vertice.get(i).connectionList.size() == 0) {
					return false;
//				}
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

}
