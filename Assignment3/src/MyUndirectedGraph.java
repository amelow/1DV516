
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
	 *
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

	@Override
	public boolean isAcyclic() {
		Integer[] arr = new Integer[numOfVertices];
		boolean[] checked = new boolean[numOfVertices];
		int parent = 0;
		for (int i = 1; i < numOfVertices; i++) {
			if (checked[i] == false) {
				arr = connectionDFS(i, checked);
				if (arr[i]!= arr[parent])
					return true;
			}
			parent = i;
		}

		return false;

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

//	@Override
//	public boolean hasEulerPath() {
//		int amountOfOddVertices = 0;
//		if (!isConnected()) {
//			return false;
//		}
//		for (int i = 0; i < adjacency.size(); i++) {
//			int connections = 0;
//			for (int j = 0; j < adjacency.get(i).size(); j++) {
//				if (adjacency.get(i).get(j) == 1) {
//					connections++;
//				}
//			}
//			if (connections % 2 == 1) {
//				amountOfOddVertices++;
//			}
//			if (amountOfOddVertices <= 2) {
//				return true;
//			}
//		}
//
//		return false;
//	}

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

//		public static Integer[] socialDFS(int vertexIndex, int depth, Integer[] arr, boolean[] checked) {
//			checkDepth(vertexIndex, arr, depth);
//			checked[vertexIndex] = true;
//			for (int i = 0; i < adjacency.get(vertexIndex).size(); i++) {
//				int curr = adjacency.get(vertexIndex).get(i);
//				if (!checked[curr]) {
//					depth = depth + 1;
//					arr = socialDFS(curr, depth, arr, checked);
//				} else if (arr[curr] > depth + 1) {
//					depth = depth + 1;
//					arr = socialDFS(curr, depth, arr, checked);
//				}
//			}
//			return arr;
//		}
//
//		private static void checkDepth(int vertexIndex, Integer[] arr, int depth) {
//			if (arr[vertexIndex] != null) {
//				arr[vertexIndex] = depth;
//			} else {
//				arr[vertexIndex] = depth;
//			}
//
//		}

//		public static Integer[] socialDFS(int vertexIndex, boolean[] isVisited, int depth) {
//			isVisited[vertexIndex] = true;
//			Integer[] arr = new Integer[adjacency.get(vertexIndex).size()];
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = adjacency.get(vertexIndex).get(i);
//			}
//			System.out.println(Arrays.toString(arr));
//			// System.out.println(Arrays.toString(isVisited));
//			for (int curr : adjacency.get(vertexIndex)) {
//				if (!isVisited[curr])
//					socialDFS(curr, isVisited, depth++);
//			}
//
//			return arr;
//		}

}
