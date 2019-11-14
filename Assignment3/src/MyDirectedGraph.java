
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
	public void connectionDFS(int pos, boolean[] isVisited, Stack<Integer> s) {
		isVisited[pos] = true;
		
		for (int i = 0; i < adjacency.get(pos).size(); i++) {
			if (!isVisited[pos]) {
				connectionDFS(i, isVisited, s);
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
		boolean[] isVisited = new boolean[numOfVertices];
		int n = 0;
		
		while (n < isVisited.length) {
			if (!isVisited[n]) // checks which are set to true(aka visited) or false
				if (!isAcyclicDFS(n, isVisited, stack)) // recursive help method
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
	 * Returns a List of Lists of integers (List<List<Integer>>
	 * connectedComponents()) that returns the nodes in each connected component of
	 * the graph
	 * 
	 */
	@Override
	public List<List<Integer>> connectedComponents() {
		
		boolean[] isVisited = new boolean[numOfVertices];
		List<Integer> list = componentsDFS(numOfVertices, isVisited);
		List<List<Integer>> connections = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < numOfVertices; i++) {
			if (!isVisited[i]) {
				connectionDFS(i, isVisited, list);
			}
		}
		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			if (!isVisited[n]) {
				List<Integer> temp = new ArrayList<Integer>();
				connectionDFS(n, isVisited, temp);
				connections.add(temp);
			}

		}
		return connections;

	}

	public List<Integer> componentsDFS(int vertexIndex, boolean[] isVisited) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < adjacency.get(vertexIndex).size(); i++) {
			int temp = adjacency.get(vertexIndex).get(i);
			if (!isVisited[temp]) {
				connectionDFS(temp, isVisited, list);

			}

		}

		return list;
	}

	public void connectionDFS(int pos, boolean[] isVisited, List<Integer> list) {
		isVisited[pos] = true;
		
		for (int i = 0; i < adjacency.get(pos).size(); i++) {
			if (!isVisited[pos]) {
				connectionDFS(i, isVisited, list);
			}

		}

		list.add(pos);

	}
}
