
public class GraphTest {

	public static void main(String[] args) {
		TestUndirected();
		TestDirected();

	}

	// New Undirected Graph
	private static void TestUndirected() {
		MyUndirectedGraph undirectedGraph = new MyUndirectedGraph(5);

		// Adding edges between the vertices in the graph
		System.out.println("Edges in graph:");
		undirectedGraph.addEdge(0, 1);
		undirectedGraph.addEdge(0, 3);
		undirectedGraph.addEdge(1, 2);
		undirectedGraph.addEdge(2, 3);
//		undirectedGraph.addEdge(3, 4);

		// Checking if the undirected graph is acyclic
		System.out.println("Is Acyclic: " + undirectedGraph.isAcyclic());

		// Checking if the undirected graph is connected
		System.out.println("Is Connected: " + undirectedGraph.isConnected());

		// Checking if the undirected graph has a Eulerspath
		System.out.println("Has a Euler path: " + undirectedGraph.hasEulerPath());
	}

	// New directed Graph
	private static void TestDirected() {
		MyDirectedGraph directedGraph = new MyDirectedGraph(5);
		// Adding edges between the vertices in the graph
		directedGraph.addEdge(0, 1);
		directedGraph.addEdge(0, 3);
		directedGraph.addEdge(1, 2);
		directedGraph.addEdge(2, 3);
		// Checking if the directed graph is acyclic
		directedGraph.isAcyclic();
	}

}
