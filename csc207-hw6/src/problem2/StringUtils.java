package problem2;

import java.io.PrintWriter;
import java.util.Stack;

public class StringUtils
{
  public static void printNesting(String str, PrintWriter pen)
  {
    // for each char in str
    // if char is an "open" symbol
    // // make a PositionalChar that holds the char and its place in the string
    // // put the PositionalChar on the stack
    // if char is a "close" symbol
    // // if the top of the stack is the corresponding "open" symbol
    // // // pop and print a line
    // // else print unmatched close symbol error
    // else do nothing
    // after going through each char in str, if symbols are left on the stack
    // // print open symbol error

    pen.println(str);
    int length = str.length();
    Stack<PositionalChar> openSymbols = new Stack<PositionalChar>();
    // for each char in str
    for (int pos = 0; pos < length; pos++)
      {
        // if char is an "open" symbol
        char c = str.charAt(pos);
        if (c == '[' || c == '<' || c == '(' || c == '`' || c == '{')
          {
            openSymbols.push(new PositionalChar(pos, c));
          } // if open
        // if char is a "close" char
        if (c == ']' || c == '>' || c == ')' || c == '\'' || c == '}')
          {
            // get matching open char
            char matchingOpen;
            switch (c)
              {
                case ']':
                  matchingOpen = '[';
                  break;
                case '>':
                  matchingOpen = '<';
                  break;
                case ')':
                  matchingOpen = '(';
                  break;
                case '\'':
                  matchingOpen = '`';
                  break;
                default:
                  matchingOpen = '{';
              } // switch
            // if open and close chars correspond
            if (!openSymbols.isEmpty() 
                && matchingOpen == openSymbols.peek().character())
              {
                // print nesting line
                PositionalChar open = openSymbols.pop();
                for (int i = 0; i < open.position(); i++)
                  {
                    pen.print(" ");
                  } // for
                pen.print(open.character());
                for (int i = open.position() + 1; i < pos; i++)
                  {
                    pen.print("-");
                  } // for
                pen.println(c);
              } // if matching
            // else do not match, error
            else
              {
                // print error line
                for (int i = 0; i < pos; i++)
                  {
                    pen.print(" ");
                  }
                pen.println(c + "   <- UNMATCHED");
              } // else
          } // if close char
        // else do nothing
      }
    // if any open chars are left, print error lines
    while (!openSymbols.isEmpty())
      {
        PositionalChar open = openSymbols.pop();
        for (int i = 0; i < open.position(); i++)
          {
            pen.print(" ");
          }
        pen.println(open.character() + "   <- UNMATCHED");
      }
    pen.println();
  }// printNesting(String)


  public static class PositionalChar
  {
    // fields
    int pos;
    char character;

    // Constructor
    public PositionalChar(int pos, char c)
    {
      this.pos = pos;
      this.character = c;
    }

    // methods
    public int position()
    {
      return this.pos;
    }

    public char character()
    {
      return this.character;
    }
  }
}
