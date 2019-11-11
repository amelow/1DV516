
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyDirectedGraph implements A3Graph {
	private List<List<Integer>> vertices = new ArrayList<List<Integer>>();
	private int numOfVertices;

	public MyDirectedGraph(int amountOfVertices) {
		setNumOfVertices(amountOfVertices);
		for (int i = 0; i < amountOfVertices; i++) {
			ArrayList<Integer> v = new ArrayList<Integer>();
			for (int j = 0; j < amountOfVertices; j++) {
				v.add(0);
			}
			vertices.add(v);
		}
	}

	@Override
	public void addVertex(int vertex) {
		for (int i = 0; i < numOfVertices; i++) {
			vertices.get(i).add(0);
		}
		ArrayList<Integer> v = new ArrayList<Integer>();

		numOfVertices++;
		for (int i = 0; i < numOfVertices; i++) {
			v.add(0);
		}
		vertices.add(v);
	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		vertices.get(targetVertex).set(sourceVertex, 1);

	}

	@Override
	public boolean isConnected() {
		for (int i = 0; i < vertices.size(); i++) {
			int count = 0;
			for (int j = 0; j < vertices.get(i).size(); j++) {
				if (vertices.get(i).get(j) == 0) {
					count++;
				}
			}
			if (count == numOfVertices) {
				return false;
			}
		}

		return true;

	}

	@Override
	public boolean isAcyclic() {

		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		return vertices;
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}

}
