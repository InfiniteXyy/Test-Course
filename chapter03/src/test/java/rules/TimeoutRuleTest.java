package rules;

import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutRuleTest {

  @Rule
  public Timeout globalTimeout = new Timeout(200, TimeUnit.MILLISECONDS);

  @Test
  public void finite_loop() throws InterruptedException {
    Thread.sleep(100);
  }

  @Test
  public void infinite_loop1() throws InterruptedException {
    Thread.sleep(300);
  }

  @Test
  public void infinite_loop2() throws InterruptedException {
    Thread.sleep(500);
  }
}
