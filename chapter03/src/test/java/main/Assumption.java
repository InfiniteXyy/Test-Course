package main;

import org.junit.Test;
import static org.junit.Assume.*;
import static org.junit.Assert.*;

public class Assumption {
  boolean shouldTest = true;

  @Test
  public void very_critical_test() throws Exception {
    // if it is false, test after it will be ignored
    assumeTrue(shouldTest);
    assertTrue(true);
  }
}
