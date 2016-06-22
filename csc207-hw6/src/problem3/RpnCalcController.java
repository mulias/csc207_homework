package problem3;

import java.io.BufferedReader;

public class RpnCalcController
{
  // swapping out the model and view requires changing the fields here, instead
  // of just in Calculator.java
  // I don't really like that, but fixing it would probably require writing
  // interfaces or something, so never mind that
  // fields
  RpnCalcDoubleModel model;
  BasicCalcView view;

  // constructor
  public RpnCalcController(RpnCalcDoubleModel model, BasicCalcView view)
  {
    this.model = model;
    this.view = view;
  } // RpnCalcController(RpnCalcDoubleModel, BasicCalcView)

  /**
   * listen to reader source and redirect commands appropriately. Acts as a
   * repl, ending the loop with a command of "q" and otherwise passing each read
   * line to the string evaluator
   * 
   * @param reader
   * @throws Exception
   */
  public void listen(BufferedReader reader)
    throws Exception
  {
    while (true)
      {
        this.view.display("Enter: ");
        String line = reader.readLine();
        if (line.equals("q"))
          {
            break;
          } // if quit
        else
          {
            try
              {
                eval(line);
              } // try
            catch (Exception e)
              {
                this.view.display(e.toString());
              } // catch
          } // else
      } // while
  } // listen(BufferedReader)

  // the unholy regex comes from here:
  // http://stackoverflow.com/questions/9341695/regex-to-match-any-number-real-rational-along-with-signs
  /**
   * evaluate strings into calculator commands seperated by spaces
   * 
   * @param evalString
   * @throws Exception
   */
  public void eval(String evalString)
    throws Exception
  {
    String[] inputList = evalString.split(" ");

    for (String action : inputList)
      {
        try
          {
            switch (action)
              {
                case "+":
                  this.model.push(this.model.pop() + this.model.pop());
                  this.view.display(this.model.peek());
                  break;
                case "-":
                  this.model.push(this.model.pop() - this.model.pop());
                  this.view.display(this.model.peek());
                  break;
                case "*":
                  this.model.push(this.model.pop() * this.model.pop());
                  this.view.display(this.model.peek());
                  break;
                case "/":
                  this.model.push(this.model.pop() / this.model.pop());
                  this.view.display(this.model.peek());
                  break;
                case "p":
                  this.view.display("Top number:");
                  this.view.display(this.model.peek());
                  break;
                case "s":
                  this.view.display("Stack:");
                  this.view.display(this.model.peekAll());
                  break;
                case "c":
                  this.model.clear();
                  this.view.display("All clear!");
                  break;
                default:
                  if (action.matches("(?:(?i)(?:[+-]?)(?:(?=[.]?[0-9])(?:[0-9]*)(?:(?:[.])(?:[0-9]{0,}))?)(?:(?:[E])(?:(?:[+-]?)(?:[0-9]+))|))"))
                    {
                      this.model.push(action);
                    } // if
                  else
                    {
                      throw new Exception("Invalid Operation " + action);
                    } // else
              } // switch(c)
          } // try
        catch (Exception e)
          {
            this.view.display(e.toString());
          } // catch
      } // for
  } // eval(String)
}
