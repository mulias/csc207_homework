package edu.grinnell.csc207.mulhalle.utils;

import java.math.BigInteger;

public class Calculator
{
  public static BigInteger eval0(String evalString)
  {
    String[] inputList = evalString.split(" ");

    BigInteger result = BigInteger.valueOf(Integer.parseInt(inputList[0]));
    for (int i = 1; i < inputList.length; i += 2)
      {
        int num = Integer.parseInt(inputList[i + 1]);
        switch (inputList[i])
          {
            case "+":
              result = result.add(BigInteger.valueOf(num));
              break;
            case "-":
              result = result.subtract(BigInteger.valueOf(num));
              break;
            case "*":
              result = result.multiply(BigInteger.valueOf(num));
              break;
            case "/":
              result = result.divide(BigInteger.valueOf(num));
              break;
            case "^":
              result = result.pow(num);
              break;
          }
      }
    return result;
  }
}
