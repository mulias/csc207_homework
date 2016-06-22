import static org.junit.Assert.*;
import org.junit.Test;

public class TestTwoA {

	@Test
	public void test_isMultiple() {
		// test that a == b*i, for a range of b and i
		// set a = b*i, so that there is always a valid
		// value i to multiply by b
		// test negative and positive values
		// and tests that when a=0 there is always an i
		for (long b = -20; b < 20; b++) {
			for (int i = -20; i < 20; i++) {
				assertEquals("for integer b: " + (b * i) + "==" + b + "*" + i,
						true, TwoA.isMultiple((b * i), b));
			}
		}
		// when b = 0 and a != 0, there should never be a multiple
		for (long a = -10; a < 0; a++) {
			assertEquals(a + " != 0*i", false, TwoA.isMultiple(a, 0));
		}
		for (long a = 1; a < 10; a++) {
			assertEquals(a + " != 0*i", false, TwoA.isMultiple(a, 0));
		}
	}

	@Test
	public void test_isOdd() {
		// all values of a are odd and should return true
		// all values of a+1 are even and should return false
		for (int a = -21; a < 22; a += 2) {
			assertEquals(a + " is odd", true, TwoA.isOdd(a));
			assertEquals((a + 1) + " is not odd", false, TwoA.isOdd(a + 1));
		}
	}

	@Test
	public void test_oddSumTo() {
		// only sum positive odd values less than n
		// so when n < 0, always return 0
		for (int n = -5; n < 0; n++) {
			assertEquals("negative n, n = " + n, 0, TwoA.oddSumTo(n));
		}
		// test the odd sums for odd numbers, add odd numbers to the total
		// after each test
		int total = 0;
		for (int n = 1; n < 30; n += 2) {
			assertEquals("odd n, n = " + n, total, TwoA.oddSumTo(n));
			total += n;
		}
		// test the odd sum for even numbers, after testing each number add
		// the next closest odd to the total
		total = 0;
		for (int n = 0; n < 30; n += 2) {
			assertEquals("even n, n = " + n, total, TwoA.oddSumTo(n));
			total += n + 1;
		}
	}

	@Test
	public void test_isOddProd() {
		int[] oddprod1 = { 1, 3, 5 }; // all odd so all products will be odd
		int[] oddprod2 = { 2, 1, 3 }; // 2 is even, making some products even
		int[] oddprod3 = { 0, 3 }; // 0 is even, making 0 * 3 = 0
		int[] oddprod4 = { -2, 3 }; // -2 is even, making -2 * 3 = -6 which is
									// even
		int[] oddprod5 = { -3, 5 }; // all odd, so product is odd
		int[] oddprod6 = {2, 4, -4}; //all even, so product is even
		assertEquals("oddprod1", true, TwoA.isOddProd(oddprod1));
		assertEquals("oddprod2", true, TwoA.isOddProd(oddprod2));
		assertEquals("oddprod3", false, TwoA.isOddProd(oddprod3));
		assertEquals("oddprod4", false, TwoA.isOddProd(oddprod4));
		assertEquals("oddprod5", true, TwoA.isOddProd(oddprod5));
		assertEquals("oddprod6", false, TwoA.isOddProd(oddprod6));
	} // test_isOddProd

	@Test
	public void test_allDistinct() {
		int[] test1 = { 1, 2, 3, 4, 5 }; // No repeating numbers
		int[] test2 = { 1, 2, 2, 4 }; // 2 is repeated which should make the
										// test false
		int[] test3 = { -1, 0, 1 }; // negative test
		int[] test4 = { -1, 0, 1, -1 }; // negative test
		int[] test5 = { 1 }; // only 1 value in array
		int[] test6 = {}; // empty array
		assertEquals("test1 array", true, TwoA.allDistinct(test1));
		assertEquals("test2 array", false, TwoA.allDistinct(test2));
		assertEquals("test3 array", true, TwoA.allDistinct(test3));
		assertEquals("test4 array", false, TwoA.allDistinct(test4));
		assertEquals("test5 array", true, TwoA.allDistinct(test5));
		assertEquals("test6 array", true, TwoA.allDistinct(test6));
	} // test_allDistinct

	@Test
	public void test_reverseInts() {
		int[] arraytest1 = { 1, 2, 3, 4, 5 };
		int[] reverse1 = { 5, 4, 3, 2, 1 };
		int[] arraytest2 = { 2, 1, 4, 4, 2 };
		int[] reverse2 = { 2, 4, 4, 1, 2 };
		int[] arraytest3 = { 1 }; // only 1 element in array
		int[] reverse3 = { 1 };
		
		TwoA.reverseInts(arraytest1);
		TwoA.reverseInts(arraytest2);
		TwoA.reverseInts(arraytest3);
		/* For loop tests all elements in both arrays to see if they are equal. */
		assertArrayEquals("reverse arraytest1", reverse1, arraytest1);
		assertArrayEquals("reverse arraytest2", reverse2, arraytest2);
		assertArrayEquals("reverse arraytest3", reverse3, arraytest3);
	} // test_reverseInts()
}
