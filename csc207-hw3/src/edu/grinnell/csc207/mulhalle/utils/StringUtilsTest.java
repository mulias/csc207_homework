package edu.grinnell.csc207.mulhalle.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest
{

  @Test
  public void testSplitAt()
  {
    assertArrayEquals("split over :", new String[] { "a", "b", "c" },
                      StringUtils.splitAt("a:b:c", ':'));
    assertArrayEquals("split over ' '", new String[] { "a", "b", "c" },
                      StringUtils.splitAt("a b c", ' '));
    assertArrayEquals("split over correct divider", new String[] { "a:b:c" },
                      StringUtils.splitAt("a:b:c", ' '));
    assertArrayEquals("one field", new String[] { "a" },
                      StringUtils.splitAt("a", ':'));
    assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
                      StringUtils.splitAt("a::c", ':'));
    assertArrayEquals("leading empty field", new String[] { "", "a" },
                      StringUtils.splitAt(":a", ':'));
    assertArrayEquals("trailing empty field", new String[] { "a", "" },
                      StringUtils.splitAt("a:", ':'));
    assertArrayEquals("lots of empty fields",
                      new String[] { "", "", "", "", "" },
                      StringUtils.splitAt("::::", ':'));
  }

  @Test
  public void testdeleet()
  {
    assertEquals("a, e, l, o, t, n, b",
                 StringUtils.deLeet("@, 3, 1, 0, +, |\\|, |3"));
    assertEquals("e", StringUtils.deLeet("3"));
    assertEquals("leet", StringUtils.deLeet("133+"));
    assertEquals("eat banana", StringUtils.deLeet("3@+ |3@|\\|@|\\|@"));
    assertEquals("n", StringUtils.deLeet("|\\|"));
    assertEquals("|\\", StringUtils.deLeet("|\\"));
    assertEquals("b", StringUtils.deLeet("|3"));
    assertEquals("|", StringUtils.deLeet("|"));
    assertEquals("not your mother", StringUtils.deLeet("|\\|0+ y0ur m0+h3r"));
  }

  @Test
  public void testSplitCSV()
  {
    assertArrayEquals(new String[] { "a", "b", "c" },
                      StringUtils.splitCSV("a,b,c"));
    assertArrayEquals(new String[] { "a,b", "c" },
                      StringUtils.splitCSV("\"a,b\",c"));
    assertArrayEquals(new String[] { "a", "b,b\"", "c" },
                      StringUtils.splitCSV("a,\"b,b\"\"\",c"));
  }

}
