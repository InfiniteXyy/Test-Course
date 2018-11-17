package main;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class AssertThatStringMatcher {

  @Test
  public void verify_Strings() throws Exception {
    String name = "InfiniteXyy";
    assertThat(name, startsWith("In"));
    assertThat(name, endsWith("Xyy"));
    assertThat(name, containsString("finite"));
  }
}
