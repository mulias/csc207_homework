public class TwoC<Rational> {

	/**
	 * Constructs a Rational Number from two integers, one is the numerator and
	 * the other is denominator. (Constructor)
	 */
	public Rational rationalnum(int numerator, int denominator) {
		return null;
	} // rationalnum

	/**
	 * Get the numerator of this rational number. (Observer)
	 */
	public int numerator() {
		return 0; // STUB
	} // numerator

	/**
	 * Get the denominator of this rational number. (Observer)
	 */
	public int denominator() {
		return 0; // STUB
	} // denominator

	/**
	 * Puts rational number to simplest form. (Mutator)
	 */
	public void simplify() {
	} // simplify

	/**
	 * Add an integer to this rational number. (Observer/Constructor)
	 */
	public Rational addInt(int integer) {
		return null; // STUB
	} // addint (int)

	/**
	 * Substracts an integer to this rational number. (Observer/Constructor)
	 */
	public Rational subtractInt(int integer) {
		return null; // STUB
	} // subtractint (int)

	/**
	 * Multiply this rational number by an integer. (Observer/Constructor)
	 */
	public Rational multiplyInt(int multiplicand) {
		return null; // STUB
	} // multiplyint (int)

	public Rational divideInt(int dividen) {
		return null; // STUB
	} // divideint (int)

	/**
	 * Adds another rational number this rational number. (Observer/Constructor)
	 */
	public Rational addRat(Rational num) {
		return null; // STUB
	} // addrat (Rational)

	/**
	 * Substracts another rational number to this rational number.
	 * (Observer/Constructor)
	 */
	public Rational subtractRat(Rational num) {
		return null; // STUB
	} // subtractrat (Rational)

	/**
	 * Multiply this rational number by another rational number.
	 * (Observer/Constructor)
	 */
	public Rational multiplyRat(Rational num) {
		return null; // STUB
	} // multiplyrat (Rational)

	/**
	 * Divide this rational number by another rational number.
	 * (Observer/Constructor)
	 */
	public Rational divideRat(Rational num) {
		return null; // STUB
	} // dividerat (Rational)

	/**
	 * Compares another rational, gives true if other rational number is less
	 * than this rational number, gives false otherwise. (Observer)
	 */
	public boolean lessThan(Rational num) {
		return false; // STUB
	} // lessthan (Rational)

	/**
	 * Compares another rational, gives true if other rational number is greater
	 * than this rational number, gives false otherwise. (Observer)
	 */
	public boolean greaterThan(Rational num) {
		return false; // STUB
	} // greaterthan (Rational)

	/**
	 * Compares another rational, gives true if other rational number is equal
	 * to this rational number, gives false otherwise. Overrides equals(Object)
	 * (Observer)
	 */
	public boolean equals(Rational num) {
		return false; // STUB
	} // equals(Rational num)

	/**
	 * Converts an integer into a rational number. (Constructor)
	 */
	public Rational intToRat(int num) {
		return null; // STUB
	} // intToRat(int num)

	/**
	 * Converts a double into a rational number. (Constructor)
	 */
	public Rational doubleToRat(double num) {
		return null; // STUB
	} // doubleToRat(double num)

	/**
	 * Convert Rational number to double (observer, constructor)
	 */
	public double to_double() {
		return 0; // STUB
	} // to_double()

	/**
	 * "flips" the numerator and denominator of a Rational (mutator)
	 */
	public Rational inverse() {
		return null; // STUB
	} // inverse()

	/**
	 * Raise a Rational to the power of i, an int (mutator)
	 */
	public Rational to_power(int i) {
		return null; // STUB
	} // to_power(int i)

	/**
	 * Returns a string version of the rational number (Observer, Constructor)
	 */
	public String toString() {
		return null; // STUB
	} // toString()

	/**
	 * Compares rational to second rational. Returns a negative number if the
	 * first rational is smaller, zero if the rationals are equal, or a positive
	 * number if the first rational is larger than the second (Observer)
	 */
	public int compareTo(Rational num) {
		return 0; // STUB
	} // compareTo(Rational num)

	/**
	 * Returns a hash number, which should be unique to this rational. All
	 * exactly equivalent rationals (same numerator and denominator) will return
	 * the same hash, but the hash is otherwise unique from the hash for all
	 * other rationals. (Observer)
	 */
	public int hashCode() {
		return 0; // STUB
	} // hashCode()
	
} // TwoC<Rational>
