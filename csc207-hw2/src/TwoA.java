public class TwoA {

	/**
	 * isMultiple - takes as input two variables, a and b, of type long, and
	 * returns true if and only if there is an integer, i, such that a == b*i.
	 */
	public static boolean isMultiple(long a, long b) {
		if (a == 0) // 0 is the multiple of every number.
		{
			return true;
		} // if (a == 0)
		else if (b == 0) // a != 0*i, unless a == 0
		{
			return false;
		} // if (b == 0)
		else // a and b are not zero
		{
			// take absolute values to avoid four different tests
			// for +/-a and +/-b
			a = Math.abs(a);
			b = Math.abs(b);
			for (int i = 1; i <= a; i++) // check a==b*i
			{
				if (a == (b * i)) // if a is a multiple of b
					return true;
			} // for
			return false;
		} // else
	} // isMultiple(long a, long b)

	/**
	 * isOdd - takes as input a variable, i, of type int returns true if i is
	 * odd and false if i is not odd.
	 */
	public static boolean isOdd(int i) {
		// bitwise comparison with the binary representation of i and 1. Checks
		// the last digit of the binary rep of i, and returns true if it is 1,
		// false if it is 0. If i is odd the binary rep will end in 1, while if
		// i is even the binary rep will end in 0.
		return ((i & 1) == 1);
	} // isOdd(int i)

	/**
	 * oddSumTo - takes as input a variable, n, of type int, and returns the sum
	 * of all positive odd numbers less than n.
	 */
	public static int oddSumTo(int n) {
		if (n > 0) {
			int i = n / 2; // i is the number of odds less than n
			return (i * i); // adding pairs of odd nums makes i/2 sets of
							// values, where each value = 2i
		} // if n > 0
		else // n <= 0
		{
			return 0; // only sum positive odds
		}
	} // oddSumTo(int n)

	/**
	 * isOddProd - takes as input ints, an array of int values and returns true
	 * if any pair of numbers in the array has a product that is odd and false
	 * otherwise. Note that you can use ints.length to determine the length of
	 * the array.
	 */
	public static boolean isOddProd(int[] ints) {
		for (int i = 0; i < ints.length; i++) {
			for (int j = (i + 1); j < ints.length; j++) {
				if (isOdd(ints[i] * ints[j])) {
					return true;
				} // if
			} // for
		} // for
		return false;
	} // isOddProd(int[] ints

	/**
	 * allDistinct - take as input an array of int values and returns true if no
	 * two elements have equal values and false otherwise.
	 */
	public static boolean allDistinct(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = (i + 1); j < array.length; j++) {
				if (array[i] == array[j]) {
					return false;
				} // if
			} // for
		} // for
		return true;
	} // allDistinct (int[] array)

	/**
	 * reverseInts - takes as input an array of int values and reverses their
	 * order in the same array.
	 */
	public static void reverseInts(int[] array) {
		int size = array.length;
		int[] reverse = new int[size];
		for (int i = 0; i < size; i++) {
			reverse[i] = array[(size - 1) - i];
		} // for
		for (int j = 0; j < size; j++) {
			array[j] = reverse[j];
		} // for
	} // reverseInts(int[] array)

}
