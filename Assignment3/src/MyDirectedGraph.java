
import java.util.List;

public class MyDirectedGraph implements A3Graph {

	public MyDirectedGraph(int amountOfVertices) {
		for (int vertex = 0; vertex < amountOfVertices; vertex++) {
			addVertex(vertex);
		}
	}

	@Override
	public void addVertex(int vertex) {

	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAcyclic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		// TODO Auto-generated method stub
		return null;
	}

}
