package problem3;

import java.util.Stack;

// this probably extends Vector or something, kind of like Stack. 
// But I'm short on time so a number of methods are wrappers that do nothing
public class RpnCalcDoubleModel
{
  Stack<Double> memory;

  /**
   * Constructor, sets the memory as a stack If I had more time I would add a
   * size field so that peekAll could maloc right and an exception could be
   * thrown before trying to operate on an empty stack
   */
  public RpnCalcDoubleModel()
  {
    this.memory = new Stack<Double>();
  } // RpnCalcDoubleModel()

  public double pop()
  {
    return this.memory.pop();
  } // pop()

  public void push(String num)
  {
    this.memory.push(Double.parseDouble(num));
  } // push(String)

  public void push(double num)
  {
    this.memory.push(num);
  } // push(double)

  public double peek()
  {
    return this.memory.peek();
  } // peek()

  public Number[] peekAll()
  {
    return (Number[]) this.memory.toArray(new Number[0]);
  } // peekAll()

  public void clear()
  {
    this.memory.clear();
  } // clear()
}
