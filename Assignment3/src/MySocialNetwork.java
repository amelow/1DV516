
import java.util.List;

/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MySocialNetwork extends MyUndirectedGraph implements A3SocialNetwork {

	MySocialNetwork(int size) {
		super(size);

	}

	@Override
	public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
		return 0;
	}

	@Override
	public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
		return 0;
	}

	@Override
	public List<Integer> possibleFriends(int vertexIndex) {
		return null;
	}

}
