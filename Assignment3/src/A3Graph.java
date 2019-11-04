
import java.util.List;

public interface A3Graph {

	public void addVertex(int vertex);

	public void addEdge(int sourceVertex, int targetVertex);

	public boolean isConnected();

	public boolean isAcyclic();

	public List<List<Integer>> connectedComponents();

	default public boolean hasEulerPath() {
		return false;
	}

	default public List<Integer> eulerPath() {
		return null;
	}

}
