package main;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class AssertTest {

  @Test
  public void assertTrue_ans_assertFalse_sample() throws Exception {
    assertTrue(true);
    assertFalse(false);
  }

  @Test
  public void assertNull_ans_assertNotNull_sample() throws Exception {
    Object myObject = null;
    assertNull(myObject);
    myObject = new Object();
    assertNotNull(myObject);
  }

  @Test
  public void assertEquals_sample() throws Exception {
    Integer i = new Integer(5);
    Integer j = new Integer(5);
    assertEquals(i, j);
  }

  @Test
  public void assertNotSame_sample() throws Exception {
    Integer i = new Integer(5);
    Integer j = new Integer(5);
    assertNotSame(i, j);
  }

  @Test
  public void assertSame_sample() throws Exception {
    Integer i = new Integer(5);
    Integer j = i;
    assertSame(i, j);
  }

  @Ignore("Relax yourself!")
  @Test
  public void go_home() throws Exception {
    System.out.println("I have to go back home!");
  }
}
