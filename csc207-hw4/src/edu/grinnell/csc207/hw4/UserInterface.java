package edu.grinnell.csc207.hw4;

public class UserInterface
{

  /**
   * Simple user-interface for using the Calculator class
   * 
   * @author Elias Mulhall
   * @author Ashwin Sivaramakrishnan
   */
  public static void main(String[] args)
    throws Exception
  {
    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
    pen.println("List of Commands: ");
    pen.println("Registers/registers [Print Register list & values]");
    pen.println("Quit/quit [Exits program]");
    pen.println();
    pen.println("A single expression can be resolved and printed, or a comma divided list of expressions can be resolved in order");
    pen.println("Values can be assigned to registers r0 .. r7 with 'r0 = *expression*'");
    pen.println();

    java.io.InputStreamReader istream =
        new java.io.InputStreamReader(System.in);
    java.io.BufferedReader eyes = new java.io.BufferedReader(istream);
    // until the user breaks with "quit" command, evaluate and loop
    while (true)
      {
        pen.println("Enter: ");
        String name = eyes.readLine();
        // exit calculator
        if (name.equalsIgnoreCase("Quit"))
          {
            break;
          } // if
        // list registers
        else if (name.equalsIgnoreCase("Registers"))
          {
            for (int i = 0; i < 8; i++)
              {
                try
                  {
                    pen.println("r" + i + ": " + Calculator.getReg("r" + i));
                  } // try
                catch (Exception e)
                  {
                    // if register is null, do nothing
                  } // catch
              }// for
          }// else if
        // evaluate an expression
        else
          {
            Fraction[] results;
            // try to resolve the expression
            try
              {
                // divide list of string into expressions
                String[] names = name.split(", ");
                results = Calculator.evaluate(names);
                // print each result
                for (int i = 0; i < results.length; i++)
                  {
                    pen.println(results[i]);
                  }
              }// try
            // if an expression can not be resolved, print the related error
            catch (Exception e)
              {
                pen.println("*ERROR* " + e);
              }// catch
          }// else
      } // while(true)
    eyes.close();
    pen.close();
  }// main()
}// class UserInterface
