import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyDirectedGraph implements A3Graph {
	private List<List<Integer>> adjacency;
	private int numOfVertices;

	MyDirectedGraph(int amountOfVertices) {
		numOfVertices = amountOfVertices;
		adjacency = new ArrayList<List<Integer>>();

		for (int i = 0; i < amountOfVertices; i++) {
			adjacency.add(new LinkedList<Integer>());
		}
	}

	public List<List<Integer>> getAdjacency() {
		return adjacency;
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}

	@Override
	public void addVertex(int vertex) {
		adjacency.add(new LinkedList<Integer>());
		numOfVertices++;

	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		adjacency.get(sourceVertex).add(targetVertex);

	}

	@Override
	public boolean isConnected() {
		List<List<Integer>> Components = connectedComponents();

		/*
		 * boolean[] visited = new boolean[numOfVertices]; List<Integer> s = new
		 * ArrayList<Integer>();
		 * 
		 * for (int i = 0; i < numOfVertices; i++) { if (!visited[i] &&
		 * adjacency.get(i).size() != 0) { connectionDFS(i, visited, s); }
		 * 
		 * }
		 * 
		 * return s.size() == numOfVertices;
		 */

		return (Components.size() == 1);
	}

	@Override
	public boolean isAcyclic() {
		Stack<Integer> stack = new Stack<Integer>();
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

	public boolean isAcyclicDFS(int n, boolean[] isVisited, Stack<Integer> stack) {
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
		// Step 1 add all nodes to stack in first DFS
		boolean[] isVisited = new boolean[numOfVertices];
		List<Integer> stack = new ArrayList<Integer>();
		for (int i = 0; i < numOfVertices; i++) {
			if (!isVisited[i]) {
				sccDFS(i, isVisited, stack, adjacency);
			}
		}
		Collections.reverse(stack);

		// Step 2 reverse edges
		MyDirectedGraph reversedGraph = reverseGraph();

		// Step 3 pop nodes and add SCC for nodes in second DFS
		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = false;
		}
		List<List<Integer>> connectedComponents = new ArrayList<List<Integer>>();
		for (int i = 0; i < stack.size(); i++) {
			int n = stack.get(i);
			if (!isVisited[n]) {
				List<Integer> temp = new ArrayList<Integer>();
				sccDFS(n, isVisited, temp, reversedGraph.adjacency);
				connectedComponents.add(temp);
			}
		}
		return connectedComponents;
	}

	public void sccDFS(int pos, boolean[] isVisited, List<Integer> list, List<List<Integer>> adjL) {
		isVisited[pos] = true;
		List<Integer> targets = adjL.get(pos);
		for (int i = 0; i < targets.size(); i++) {
			if (!isVisited[targets.get(i)]) {
				sccDFS(targets.get(i), isVisited, list, adjL);
			}
		}
		list.add(pos);
	}

	public MyDirectedGraph reverseGraph() {
		MyDirectedGraph reversedGraph = new MyDirectedGraph(numOfVertices);
		for (int n = 0; n < numOfVertices; n++) {
			for (int target : adjacency.get(n)) {
				reversedGraph.addEdge(target, n);
			}
		}
		return reversedGraph;
	}

}