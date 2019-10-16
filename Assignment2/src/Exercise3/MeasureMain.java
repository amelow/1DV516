package Exercise3;

/*
 * Authors: Håkan Johansson, Amelie Löwe.
 */
public class MeasureMain {
	public static void main(String[] args) {
		MyMeasure measure = new MyMeasure();
		int array1[] = { 3, 5, 2, 5, 2 };
		int array2[] = { 2, 3, 5, 5, 2 };

		if (measure.isSameCollection(array1, array2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
