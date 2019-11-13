
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyDirectedGraph implements A3Graph {
	private static List<ArrayList<Integer>> adjacency;
	private int numOfVertices;

	MyDirectedGraph(int amountOfVertices) {
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

	}

	@Override
	public boolean isConnected() {
		boolean[] visited = new boolean[numOfVertices];
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < numOfVertices; i++) {
			if (!visited[i] && adjacency.get(i).size() != 0) {
				connectionDFS(i, visited, s);
			}

		}

		System.out.println(s.toString());
		return s.size() == numOfVertices;
	}

	public void connectionDFS(int pos, boolean[] visited, Stack<Integer> s) {
		visited[pos] = true;

		for (int i = 0; i < adjacency.get(pos).size(); i++) {
			if (!visited[pos]) {
				connectionDFS(i, visited, s);
			}

		}
		s.push(pos);

	}

	@Override
	public boolean isAcyclic() {
		Stack stack = new Stack();

		boolean[] visited = new boolean[numOfVertices];
		int n = 0;
		while (n < visited.length) {
			if (!visited[n])
				if (!isAcyclicDFS(n, visited, stack))
					return false;
			n++;
		}

		return true;
	}

	public static boolean isAcyclicDFS(int n, boolean[] isVisited, Stack stack) {
		if (stack.contains(n))
			return false;
		isVisited[n] = true;
		stack.push(n);
		for (int curr : adjacency.get(n)) {
			if (n == curr)
				return false;
			if (isVisited[curr])
				continue;
			if (!isAcyclicDFS(curr, isVisited, stack))
				return false;
		}
		stack.pop();
		return true;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		return null;
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}

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

}
