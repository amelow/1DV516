
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
	/*
	 * 
	 * It returns the number of people that are at distance "distance" of the person
	 * given by "vertexIndex". For instance, for distance=2, it returns the number
	 * of people who are friends of my friends (but who are not directly my friends
	 * or myself).
	 */

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

	/*
	 * The Breadth first search used in the SocialNetworks class is Inspired
	 * by:https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
	 */
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
			Iterator<Integer> curr = list.get(vertexIndex).listIterator();
			while (curr.hasNext()) {
				int newCurr = curr.next();
				if (!checked[newCurr]) {
					checked[newCurr] = true;
					distances[newCurr] = distances[vertexIndex] + 1;
					queue.add(newCurr);
				}
			}
		}
		return distances;
	}

	/*
	 * Given a person in "vertexIndex", it returns the distance to furthest person
	 * in the graph from vertexIndex (this is, returns the highest value of the
	 * shortest paths between "vertexIndex" and the rest of nodes).
	 */
	@Override
	public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
		Integer[] distances = socialBFS(vertexIndex);
		int amountOfHopps = 0;
		for (int i = 0; i < distances.length; i++) {
			if (distances[i] != null && distances[i] >= amountOfHopps) {
				amountOfHopps = distances[i];
				System.out.println("Hopps: " + amountOfHopps);
			}
		}

		return amountOfHopps;

	}

	@Override
	public List<Integer> possibleFriends(int vertexIndex) {
		
		Integer[] distances = socialBFS(vertexIndex);
		List<Integer> myFriends = list.get(vertexIndex);
		List<Integer> eligibleFriendsFriends = new ArrayList<Integer>();		
		List<Integer> potentialFriendsFriends = new ArrayList<Integer>();
		for (int n = 0; n < distances.length; n++) {
			if (n == vertexIndex)
				continue;
			if (distances[n] == 2)
				potentialFriendsFriends.add(n);
		}
		Iterator<Integer> it = potentialFriendsFriends.iterator();
		while (it.hasNext()) {
			int n = it.next();
			List<Integer> commonFriends = (List<Integer>) list.get(n).clone();
			commonFriends.retainAll(myFriends);
			if (commonFriends.size()>=3)
				eligibleFriendsFriends.add(n);
		}
		return eligibleFriendsFriends;
	}
}