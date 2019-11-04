
public class UndirectedGraphTest {

	public static void main(String[] args) {
		Test();

	}

	private static void Test() {
		// New Undirected Graph with 4 nodes
		MyUndirectedGraph graph = new MyUndirectedGraph(5);
		System.out.println("Amount of Vertices in Graph: " + graph.getAmountOfNodes());
		// Adding edges between the vertices in the graph
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);

	}

}
