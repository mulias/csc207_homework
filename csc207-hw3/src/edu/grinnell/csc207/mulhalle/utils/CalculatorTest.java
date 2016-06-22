package edu.grinnell.csc207.mulhalle.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest
{

  @Test
  public void testEval0()
  {
    // return single value
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
    // test add, operate on 2 values
    assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
    // test add, operate on 3 values
    assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
    // test multiply
    assertEquals(BigInteger.valueOf(9), Calculator.eval0("3 * 3"));
    // large values
    assertEquals(BigInteger.valueOf(9000), Calculator.eval0("9000"));
    // add large values
    assertEquals(BigInteger.valueOf(18000), Calculator.eval0("9000 + 9000"));
    // test two operations in a row
    assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
    // test all operations
    assertEquals(BigInteger.valueOf(1575296),
                 Calculator.eval0("1 + 20 * 3 ^ 4 / 10"));
    // round towards 0
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("1 / 10"));
    // negatives
    assertEquals(BigInteger.valueOf(-1), Calculator.eval0("1 - 2"));
    assertEquals(BigInteger.valueOf(-50), Calculator.eval0("0 - 50"));
    // unknown operators and following numbers are ignored
    assertEquals(BigInteger.valueOf(1), Calculator.eval0("1 $ 2 $ 1"));
    // unknown operators are ignored, known operators still work
    assertEquals(BigInteger.valueOf(7), Calculator.eval0("1 $ 2 $ 1 + 6"));
  }

}
