package problem2;

import java.io.PrintWriter;

public class StringUtilsExpt
{
  public static void main(String[] args)
    throws Exception
  {
    String str1 = "( test [ test ] end )";
    String str2 = "< { [ ( ` ' ) ] } >";
    String str3 = "[ < ] ' () ( ] >";
    String str4 = "[ < ] >";
    String str5 = "(Hello (world)";
    String str6 = "(Hello (world))}  ]";
    PrintWriter pen = new PrintWriter(System.out, true);
    StringUtils.printNesting(str1, pen);
    StringUtils.printNesting(str2, pen);
    StringUtils.printNesting(str3, pen);
    StringUtils.printNesting(str4, pen);
    StringUtils.printNesting(str5, pen);
    StringUtils.printNesting(str6, pen);
  }
}
