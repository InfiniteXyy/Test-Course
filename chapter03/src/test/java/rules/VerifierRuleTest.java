package rules;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Verifier;

public class VerifierRuleTest {

  private String errorMsg = null;

  @Rule
  public TestRule rule = new Verifier() {
    @Override
    protected void verify() throws Throwable {
      Assert.assertNull("ErrorMsg should be null after each test execution", errorMsg);
    }
  };

  @Test
  public void verifier_fail() throws Exception {
    errorMsg = "with value";
  }

  @Test
  public void verifier_pass() throws Exception {

  }

}
