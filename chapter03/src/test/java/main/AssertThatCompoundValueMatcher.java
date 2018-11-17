package main;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class AssertThatCompoundValueMatcher {

  @Test
  public void verify_multiple_values() throws Exception {
    double marks = 100.0;
    assertThat(marks, either(equalTo(100.0)).or(equalTo(90.0)));
    assertThat(marks, both(equalTo(100.0)).and(not(equalTo(90.0))));
    assertThat(marks, anyOf(equalTo(100.0), equalTo(90.0), equalTo(80.0)));
    assertThat(marks, not(anyOf(equalTo(50.0), equalTo(30.0))));
    assertThat(marks, not(allOf(equalTo(30.0), equalTo(100.0), equalTo(30.0))));
  }


}
