package edu.grinnell.csc207.hw4;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest
{

  @Test
  public void testFractionsandCalculator()
    throws Exception
  {
    // +-----------+-------------------------------------------------
    // |Fractional |
    // +-----------+

    Fraction f = new Fraction(11, 3);
    Fraction f1;
    Fraction f2;
    assertEquals("2/3", f.fractional().toString());

    f = new Fraction(1, 2);
    assertEquals("1/2", f.fractional().toString());

    f = new Fraction(5, 2);
    assertEquals("1/2", f.fractional().toString());

    f = new Fraction(1, 1);
    assertEquals("0", f.fractional().toString());

    // +-----------------+---------------------------------------------
    // |Basic Operations |
    // +-----------------+

    f = new Fraction(1, 2);
    assertEquals("1/2", Calculator.evaluate(String.valueOf(f)).toString());

    /* Addition */
    for (int i = 1; i < 100; i++)
      {
        f = new Fraction(i, 2);
        f1 = new Fraction((i + 3), 2).simplify();

        assertEquals(f1 + "", Calculator.evaluate(f + " + 3/2").toString());
      }//for

    /* Subtraction */
    for (int i = 100; i < 1; i--)
      {
        f = new Fraction(i, 2);
        f1 = new Fraction((i - 3), 2).simplify();

        assertEquals(f1 + "", Calculator.evaluate(f + " - 3/2").toString());
      }//for

    /* Multiplication */
    for (int i = 1; i < 100; i++)
      {
        f = new Fraction(i, 2);
        f1 = new Fraction((i * 3), 4).simplify();

        assertEquals(f1 + "", Calculator.evaluate(f + " * 3/2").toString());
      }//for

    /* Division */
    for (int i = 100; i < 1; i--)
      {
        f = new Fraction(i, 2);
        f1 = new Fraction(i, 3).simplify();

        assertEquals(f1 + "", Calculator.evaluate(f + " / 3/2").toString());
      }//for

    // +---------+------------------------------------------------------
    // |Registers|
    // +---------+

    /* Set all Registers to 1/2 and check resulting value */
    for (int i = 0; i < 8; i++)
      {
        assertEquals("1/2", Calculator.evaluate("r" + i + " = 1/2").toString());
      }//for

    /** Basic Operations with Registers **/

    /* Addition */
    for (int i = 0; i < 8; i++)
      {
        assertEquals("3", Calculator.evaluate("r" + i + " + 5/2").toString());
      }//for

    /* Subtraction */
    for (int i = 0; i < 8; i++)
      {
        assertEquals("-2", Calculator.evaluate("r" + i + " - 5/2").toString());
      }//for

    /* Multiplication */
    for (int i = 0; i < 8; i++)
      {
        assertEquals("5/4", Calculator.evaluate("r" + i + " * 5/2").toString());
      }//for

    /* Division */
    for (int i = 0; i < 8; i++)
      {
        assertEquals("1/5", Calculator.evaluate("r" + i + " / 5/2").toString());
      }//for
    
    /* Register using values of other Registers */
    assertEquals("5/2", Calculator.evaluate("r3 = 5/2").toString());
    assertEquals("7/2", Calculator.evaluate("r4 = 7/2").toString());
   
    assertEquals("6", Calculator.evaluate("r5 = r3 + r4").toString());
    assertEquals("6", Calculator.evaluate("r5").toString());


    // +-------------+--------------------------------------------------
    // |Array Inputs |
    // +-------------+

    for (int i = 1; i < 3; i++)
      {
        String[] input =
            new String[] { i + "/3 + 3", i + "/4 + 5/4",
                          "r" + i + " = 2/3 + 5/3" };

        f = new Fraction((i + 9), 3).simplify();
        f1 = new Fraction((i + 5), 4).simplify();
        f2 = new Fraction(7, 3);

        Fraction[] fOutput = new Fraction[] { f, f1, f2 };
        Fraction[] calcOutput = Calculator.evaluate(input);

        assertEquals(fOutput[i].toString(), calcOutput[i].toString());
      }//for
    
  }// testFractionsandCalculator()
  
}// class FractionTest
