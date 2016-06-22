package edu.grinnell.csc207.hw4;

import edu.grinnell.csc207.hw4.Fraction;

public class Calculator
{

  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * All numbers are fractions. The calculator returns fractions in simplest
   * form, but does not simplify until the last step. When a number is a
   * "unit fraction", that is a fraction over 1, the numerator is printed
   * without the denominator, as detailed in the Fraction class. The fraction
   * "5/1" is displayed as "5", but is always saved as a fraction.
   * 
   * All other design choices should match the details of the assignment.
   */

  /**
   * The calculator has 8 registers to save data, labeled r0 to r7 The register
   * array stores these values.
   */
  static Fraction[] register = new Fraction[8];

  /**
   * Takes the name of a register, "r0" to "r7" and a fraction value to save
   * into the register. Sets the corresponding index in the register array with
   * the given value.
   */
  public static void setReg(String reg_name, Fraction frac)
    throws Exception
  {
    // try to get register number from given register name
    // try to set a value at that index in register array
    try
      {
        int reg_num = Integer.parseInt(reg_name.substring(1)); // get reg num
        register[reg_num] = frac; // set fraction at index
      } // try
    // if the register is invalid (bad name, out of array bounds), error
    catch (Exception InvalidRegister)
      {
        throw new Exception(reg_name + " is not a valid register");
      } // catch
  } // setReg(String, Fraction)

  /**
   * Get the Fraction stored in a named register, one of "r0" to "r7"
   */
  public static Fraction getReg(String reg_name)
    throws Exception
  {
    Fraction value; // register value to get
    // try to get register number from given register name
    // try to get the value at that index in register array
    try
      {
        int reg_num = Integer.parseInt(reg_name.substring(1)); // get reg num
        value = register[reg_num]; // return fraction at index
      } // try
    // if the register is invalid (bad name, out of array bounds), error
    catch (Exception InvalidRegister)
      {
        throw new Exception(reg_name + " is not a valid register");
      } // catch
    // if register is null, error
    if (value == null)
      {
        throw new Exception(reg_name + " does not hold a value");
      } // if
    else
      {
        return value;
      } // else
  } // getReg(String)

  /**
   * Evaluate a string of valid numbers and operators. The string can be an
   * expression to resolve, or an assignment to a register.
   */
  // Valid numbers: ints ("5"), fractions ("1/2", "3/1"), registers ("r0", "r5")
  // Valid operators: +, -, *, /

  public static Fraction evaluate(String evalString)
    throws Exception
  {
    // if input is empty, return 0
    if (evalString.equals(""))
      {
        return new Fraction(0, 1);
      } // if

    // check if result will be assigned to a register
    boolean saveToReg = false;
    String[] parts = evalString.split(" = ");
    String[] inputList;

    // if the string has a part before the '=' and a part after
    if (parts.length == 2)
      {
        saveToReg = true; // part[0] is the register to save to
        inputList = parts[1].split(" "); // part[1] is the expression to eval
      } // if
    // otherwise ignore split parts
    // if there is no '=' then we don't save to a register
    // if there is more than one '=' then the parser will give an error
    else
      {
        inputList = evalString.split(" ");
      } // else

    // set the initial value of the final answer
    Fraction result;
    // if it's a register, get the stored number
    if (inputList[0].matches("r[0-7]"))
      {
        result = getReg(inputList[0].trim());
      } // if
    // otherwise it's a number
    else
      {
        result = Fraction.parseFrac(inputList[0].trim());
      } // else

    // evaluate pairs of operators and numbers
    // i is the operator, i+1 is the number
    for (int i = 1; i < inputList.length; i += 2)
      {
        // set the number to operate on
        Fraction num;
        if (inputList[i + 1].matches("r[0-7]"))
          {
            num = getReg(inputList[i + 1]);
          } // if
        else
          {
            num = Fraction.parseFrac(inputList[i + 1]);
          } // else
        // operate on current result
        switch (inputList[i])
          {
            case "+":
              result = result.add(num);
              break;
            case "-":
              result = result.subtract(num);
              break;
            case "*":
              result = result.multiply(num);
              break;
            case "/":
              result = result.divide(num);
              break;
            default:
              throw new Exception(inputList[i] + " is not a valid operator");
          } // switch
      }
    // save to a register
    if (saveToReg)
      {
        setReg(parts[0].trim(), result.simplify());
      } // if
    // return result in simplest form
    return result.simplify();
  } // evaluate(String)

  public static Fraction[] evaluate(String[] expressions)
    throws Exception
  {
    int exps_count = expressions.length;
    Fraction[] results = new Fraction[exps_count];

    // for each string, use evaluate(String) to get answer, then save to array
    // of results
    for (int i = 0; i < exps_count; i++)
      {
        results[i] = evaluate(expressions[i]);
      }// for

    return results;
  }// evaluate(String[])
}//class Calculator
