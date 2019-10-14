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
	 * The variables horisontal and vertical will be compared to startH and startV. That is, we initiate
	 * startH and startV to know where the line to be intersection will be drawn.
	 */
	@Override
	public int[] getIntersections() {
		
		int[] intersections = new int[grid.length];
		int horisontal = 0;
		int vertical = 0;
		int count = 0;
		int startH = 0;
		int startV = 0;
		/*
		 * 1)
		 */
		for (int i = 0; i < grid.length; i++) {
			if (startH != 0 && startV != 0) {
				if (grid[i] == A2Direction.LEFT) {
					horisontal--;
					
				} else if (grid[i] == A2Direction.RIGHT) {
					horisontal++;
					
				} else if (grid[i] == A2Direction.DOWN) {
					vertical--;
					
				} else if (grid[i] == A2Direction.UP) {
					vertical++;
					
				}
				
				if(horisontal == startH && vertical == startV) {
					intersections[count] = i; 
					count++;
				}
				/*
				 * 2)
				 */
			} else {
				if (grid[i] == A2Direction.LEFT) {
					horisontal--;
					startH--;

				} else if (grid[i] == A2Direction.RIGHT) {
					horisontal++;
					startH++;

				} else if (grid[i] == A2Direction.DOWN) {
					vertical--;
					startV--;

				} else if (grid[i] == A2Direction.UP) {
					vertical++;
					startV++;
				}
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
