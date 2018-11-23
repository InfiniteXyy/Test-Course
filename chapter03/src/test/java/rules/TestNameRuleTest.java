package rules;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestNameRuleTest {

  @Rule
  public TestName name = new TestName();

  @Test
  public void test_1() {
    assertThat(name.getMethodName(), equalTo("test_1"));
  }

  @Test
  public void test_2() {
    assertThat(name.getMethodName(), equalTo("test_2"));
  }

}
