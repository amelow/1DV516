
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
		return true;
	}

//		for (int i = 0; i < adjacency.size(); i++) {
//			int count = 0;
//			for (int j = 0; j < adjacency.get(i).size(); j++) {
//				if (adjacency.get(i).get(j) == 0) {
//					count++;
//				}
//			}
//			if (count == numOfVertices) {
//				return false;
//			}
//		}
//
//		return true;
//	}

	@Override
	public boolean isAcyclic() {
		return false;
	}
//		boolean[] visited = new boolean[numOfVertices];
//		int parent = 0;
//		// boolean acyclic = false;
//
//		for (int i = 0; i < adjacency.size(); i++) { // vertices
//			parent = i;
//			visited[i] = true;
//			for (int j = 0; j < adjacency.size(); j++) { // connections
//				if (adjacency.get(i).get(j) == 1) { // if they have a connection
//					visited[j] = true;
//
////					for (int k = 0; k < vertices.size(); k++) {
////						parent = j;
////						System.out.println(" Visited: " + Arrays.toString(visited));
////						// if(visited[k] == true && k != parent) {
////						if (vertices.get(j).get(k) == 1 && k != parent && visited[k] == true) {
////							
////							return false;
////
////						}
////					}
////					vertices.get(j);
////					System.out.println(" Visited: " + Arrays.toString(visited));
//				}
//			}
//			System.out.println(" Visited: " + Arrays.toString(visited));
//		}
//
//		return true;
//
//	}

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
			for (int j = 0; j < adjacency.get(i).size(); j++) {
				if (adjacency.get(i).get(j) == 1) {
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

	static class Search {

		public static Integer[] socialDFS(int vertexIndex, boolean[] isVisited, int depth) {
			isVisited[vertexIndex] = true;
			Integer[] arr = new Integer[adjacency.get(vertexIndex).size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = adjacency.get(vertexIndex).get(i);
			}
			System.out.println(Arrays.toString(arr));
			// System.out.println(Arrays.toString(isVisited));
			for (int curr : adjacency.get(vertexIndex)) {
				if (!isVisited[curr])
					socialDFS(curr, isVisited, depth++);
			}

			return arr;
		}

		public static Integer[] connectionDFS(int vertexIndex, boolean[] isVisited, int depth) {
			isVisited[vertexIndex] = true;
			Integer[] arr = new Integer[adjacency.get(vertexIndex).size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = adjacency.get(vertexIndex).get(i);
			}
			// System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(isVisited));
			for (int curr : adjacency.get(vertexIndex)) {
				if (!isVisited[curr])
					arr = connectionDFS(curr, isVisited, depth + 1);
			}

			return arr;
		}

	}
}
