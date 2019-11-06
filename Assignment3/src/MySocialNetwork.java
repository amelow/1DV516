
import java.util.List;

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
