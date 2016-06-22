package problem3;

import java.io.PrintWriter;

public class BasicCalcView
{

  // fields
  PrintWriter pen;

  // constructor
  public BasicCalcView(PrintWriter pen)
  {
    this.pen = pen;
  } // BasicCalcView(pen)

  public void display(String str)
  {
    pen.println(str);
  } // display(String)

  public void display(Number num)
  {
    pen.println(String.format("%.2f", num.doubleValue()));
  } // display(Number)

  public void display(Number[] nums)
  {
    for (Number num : nums)
      {
        pen.print(String.format("%.2f", num.doubleValue()) + " ");
      }
    pen.println();
  } // display(Number[])
}
