package Exercise2;

public class MyItinerary implements A2Itinerary<A2Direction> {
	private int height, width;
	private int left, right, up, down;

	public MyItinerary(A2Direction[] array) {
		height = 0;
		width = 0;
		left = 0;
		right = 0;
		up = 0;
		down = 0;
	}

	@Override
	public A2Direction[] rotateRight() {
		return null;
	}

	@Override
	public int widthOfItinerary() {

		return 0;
	}

	@Override
	public int heightOfItinerary() {

		return 0;
	}

	@Override
	public int[] getIntersections() {

		return null;
	}

}
