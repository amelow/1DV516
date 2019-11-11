
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MySocialNetwork extends MyUndirectedGraph implements A3SocialNetwork {
	private int amount = getNumOfVertices();
	private List<ArrayList<Integer>> list = getAdjacency();

	MySocialNetwork(int size) {
		super(size);

	}

	/*
	 * It returns the number of people that are at distance "distance" of the person
	 * given by "vertexIndex". For instance, for distance=2, it returns the number
	 * of people who are friends of my friends (but who are not directly my friends
	 * or myself). In the graph in the next figure,
	 * numberOfPeopleAtFriendshipDistance(5, 2) will return 4 (there are 4 vertices
	 * at distance 2 of vertex 5: <10,11,14,3>)
	 * 
	 */
	@Override
	public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
		int friends = 0;
		int depthOfGraph = 0;
		boolean[] checked = new boolean[amount];
		ArrayList testArr = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			if (!checked[i] && list.get(i) != null) {
				// Search.DepthFirstSearch(vertexIndex, depthOfGraph, checked);
			} else if (i == distance) {
				testArr.add(i);
				friends++;

			}

		}
		System.out.println("WHO IS IN FRIEND ARR: " + testArr.toString());
		return friends;

	}

//		int friends = 0;
//		ArrayList olle = new ArrayList();
//		System.out.println("Size: " + amount);
//		System.out.println("Vertice Array: " + vertices);
//
//		for (int i = 0; i < vertices.size(); i++) {
//			for (int j = 0; j < vertices.size(); j++) {
//				if (vertices.get(i).get(j) == 1) { // && vertices.get(j).get(vertexIndex) != 1) {
//					if (j == distance) {
//						friends++;
//						olle.add(i);
//					}
//				}
//			}
//			System.out.println(olle.toString());
//		}

	/*
	 * public int furthestDistanceInFriendshipRelationships(int vertexIndex). Given
	 * a person in "vertexIndex", it returns the distance to furthest person in the
	 * graph from vertexIndex (this is, returns the highest value of the shortest
	 * paths between "vertexIndex" and the rest of nodes). In the graph in the next
	 * figure, furthestDistanceInFriendshipRelationships(5) will return 3 (node 13
	 * is at distance 3 of node 5, and there is not any other node more distant than
	 * node 13)
	 */
	@Override
	public int furthestDistanceInFriendshipRelationships(int vertexIndex) {

		return vertexIndex;
	}

	/*
	 * public List<Integer> possibleFriends(int vertexIndex). Given a person in
	 * "vertexIndex", it returns the list vertices that are at distance 2 of
	 * "vertexIndex" (this is, they are friends of friends), where each of these
	 * vertices shares at least three common friends with "vertexIndex". In the
	 * graph in the next figure possibleFriends(5) are <3,10>. Vertex 3 shares 4>3
	 * friends with vertex 5 (1,2,4, and 6); while vertex 10 shares exactly 3
	 * friends with vertex 5 (7,8,9). Note that also vertices 14 and 11 are at
	 * distance 2 of vertex 5, but they share only one friend with node 5, therefore
	 * they are not considered possible friends.
	 */
	@Override
	public List<Integer> possibleFriends(int vertexIndex) {
		boolean[] visited = new boolean[amount];
		return null;
	}

}
