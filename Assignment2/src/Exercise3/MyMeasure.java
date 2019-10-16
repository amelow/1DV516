package Exercise3;

/*
 * Authors: Håkan Johansson, Amelie Löwe.
 */
public class MyMeasure implements A2Measure {

	@Override
	public boolean isSameCollection(int[] array1, int[] array2) {
		int same = 0;
		if (array1.length != array2.length) {
			return false;
		} else {
			for (int i = 0; i < array1.length; i++) {
				boolean found = false;
				for (int j = 0; j < array2.length; j++) {
					if (array1[i] == array2[j] && found == false) {
						same++;
						found = true;
						continue;
					}

				}
			}
		}
		return same == array1.length;
	}

	@Override
	public int minDifferences(int[] array1, int[] array2) {

		return 0;
	}

	@Override
	public int[] getPercentileRange(int[] arr, int lower, int upper) {

		return null;
	}

}
