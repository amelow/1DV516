
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyUndirectedGraph implements A3Graph {
	private List<ArrayList<Integer>> adjacency;
	private int numOfVertices;

	/*
	 * Constructor which loops thru the amount of vertices and calls upon the add
	 * function. The vertices will always start from zero.
	 */
	MyUndirectedGraph(int amountOfVertices) {
		numOfVertices = amountOfVertices;
		adjacency = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < amountOfVertices; i++) {
			adjacency.add(new ArrayList<Integer>());
		}
	}

	// Getter and setter functions
	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public List<ArrayList<Integer>> getAdjacency() {
		return adjacency;
	}

	@Override
	public void addVertex(int vertex) {
		adjacency.add(new ArrayList<Integer>());
		numOfVertices++;

	}

	/*
	 * Adds edges from source to target vertex and from target to source vertex so
	 * simulate an undirected graph
	 */
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
        return connectedComponents().size() == 1;
    }
	/*
	 * The depth first search algorithm is built of pseudo code found in this video:
	 * https://www.youtube.com/watch?v=7fujbpJ0LB4&fbclid=
	 * IwAR3MMPIKkuYTyCc7Cx3GZDnKXO4mfZrnhpsUs7Pice_Dh6oKiOeKkK6D58o
	 */
	public Integer[] connectionDFS(int vertexIndex, boolean[] isVisited) {
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
		boolean[] isVisited = new boolean[numOfVertices];
		int n = 0;
		while (n < isVisited.length) {
			if (!isVisited[n])
				if (!isAcyclicDFS(-1, n, isVisited))
					return false;
			n++;
		}

		return true;
	}

	/*
	 * Recursuve helper method for the is acyclic method, used to traverse thru the
	 * graph
	 */
	public boolean isAcyclicDFS(int from, int to, boolean[] isVisited) {
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
	 * The EulerPath method was based on the algorithmic explanations on the
	 * following website: https://cp-algorithms.com/graph/euler_path.html?fbclid=
	 * IwAR3caGQ1fDliAFfzlru3lOLCtjbJMu8bE63pOzxKV3VuSxSt2dz3bJQyGFI/ Instead of
	 * copying the graph and then to do the deletions of the edges, a set i used to
	 * store the deleted edges to avoid ruining the original graph.
	 */
	@Override
	public List<Integer> eulerPath() {
		if (!hasEulerPath())
			return null;

		List<Integer> eulerPath = new ArrayList<Integer>();
		int start = 0;
		for (int i = 0; i < adjacency.size(); i++) {
			if (adjacency.get(i).size() % 2 == 1) { // starts at a vertice with odd degrees if there is one
				start = i;
			}
		}
		findEuler(start, eulerPath, new HashMap<Integer, Set<Integer>>());
		return eulerPath;
	}

	private void findEuler(int start, List<Integer> eulerPath, Map<Integer, Set<Integer>> deleted) {
		for (int n : adjacency.get(start)) {
			if (isDeleted(start, n, deleted))
				continue;
			deleteTarget(start, n, deleted);
			findEuler(n, eulerPath, deleted);
		}
		eulerPath.add(start);
	}

	// Method to check if a path from StartNode to TargetNode already is deleted
	private boolean isDeleted(int fromNode, int toNode, Map<Integer, Set<Integer>> deleted) {
		Set<Integer> targets = getDeletedTargets(fromNode, deleted);
		return targets.contains(toNode);
	}

	// Returns deleted targets
	private Set<Integer> getDeletedTargets(int testVertex, Map<Integer, Set<Integer>> deleted) {
		if (!deleted.containsKey(testVertex)) {
			deleted.put(testVertex, new HashSet<Integer>());
		}
		return deleted.get(testVertex);
	}

	// Method to "delete"(add) a path
	private void deleteTarget(int fromNode, int toNode, Map<Integer, Set<Integer>> deleted) {
		if (!deleted.containsKey(fromNode)) {
			deleted.put(fromNode, new HashSet<Integer>());
		}
		deleted.get(fromNode).add(toNode);
		if (!deleted.containsKey(toNode)) {
			deleted.put(toNode, new HashSet<Integer>());
		}
		deleted.get(toNode).add(fromNode);
	}

	/*
	 * Returns a List of Lists of integers, that returns the nodes in each connected
	 * component of the graph. This solution is inspired by:
	 * geeksforgeeks.org/connected-components-in-an-undirected-graph/?fbclid=
	 * IwAR16OZfIxHjg3Y-mfTSCp7HUbZtemAaG3yqO4Tcgsl4yOAb1fhRfPopAPYA
	 */
	@Override
	public List<List<Integer>> connectedComponents() {
		boolean[] visited = new boolean[numOfVertices];
		List<List<Integer>> connections = new ArrayList<List<Integer>>();
		List<Integer> components = new ArrayList<Integer>();
		for (int i = 0; i < numOfVertices; i++) {
			if (!visited[i] && adjacency.get(i).size() > 0) {
				componentsDFS(i, visited);

			}
			if (adjacency.get(i).size() == 0) {
				List<Integer> alone = new ArrayList<Integer>();
				alone.add(i);
				connections.add(alone);
			} else {
				components.add(i);
			}

		}
		connections.add(components);
		return connections;
	}

	// Recursive helper method for traversing the graph used by the
	// connectedComponents() method
	public void componentsDFS(int vertexIndex, boolean[] isVisited) {
		isVisited[vertexIndex] = true;

		for (int i = 0; i < adjacency.get(i).size(); i++) {
			if (!isVisited[i]) {
				componentsDFS(i, isVisited);

			}

		}
	}
}