public class SkipString
{

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** number of elements this list element points to */
  int level;
  /** string contained in list element */
  String value;
  /** list elements pointed to, size of level */
  SkipString[] nexts;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Make a new skip list element containing the string str. Has a level between
   * 1 and MaxLevel.
   * 
   * @param str
   * @param MaxLevel
   */
  public SkipString(String str, int MaxLevel)
  {
    level = computeLevel(MaxLevel);
    value = str;
    nexts = new SkipString[level];
  }

  /**
   * Randomly chose a level for a list element, with the rule that 50% of the
   * elements with a level of at least i have a level of at least i+1, up to
   * MaxLevel
   * 
   * @param MaxLevel
   * @return
   */
  public int computeLevel(int MaxLevel)
  {
    int level = 1;
    while ((Math.random() < .5) && level < MaxLevel)
      level++;
    return level;
  }

}
