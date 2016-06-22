package edu.grinnell.csc207.mulhalle.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StringUtils
{

  /**
   * Takes a string and returns an array of substrings, divided over a dividing
   * char, div.
   */
  public static String[] splitAt(String str, char div)
  {
    // use arraylist to add substrings as needed
    ArrayList<String> splitStrings = new ArrayList<String>();

    // start and end of substrings
    int subStart = 0;
    int subEnd;
    // until the end of the string, save substrings
    while ((subEnd = str.indexOf(div, subStart)) != -1)
      {
        splitStrings.add(str.substring(subStart, subEnd));
        subStart = subEnd + 1;
      } // while, until the end of string
        // add last substring
    splitStrings.add(str.substring(subStart, str.length()));

    return splitStrings.toArray(new String[splitStrings.size()]);
  } // splitAt(String str, char div)

  /**
   * Takes a string which may contain "leet" characters, and returns a string
   * where said characters are translated back to the King's English. Converts
   * the "leet" equivalents of a, e, l, o, t, n, and b, while leaving all other
   * characters the same.
   */
  public static String deLeet(String leet)
  {
    // add translated chars to a stringbuffer
    StringBuffer not_leet = new StringBuffer();

    // for each character
    for (int i = 0; i < leet.length(); i++)
      {
        // if the char matches a leet character, add the translated char to the
        // buffer. Otherwise add the original char to the buffer.
        switch (leet.charAt(i))
          {
            case '@':
              not_leet.append('a');
              break;
            case '3':
              not_leet.append('e');
              break;
            case '1':
              not_leet.append('l');
              break;
            case '0':
              not_leet.append('o');
              break;
            case '+':
              not_leet.append('t');
              break;
            case '|':
              // n and b are more than 1 char long, check whole string
              if (leet.startsWith("|\\|", i))
                {
                  not_leet.append("n");
                  i += 2; // go to next char not part of |\|
                }
              else if (leet.startsWith("|3", i))
                {
                  not_leet.append("b");
                  i += 1; // go to next char not part of |3
                }
              else
                {
                  not_leet.append(leet.charAt(i));
                }
              break;
            default:
              not_leet.append(leet.charAt(i));
              break;
          } // switch (leet.charAt(i))
      } // for each character
    return not_leet.toString();
  } // deLeet(String leet)

  /**
   * Returns true if char is a vowel. Written as a helper method for nameGame.
   * 
   * Edit after 2/05: While taking credit for this bit of code would be nice, I
   * should add that I took it wholesale from a response on stackoverflow:
   * http://stackoverflow.com/questions/19160921/how-do-i-check-if-a-char-is-a-vowel
   */
  public static boolean isVowel(char c)
  {
    return "AEIOUaeiou".indexOf(c) != -1;
  }

  /**
   * Prints an instance of the Shirley Ellis "Name Game" algorithm, based off of
   * a user inputed name string. Preconditions: requires isVowel.
   * Postconditions: prints the resulting verse to system out. The mutated form
   * of the name will use the given name from the first vowel onward. If the
   * given string does not have vowels, an e is added to the beginning.
   * 
   * @throws IOException
   */
  public static void nameGame()
    throws IOException
  {
    InputStreamReader istream = new InputStreamReader(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(istream);

    pen.println("Let's play the Name Game!");
    pen.println("NAME: ");
    String name;
    name = eyes.readLine();

    int i = 0;
    int length = name.length();
    // find the position of the first vowel
    while ((i < length) && !(isVowel(name.charAt(i))))
      {
        i++;
      }

    String name_end;
    if (i == length) // if name has no vowels, add one
      name_end = "e" + name;
    else
      // otherwise use the first vowel onward
      name_end = name.substring(i, length).toLowerCase();

    // print verse
    pen.println(name + "!");
    pen.println(name + ", " + name + " bo B" + name_end + " Bonana fanna fo F"
                + name_end);
    pen.println("Fee fy mo M" + name_end + ", " + name + "!");

    // close io
    istream.close();
    eyes.close();
    pen.close();
  } // nameGame()

  /**
   * BROKEN Should do things, it doesn't really
   * Edit after 2/5:
   * Once again, did not cite where I should have. For what it's 
   * worth, I talked about this problem a lot with Alex and Helen.
   */
  public static String[] splitCSV(String str)
  {
    // use arraylist to add substrings as needed
    ArrayList<String> splitStrings = new ArrayList<String>();

    int subStart = 0;
    for (int i = 0; i < str.length(); i++)
      {
        if ((str.charAt(i) == '"') && (str.charAt(++i) != '"'))
          {
            while (!((str.charAt(i) != '"') && (str.charAt(i + 1) == ','))
                   || (str.charAt(i - 1) == '"'))
              {
                i++;
              }
          }
        else if (str.charAt(i) == ',')
          {
            splitStrings.add(str.substring(subStart, i));
            subStart = i;
          }
      }
    splitStrings.add(str.substring(subStart, str.length()));

    return splitStrings.toArray(new String[splitStrings.size()]);
  } // splitCSV(String str)
} // class StringUtils