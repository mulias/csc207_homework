package edu.grinnell.csc207.hw4;

import java.math.BigInteger;

/**
 * A simple implementation of Fractions. Outlined by SamR, expanded by Elias and
 * Ashwin
 * 
 * @author Samuel A. Rebelsky
 * @author Elias Mulhall
 * @author Ashwin Sivaramakrishnan
 * @version initial 1.0 of February 2005, updated February 2014
 */
public class Fraction
{
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a negative numerator. Similarly, if a fraction has a
   * negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction in simplified form, one must call the simplify method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom) throws Exception
  {
    // if denominator is negative, negate numerator value
    if (denom.compareTo(BigInteger.valueOf(0)) == -1)
      {
        num = num.negate();
        denom = denom.negate();
      } // if
    // if denominator is 0, error
    if (denom.compareTo(BigInteger.valueOf(0)) == 0)
      {
        throw new Exception("fraction can not have denominator of 0.");
      } // if

    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   */
  public Fraction(int num, int denom) throws Exception
  {
    // if denominator is negative, negate numerator value
    if (denom < 0)
      {
        num = -1 * num;
        denom = -1 * denom;
      } // if
    // if denominator is 0, error
    if (denom == 0)
      {
        throw new Exception("fraction can not have denominator of 0.");
      } // if

    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);

    if (!(this.denom.signum() == 1))
      {
        throw new Exception("Denominator cannot be 0 or negative");
      }
  } // Fraction(int, int)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue()
  {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Express this fraction as an integer. Any non-integer remainder is
   * eliminated, rounding towards 0.
   */
  public int intValue()
  {
    return this.num.intValue() / this.denom.intValue();
  } // intValue()

  /**
   * Add the fraction other to this fraction.
   */
  public Fraction add(Fraction other)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and other's denominator
    resultDenominator = this.denom.multiply(other.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(other.denom)).add(other.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  } // add(Fraction)

  /**
   * subtract the fraction other from this fraction.
   */
  public Fraction subtract(Fraction other)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and other's denominator
    resultDenominator = this.denom.multiply(other.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(other.denom)).subtract(other.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  } // subtract(Fraction)

  /**
   * multiply the fraction by fraction other.
   */
  public Fraction multiply(Fraction other)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and other's denominator
    resultDenominator = this.denom.multiply(other.denom);
    // The numerator of the result is the
    // product of this object's numerator
    // and other's numerator
    resultNumerator = this.num.multiply(other.num);

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  } // multiply(Fraction)

  /**
   * divide this fraction by fraction other.
   */
  public Fraction divide(Fraction other)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and other's numerator
    resultDenominator = this.denom.multiply(other.num);
    // The numerator of the result is the
    // product of this object's numerator
    // and other's denominator
    resultNumerator = this.num.multiply(other.denom);

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  } // divide(Fraction)

  /**
   * Returns the fractional remainder of the numerator divided by the
   * denominator.
   */
  public Fraction fractional()
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultDenominator = this.denom;
    // if(this.num > this.denom)
    resultNumerator = (this.num.mod(this.denom));
    return new Fraction(resultNumerator, resultDenominator);
  } // fractional()

  /**
   * Returns the fraction in simplest form, that is with both the numerator and
   * denominator divided by the greatest common divider.
   */
  public Fraction simplify()
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    //Find the greatest common denominator using gcd
    BigInteger divisor = this.num.gcd(this.denom);
    
    // dividing num and denom by gcd results in simplified fraction
    resultNumerator = this.num.divide(divisor);
    resultDenominator = this.denom.divide(divisor);

    return new Fraction(resultNumerator, resultDenominator);
  } // simplify()

  /**
   * Convert this fraction to a string for ease of printing. If the fraction has
   * a numerator of 0, 0 is printed. If the fraction has a denominator of 1, the
   * numerator is printed as an integer
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0";
      } // if it's zero
    // Special case: is a unit fraction (denominator is 1)
    else if (this.denom.equals(BigInteger.valueOf(1)))
      {
        return this.num.toString();
      } // if denominator is 1

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  /**
   * Takes a string representation of a fraction and returns the corresponding
   * Fraction. If the string represents an integer (does not have a slash), then
   * the resulting fraction has a denominator of 1.
   */
  // Examples:
  // "2/5" --> new Fraction(2, 5)
  // "5" --> new Fraction(5, 1)
  public static Fraction parseFrac(String str)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    String[] nums = str.split("/");

    // number before the '/' is the numerator
    try
      {
        resultNumerator = BigInteger.valueOf(Integer.parseInt(nums[0]));
      } // try
    catch (Exception FormatInputError)
      {
        throw new Exception(str + " is an improperly formatted number.");
      } // catch

    // if there is no slash, assume fraction is over 1
    if (nums.length == 1)
      {
        resultDenominator = BigInteger.valueOf(1);
      } // if
    // otherwise number after the '/' is the denominator
    else
      {
        try
          {
            resultDenominator = BigInteger.valueOf(Integer.parseInt(nums[1]));
          } // try
        catch (Exception FormatInputError)
          {
            throw new Exception(str + " is an improperly formatted number.");
          } // catch
      } // else

    return new Fraction(resultNumerator, resultDenominator);
  } // parseFrac(String)
} // class Fraction