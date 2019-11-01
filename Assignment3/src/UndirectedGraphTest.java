
public class UndirectedGraphTest {

	public static void main(String[] args) {
		Test();

	}

	private static void Test() {
		MyUndirectedGraph graph = new MyUndirectedGraph();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		System.out.print("Vertices in graph: " + graph.verticeList.size());

	}

}
