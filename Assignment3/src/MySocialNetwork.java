
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MySocialNetwork extends MyUndirectedGraph implements A3SocialNetwork {
	private int amount = getNumOfVertices();
	private List<ArrayList<Integer>> list = getAdjacency();
	private int friends;

	MySocialNetwork(int size) {
		super(size);

	}

	@Override
	public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
		boolean[] checked = new boolean[amount];
		Integer[] arr = new Integer[amount];
//		arr = socialBFS(vertexIndex, arr, checked);
		return 0;
	}

//	@Override
//	public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
//		int friends = 0;
//		boolean[] checked = new boolean[amount];
//		Integer[] arr = new Integer[amount];
//		arr = Search.socialDFS(vertexIndex, 0, arr, checked);
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != null && arr[i] == distance) {
//				friends++;
//			}
//		}
//		System.out.println("ARRAY:" + Arrays.toString(arr));
//		return friends;
//	}

	@Override
	public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
		return vertexIndex;

	}

	@Override
	public List<Integer> possibleFriends(int vertexIndex) {
		return null;
	}

}
