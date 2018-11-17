package main;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class AssertThatCompareValueMatcher {

  @Test
  public void equalTo_matcher() throws Exception {
    int age = 20;
    assertThat(age, equalTo(20));

    double salary = 1000001.120;
    assertThat(salary, equalTo(1000001.12));

    String lessonName = "Software Testing";
    assertThat(lessonName, equalTo("Software Testing"));

    String tools[] = {"Junit", "Intellij idea", "hamcrest"};
    assertThat(tools, equalTo(new String[]{"Junit", "Intellij idea", "hamcrest"}));
  }

  @Test
  public void equalTo_Matcher_array_content_same_but_index_not_same() throws Exception {
    String tools[] = {"Junit", "Intellij idea", "hamcrest"};
    assertThat(tools, equalTo(new String[]{"hamcrest", "Intellij idea", "Junit"}));
  }

  @Test
  public void not_Matcher_test_pass() throws Exception {
    int age = 20;
    assertThat(age, not(equalTo(29)));
  }

  @Test
  public void not_Matcher_test_fail() throws Exception {
    int age = 20;
    assertThat(age, not(equalTo(20)));
  }
}
