
public class GraphTest {

	public static void main(String[] args) {
//		TestUndirectedGraph();
//		TestDirectedGraph();
		TestSocialNetwork();
	}

	private static void TestUndirectedGraph() {
		System.out.println("\n" + "---------- UNDIRECTEDGRAPH ----------" + "\n");
		MyUndirectedGraph undirectedGraph = new MyUndirectedGraph(5);

		// Adding edges between the vertices in the graph
		undirectedGraph.addEdge(0, 1);
		undirectedGraph.addEdge(0, 3);
		undirectedGraph.addEdge(1, 2);
//		undirectedGraph.addEdge(2, 3);
		// undirectedGraph.addEdge(3, 4);
		undirectedGraph.addEdge(1, 4);
//		undirectedGraph.addEdge(2, 4);

		// Checking if the undirected graph is acyclic
		System.out.println("Is Acyclic: " + undirectedGraph.isAcyclic());

		// Checking if the undirected graph is connected
		System.out.println("Is Connected: " + undirectedGraph.isConnected());

		// Checking if the undirected graph has a Euler path
		System.out.println("Has a Euler path: " + undirectedGraph.hasEulerPath());

		// Returning the Euler path
		System.out.println("Euler path list: " + undirectedGraph.eulerPath());

		// The connected Components list
		System.out.println("Connected Components: " + undirectedGraph.connectedComponents());
	}

	private static void TestDirectedGraph() {
		System.out.println("\n" + "---------- DIRECTEDGRAPH ----------" + "\n");
		MyDirectedGraph directedGraph = new MyDirectedGraph(5);

		// Adding edges between the vertices in the graph
		directedGraph.addEdge(0, 1);
		directedGraph.addEdge(0, 3);
		directedGraph.addEdge(1, 2);
		directedGraph.addEdge(2, 3);

		// Checking if the directed graph is acyclic
		System.out.println("Is Acyclic: " + directedGraph.isAcyclic());

		// Checking if the directed graph is connected
		System.out.println("Is Connected: " + directedGraph.isConnected());

		// The connected Components list
		System.out.println("Connected Components: " + directedGraph.connectedComponents());
	}

	private static void TestSocialNetwork() {
		System.out.println("\n" + "---------- MYSOCIALNETWORK ----------" + "\n");
		MySocialNetwork network = new MySocialNetwork(5);
		network.addEdge(0, 1);
		network.addEdge(1, 2);
		network.addEdge(0, 3);
		network.addEdge(2, 3);
		network.addEdge(4, 3);

		System.out.println("Number Of People: " + network.numberOfPeopleAtFriendshipDistance(0, 2));
		System.out.println("Furthest Distance : " + network.furthestDistanceInFriendshipRelationships(1));

	}
}
