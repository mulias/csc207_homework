package problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Calculator
{
  /**
   * I wanted to know how MVC is implemented class wise in Java. I looked at the
   * example calculator at http://www.cs.utsa.edu/~cs3443/mvc-example.html and
   * went with something similar to that method.
   * 
   * This class is the launcher, meant to grab and run the M,V, and C. This
   * makes swapping out interfaces a simple process
   */

  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    BasicCalcView view = new BasicCalcView(pen);
    RpnCalcDoubleModel model = new RpnCalcDoubleModel();
    RpnCalcController controller = new RpnCalcController(model, view);
    
    controller.listen(in);
  } // main
}
