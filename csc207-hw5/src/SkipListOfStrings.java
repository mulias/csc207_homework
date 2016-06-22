/**
 * Skip lists of strings, stored alphabetically.
 */
public class SkipListOfStrings
    implements
      SetOfStrings
{

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** Max number of elements a given list element can point to */
  int MaxLevel;
  /** anchor for start of the list, points to the first element at each level */
  SkipString[] start;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * build a new skip list, optimized for a list of up to 256 elements, max
   * level 8
   */
  public SkipListOfStrings()
  {
    MaxLevel = 8;
    start = new SkipString[MaxLevel];
  } // SkipListOfStrings()

  /**
   * build a new skip list, with a specified level cap. Optimized for a list of
   * up to 2^level elements
   */
  public SkipListOfStrings(int level)
  {
    MaxLevel = level;
    start = new SkipString[MaxLevel];
  } // SkipListOfStrings(int)

  /**
   * Searches the skip list and finds the alphabetical position in the list for
   * str. If a string in the list matches str, the space right before the
   * matching string is returned. changes fromElements to be the elements
   * 
   * fromElements is an array of elements that come before str, one per level
   * toElements is an array of elements that come after str, one per level
   * 
   * @param str
   * @param fromElements
   * @param toElements
   */
  public void findPlace(String str, SkipString[] fromElements,
                        SkipString[] toElements)
  {
    // start at the top level of the start of the list
    // every time the next element has a value that goes after str, move down a
    // level. When we reach level 0 and the next element has a value that goes
    // after str, insert new element at that location

    // if MaxLevel = 8, then i starts at 7 and goes to 0
    for (int i = this.MaxLevel - 1; i >= 0; i--)
      {
        SkipString element = toElements[i];
        if (element != null)
          {
            // if str goes after element.value
            if (str.compareTo(element.value) > 0)
              {
                // update which elements to link to/from
                for (int j = 0; j < element.level; j++)
                  {
                    fromElements[j] = element;
                    toElements[j] = element.nexts[j];
                  } // for
              } // if
          } // if
        // otherwise it's time to go down a level
      } // for each level
  } // findPlace(String, SkipString[], SkipString[])

  /**
   * Determine if the set contains a particular string.
   */
  public boolean contains(String str)
  {
    SkipString[] fromElements = new SkipString[MaxLevel];
    SkipString[] toElements = this.start.clone();
    findPlace(str, fromElements, toElements);

    return (str.compareTo(toElements[0].value) == 0);
  } // contains(String)

  /**
   * Add an element to the set.
   * 
   * @post contains(str)
   */
  public void add(String str)
  {
    // keep track of which addresses are behind the insertion point, and which
    // are next. fromElements starts at the starting node, which is represented
    // by null values. toElements is the elements this.start points to.
    SkipString[] fromElements = new SkipString[MaxLevel];
    SkipString[] toElements = this.start.clone();

    // find location for str, update fromElements and toElements to be the
    // elements before and after where str will be added
    this.findPlace(str, fromElements, toElements);

    // make a new element to insert
    SkipString insert = new SkipString(str, this.MaxLevel);

    // Assign what links to and from each level of insert
    // Each level of insert links to the corresponding element of toElements
    // For the elements before insert, if the element is null it's the starting
    // point of the list, so modify the starting array to link to insert.
    // Otherwise, each element before insert at each level links to insert
    for (int i = 0; i < insert.level; i++)
      {
        insert.nexts[i] = toElements[i];
        if (fromElements[i] == null)
          {
            this.start[i] = insert;
          } // if
        else
          {
            fromElements[i].nexts[i] = insert;
          } // else
      } // for
  } // add(String)

  /**
   * Remove an element from the set.
   * 
   * @post !contains(str)
   */
  public void remove(String str)
  {
    // keep track of which addresses are before the delete point, and which
    // are after. fromElements starts at the starting node, which is represented
    // by null values. toElements is the elements this.start points to.
    SkipString[] fromElements = new SkipString[MaxLevel];
    SkipString[] toElements = this.start.clone();

    // find location for str, update fromElements to be the elements before the
    // deleted string
    // toElements points to the thing to delete, but we want it to point to the
    // elements after that
    findPlace(str, fromElements, toElements);

    for (int i = 0; i < toElements[0].level; i++)
      {
        if (fromElements[i] == null)
          {
            this.start[i] = toElements[i].nexts[i];
          }
        else
          {
            fromElements[i].nexts[i] = toElements[i].nexts[i];
          }
      } // for

    // my understanding is that if nothing points to the element containing str,
    // the garbage collector will clean it up
  } // remove(String)

  public String toString()
  {
    StringBuffer str = new StringBuffer();

    for (int i = this.MaxLevel - 1; i >= 0; i--)
      {
        SkipString element = this.start[i];
        while (element != null)
          {
            str.append(element.value);
            element = element.nexts[i];
            if (element != null)
              str.append(" -> ");
          }
        str.append('\n');
      }
    return str.toString();
  }

  public static void main(String[] args)
    throws Exception
  {
    SkipListOfStrings list = new SkipListOfStrings();
    list.add("a1");
    list.add("c1");
    list.add("b1");
    list.add("a1");
    list.add("c1");
    list.add("b1");
    System.out.println(list.toString());
  }

} // class SkipListOfStrings