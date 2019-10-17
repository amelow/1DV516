package Exercise3;

/*
 * Authors: Håkan Johansson, Amelie Löwe.
 */
public class MeasureMain {
	public static void main(String[] args) {
		MyMeasure measure = new MyMeasure();

		/* Testing the isSameCollection() method */

		// Case 1
		int array1[] = { 1, 2, 4, 5 }; // same input, same order
		int array2[] = { 1, 2, 4, 5 };

		// Case 2
		int array3[] = { 1, 2 }; // different sized arrays
		int array4[] = { 1, 2, 4, 5, 3 };

		// Case 3
		int array5[] = { 1, 2, 3, 5 }; // same input but different order
		int array6[] = { 1, 3, 5, 2 };

		// Case 4
		int array7[] = { 8, 4, 3, 5 }; // different input, same size
		int array8[] = { 1, 3, 5, 2 };

		// Printout Case 1
		if (measure.isSameCollection(array1, array2))
			System.out.println("Case 1: Same integers in the arrays ");
		else
			System.out.println("Case 1: Different integers in the arrays");

		// Printout Case 2
		if (measure.isSameCollection(array3, array4))
			System.out.println("Case 2: Same integers in the arrays");
		else
			System.out.println("Case 2: Different integers in the arrays");

		// Printout Case 3
		if (measure.isSameCollection(array5, array6))
			System.out.println("Case 3: Same integers in the arrays");
		else
			System.out.println("Case 3: Different integers in the arrays");

		// Printout Case 4
		if (measure.isSameCollection(array7, array8))
			System.out.println("Case 4: Same integers in the arrays");
		else
			System.out.println("Case 4: Different integers in the arrays");

		/* Testing the minDifferences() method */

		int array9[] = { 2, 5, 3, 9 };
		int array10[] = { 15, 12, 1, 3 };
		System.out.println(measure.minDifferences(array9, array10));

	}

}
