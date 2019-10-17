package Exercise2;

/*
 * Authors: Håkan Johansson, Amelie Löwe.
 */
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
		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == A2Direction.LEFT) {
				grid[i] = A2Direction.UP;
			} else if (grid[i] == A2Direction.RIGHT) {
				grid[i] = A2Direction.DOWN;

			} else if (grid[i] == A2Direction.UP) {
				grid[i] = A2Direction.RIGHT;
			} else if (grid[i] == A2Direction.DOWN) {
				grid[i] = A2Direction.LEFT;
			}
		}
		return grid;
	}

	@Override
	public int widthOfItinerary() {
		calculateDirections();
		if (left > right) {
			width = left;
		} else {
			width = right;
		}

		return width;

	}

	@Override
	public int heightOfItinerary() {
		calculateDirections();
		if (up > down) {
			height = up;
		} else {
			height = down;
		}
		return height;
	}

	/*
	 * The variables horizontal and vertical will be compared to startH and startV.
	 * That is, we initiate startH and startV to know where the line to be
	 * intersection will be drawn.
	 */
	@Override
	public int[] getIntersections() {

		int[] intersections = new int[grid.length];
		int[] visitedH = new int[grid.length];
		int[] visitedV = new int[grid.length];

		int horizontal = 0;
		int vertical = 0;

		int currentH = 0;
		int currentV = 0;

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == A2Direction.LEFT) {
				horizontal--;

			} else if (grid[i] == A2Direction.RIGHT) {
				horizontal++;

			} else if (grid[i] == A2Direction.DOWN) {
				vertical--;

			} else if (grid[i] == A2Direction.UP) {
				vertical++;

			}
			visitedH[i] = horizontal;
			visitedV[i] = vertical;
		}

		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == A2Direction.LEFT) {
				currentH--;

			} else if (grid[i] == A2Direction.RIGHT) {
				currentH++;

			} else if (grid[i] == A2Direction.DOWN) {
				currentV--;

			} else if (grid[i] == A2Direction.UP) {
				currentV++;

			}

			if (currentH == visitedH[i] && currentV == visitedV[i]) {
				intersections[count] = i;
			}
		}
		return intersections;

	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append('{');
		for (int i = 0; i < grid.length - 1; i++) {
			build.append(grid[i] + ", ");
		}
		build.append(grid[grid.length - 1] + "}");
		return build.toString();

	}

	private void calculateDirections() {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == A2Direction.LEFT) {
				left++;
				right--;
			}
			if (grid[i] == A2Direction.RIGHT) {
				right++;
				left--;
			}
			if (grid[i] == A2Direction.UP) {
				up++;
				down--;
			}
			if (grid[i] == A2Direction.DOWN) {
				down++;
				up--;
			}
		}
	}
}
