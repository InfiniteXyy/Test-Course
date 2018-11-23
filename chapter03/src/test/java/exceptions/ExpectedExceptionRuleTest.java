package exceptions;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.*;


public class ExpectedExceptionRuleTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void throws_Nothing() {

  }

  @Test
  public void throws_NullPointerException() {
    thrown.expect(NullPointerException.class);
    throw new NullPointerException();
  }


  @Test
  public void throws_IllegalStateException_With_Message() {
    thrown.expect(IllegalStateException.class);
    thrown.expectMessage(equalTo("Hi"));
    throw new IllegalStateException("Hi!");
  }

  @Ignore("it will fail, of course")
  @Test
  public void throws_IllegalStateException_With_Message_fail() {
    thrown.expect(IllegalStateException.class);
    thrown.expectMessage("Hi!");
    throw new IllegalStateException("Hello!");
  }

  @Test
  public void throws_IllegalStateException_With_Message_matcher() {
    thrown.expect(IllegalStateException.class);
    thrown.expectMessage(startsWith("Hi!"));
    throw new IllegalStateException("Hi! This is Xyy");
  }
}
