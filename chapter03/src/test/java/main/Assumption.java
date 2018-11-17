package main;

import org.junit.Test;
import static org.junit.Assume.*;
import static org.junit.Assert.*;

public class Assumption {
  boolean shouldTest = false;

  @Test
  public void very_critical_test() throws Exception {
    assumeTrue(shouldTest);
    assertTrue(false);
  }
}
