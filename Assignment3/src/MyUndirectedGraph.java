
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyUndirectedGraph implements A3Graph {
	private static List<ArrayList<Integer>> adjacency;
	private int numOfVertices;

	MyUndirectedGraph(int amountOfVertices) {
		numOfVertices = amountOfVertices;
		adjacency = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < amountOfVertices; i++) {
			adjacency.add(new ArrayList<Integer>());
		}
	}

	public List<ArrayList<Integer>> getAdjacency() {
		return adjacency;
	}

	@Override
	public void addVertex(int vertex) {
		adjacency.add(new ArrayList<Integer>());
		numOfVertices++;

	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		adjacency.get(sourceVertex).add(targetVertex);
		adjacency.get(targetVertex).add(sourceVertex);
	}

	/*
	 * Check whether or not there is a vertex with no edges connected.
	 */
	@Override
	public boolean isConnected() {
		boolean[] isVisited = new boolean[numOfVertices];
		connectionDFS(0, isVisited);

		for (int i = 0; i < numOfVertices; i++) {
			if (!isVisited[i]) {
				return false;
			}

		}

		return true;
	}

	/*
	 * The depth first search algorithm is built of pseudo code found in this video:
	 * https://www.youtube.com/watch?v=7fujbpJ0LB4&fbclid=
	 * IwAR3MMPIKkuYTyCc7Cx3GZDnKXO4mfZrnhpsUs7Pice_Dh6oKiOeKkK6D58o
	 */
	public static Integer[] connectionDFS(int vertexIndex, boolean[] isVisited) {
		isVisited[vertexIndex] = true;
		Integer[] arr = new Integer[adjacency.get(vertexIndex).size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = adjacency.get(vertexIndex).get(i);
		}
		for (int curr : adjacency.get(vertexIndex)) {
			if (!isVisited[curr])
				arr = connectionDFS(curr, isVisited);
		}

		return arr;
	}

	/*
	 * If an unexplored edge leads to a node visited before, then the graph contains
	 * a cycle. The existence of a cycle in directed and undirected graphs can be
	 * determined by whether depth-first search (DFS) finds an edge that points to
	 * an ancestor of the current vertex (it contains a back edge).[4]All the back
	 * edges which DFS skips over are part of cycles.[5] In an undirected graph, the
	 * edge to the parent of a node should not be counted as a back edge, but
	 * finding any other already visited vertex will indicate a back edge.
	 */

	@Override
	public boolean isAcyclic() {
		boolean[] visited = new boolean[numOfVertices];

		int n = 0;
		while (n < visited.length) {
			if (!visited[n])
				if (!isAcyclicDFS(-1, n, visited))
					return false;
			n++;
		}

		return true;
	}

	public static boolean isAcyclicDFS(int from, int to, boolean[] isVisited) {
		if (isVisited[to])
			return false;
		isVisited[to] = true;

		for (int curr : adjacency.get(to)) {
			if (from == curr)
				continue;
			if (!isAcyclicDFS(to, curr, isVisited))
				return false;
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
		return null;
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
		for (int i = 0; i < adjacency.size(); i++) {
			int connections = 0;
			if (!isConnected()) {
				return false;
			}
			if (adjacency.get(i).size() % 2 == 1) {
				amountOfOddVertices++;
			}
		}
		if (amountOfOddVertices <= 2) {
			return true;
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