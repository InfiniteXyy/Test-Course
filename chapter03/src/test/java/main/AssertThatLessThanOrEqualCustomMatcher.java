package main;

import static org.junit.Assert.assertThat;
import static main.LessThanOrEqual.lessThanOrEqual;

import org.junit.Test;

public class AssertThatLessThanOrEqualCustomMatcher {

  @Test
  public void lessThanOrEqual_test() throws Exception {
    int actualInt = 50;
    assertThat(actualInt, lessThanOrEqual(52));
    assertThat(actualInt, lessThanOrEqual(50));

    double actualDouble = 1.414;
    assertThat(actualDouble, lessThanOrEqual(1.42));
    assertThat(actualDouble, lessThanOrEqual(1.414));

    String actualString = "xyy";
    assertThat(actualString, lessThanOrEqual("yyy"));
    assertThat(actualString, lessThanOrEqual("xyy"));
  }

  @Test
  public void compare_with_Maximum_value() throws Exception {
    // max_value + 1 就是负数了，符号为变为1, 是最小的int
    int actualMax = Integer.MAX_VALUE + 1;
    assertThat(actualMax, lessThanOrEqual(Integer.MAX_VALUE));
  }

  @Test
  public void compare_with_Minimal_value() throws Exception {
    int actualMin = Integer.MIN_VALUE + 1;
    assertThat(actualMin, lessThanOrEqual(Integer.MIN_VALUE));
  }
}
