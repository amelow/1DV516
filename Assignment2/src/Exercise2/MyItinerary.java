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

	@Override
	public int[] getIntersections() {
		return null;
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
