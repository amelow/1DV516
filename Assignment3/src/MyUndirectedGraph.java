
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyUndirectedGraph implements A3Graph {
	List<List<Integer>> vertices = new ArrayList<List<Integer>>();
	private int numOfVertices;

	MyUndirectedGraph(int amountOfVertices) {
		setNumOfVertices(amountOfVertices);

		for (int i = 0; i < amountOfVertices; i++) {
			ArrayList<Integer> v = new ArrayList<Integer>();
			for (int j = 0; j < amountOfVertices; j++) {
				v.add(0);
			}
			vertices.add(v);
		}

	}

	@Override
	public void addVertex(int vertex) {
		for (int i = 0; i < numOfVertices; i++) {
			vertices.get(i).add(0);
		}

		ArrayList<Integer> v = new ArrayList<Integer>();

		numOfVertices++;

		for (int i = 0; i < numOfVertices; i++) {
			v.add(0);
		}
		vertices.add(v);

	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		vertices.get(sourceVertex).set(targetVertex, 1);
		vertices.get(targetVertex).set(sourceVertex, 1);
	}

	/*
	 * Check whether or not there is a vertex with no edges connected.
	 */
	@Override
	public boolean isConnected() {

		for (int i = 0; i < vertices.size(); i++) {
			int count = 0;
			for (int j = 0; j < vertices.get(i).size(); j++) {
				if (vertices.get(i).get(j) == 0) {
					count++;
				}
			}
			if (count == numOfVertices) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isAcyclic() {

		boolean[] visited = new boolean[numOfVertices];
		int prev = 0;

		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				// prev =
				if (vertices.get(i).get(j) == 1) {

				}
			}
		}
		return true;

	}

	/*
	 * Each component is represented by a list. For component 0, the first element
	 * is always 0, since an element cannot be connected to itself. If an element is
	 * connected to another, then the value is set to be 1.
	 */
	@Override
	public List<List<Integer>> connectedComponents() {
		return vertices;
	}

	/*
	 * The solution is based on the definition of the Eulers path: "A graph has an
	 * Euler path if and only if there are at most two vertices with odd degree."
	 * found on the web-page: http://discrete.openmathbooks.org/dmoi2/sec_paths.html
	 */
	@Override
	public boolean hasEulerPath() {
		int amountOfOddVertices = 0;

		if (!isConnected()) {
			return false;
		}
		for (int i = 0; i < vertices.size(); i++) {
			int connections = 0;
			for (int j = 0; j < vertices.get(i).size(); j++) {
				if (vertices.get(i).get(j) == 1) {
					connections++;
				}
			}
			if (connections % 2 == 1) {
				amountOfOddVertices++;
			}
			if (amountOfOddVertices <= 2) {
				return true;
			}
		}

		return false;
	}

	/*
	 * Returns a list of vertices of length |E|+1. The vertices in the list
	 * represent how to traverse the graph to complete an Euler path.
	 */
	@Override
	public List<Integer> eulerPath() {
		List<Integer> eulerPath = new ArrayList<Integer>();
		boolean[] visited = new boolean[numOfVertices];

		if (!hasEulerPath()) {
			return null;
		} else {

		}

		return null;
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}

}
