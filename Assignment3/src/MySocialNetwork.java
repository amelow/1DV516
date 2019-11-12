
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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

	@Override
	public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
		int friends = 0;
		Integer[] distances = socialBFS(vertexIndex);
		for (int i = 0; i < distances.length; i++) {
			if (distances[i] != null && distances[i] == distance) {
				friends++;
			}

		}
		return friends;
	}

	private Integer[] socialBFS(int vertexIndex) {
		boolean[] checked = new boolean[amount];
		Integer[] distances = new Integer[amount];
		for (int i = 0; i < distances.length; i++)
			distances[i] = -1;

		distances[vertexIndex] = 0;
		checked[vertexIndex] = true;

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(vertexIndex);

		while (queue.size() != 0) {
			vertexIndex = queue.poll();
			Iterator<Integer> i = list.get(vertexIndex).listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!checked[n]) {
					checked[n] = true;
					distances[n] = distances[vertexIndex] + 1;
					queue.add(n);
				}
			}
		}
		return distances;
	}

	@Override
	public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
		return vertexIndex;

	}

	@Override
	public List<Integer> possibleFriends(int vertexIndex) {
		return null;
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

}
