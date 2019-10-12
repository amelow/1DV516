package Exercise2;

public class MyItinerary implements A2Itinerary<A2Direction> {
	private int height, width;
	private int left, right, up, down;
	private A2Direction[] grid;

	public MyItinerary(A2Direction[] array) {
		height = 0;
		width = 0;
		left = 0;
		right = 0;
		up = 0;
		down = 0;
		grid = array;
	}

	@Override
	public A2Direction[] rotateRight() {
		return null;
	}

	@Override
	public int widthOfItinerary() {
		for (int i = 0; i < grid.length; i++) {

		}

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

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append('{');
		for (int i = 0; i < grid.length-1; i++) {
			build.append(grid[i] + ", ");
		}
	
		build.append(grid[grid.length - 1] + "}");
		return build.toString();

	}

	public A2Direction[] getDirections() {
		return grid;

	}
}
