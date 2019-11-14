
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyDirectedGraph implements A3Graph {
	private static List<ArrayList<Integer>> adjacency;
	private int numOfVertices;

	/*
	 * Constructor which loops thru the amount of vertices and calls upon the add
	 * function. The vertices will always start from zero.
	 */
	MyDirectedGraph(int amountOfVertices) {
		numOfVertices = amountOfVertices;
		adjacency = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < amountOfVertices; i++) {
			adjacency.add(new ArrayList<Integer>());
		}
	}

	// Getter and Setter functions

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
	 * Adds only a edge from source to target to set an direction
	 */
	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		adjacency.get(sourceVertex).add(targetVertex);

	}

	/*
	 * Checks if the graph is connected by using a Depth first search method called
	 * connectionDFS
	 */
	@Override
	public boolean isConnected() {
		boolean[] visited = new boolean[numOfVertices];
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < numOfVertices; i++) {
			if (!visited[i] && adjacency.get(i).size() != 0) {
				connectionDFS(i, visited, s);
			}

		}
		return s.size() == numOfVertices;
	}

	/*
	 * Recursive help method for traversing thru the graph
	 */
	public void connectionDFS(int pos, boolean[] visited, Stack<Integer> s) {
		visited[pos] = true;

		for (int i = 0; i < adjacency.get(pos).size(); i++) {
			if (!visited[pos]) {
				connectionDFS(i, visited, s);
			}

		}
		s.push(pos);

	}

	/*
	 * Traverses thru the graph by using the isAcyclicDFS() method and returns true
	 * if the graph is acyclic.
	 */
	@Override
	public boolean isAcyclic() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[numOfVertices];
		int n = 0;
		while (n < visited.length) {
			if (!visited[n]) // checks which are set to true(aka visited) or false
				if (!isAcyclicDFS(n, visited, stack)) // recursive help method
					return false;
			n++;
		}

		return true;
	}

	/*
	 * Recursive help method for traversing thru the graph
	 */
	public static boolean isAcyclicDFS(int n, boolean[] isVisited, Stack stack) {
		if (stack.contains(n))
			return false;
		isVisited[n] = true;
		stack.push(n);
		for (int curr : adjacency.get(n)) {
			if (n == curr) // if they get back to the same vertice by taking another way it must be cyclic
				return false;
			if (isVisited[curr])
				continue;
			if (!isAcyclicDFS(curr, isVisited, stack))
				return false;
		}
		stack.pop();
		return true;
	}

	/*
	 * Returns a List of Lists of integers,that returns the nodes in each strongly
	 * connected component of the graph
	 */
	@Override
	public List<List<Integer>> connectedComponents() {
		return null;
	}

}
