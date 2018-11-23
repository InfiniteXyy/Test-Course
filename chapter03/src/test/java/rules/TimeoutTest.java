package rules;

import org.junit.Test;

public class TimeoutTest {

  @Test(timeout = 200)
  public void method_executes_timely() throws Exception {
    Thread.sleep(100);
  }

  @Test(timeout = 200)
  public void method_executes_too_long() throws Exception {
    Thread.sleep(1000);
  }
}
