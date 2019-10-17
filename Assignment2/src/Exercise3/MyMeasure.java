package Exercise3;

import java.util.Arrays;

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
		int sumOfDiff = 0;
		if (array1.length != array2.length) {
			System.err.println("Not the same sized array");
		}
		insertionSort(array1);
		insertionSort(array2);
		for (int i = 0; i < array1.length; i++) {
			sumOfDiff += Math.pow(array1[i] - array2[i], 2);
		}

		return sumOfDiff;
	}

	@Override
	public int[] getPercentileRange(int[] arr, int lower, int upper) {
		int size = arr.length;
		int pos = 0;
		if (upper < lower) {
			throw new RuntimeException("Lower cannot be bigger than upper");
		}
		insertionSort(arr);
		int[] range = new int[size];
		while (lower <= upper) {

		}
		return range;
	}

	private static int[] insertionSort(int[] in) {
		for (int i = 0; i < in.length; i++) {
			int temp = in[i];
			int j = i;
			while (j > 0 && in[j - 1] > temp) {
				in[j] = in[j - 1];
				j = j - 1;
			}
			in[j] = temp;
		}
		return in;
	}

}
