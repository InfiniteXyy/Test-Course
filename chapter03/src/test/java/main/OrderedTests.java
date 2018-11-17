package main;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// ABC
// @FixMethodOrder(MethodSorters.DEFAULT)
// ABC
// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
// CBA
@FixMethodOrder(MethodSorters.JVM)
public class OrderedTests {
  @Test
  public void bTest() throws Exception {
    System.out.println("bTest");
  }

  @Test
  public void aTest() throws Exception {
    System.out.println("aTest");
  }

  @Test
  public void cTest() throws Exception {
    System.out.println("cTest");
  }
}
