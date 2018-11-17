package course;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FactorialTestThree {

  @Test
  @Parameters(source = FactorialDataProvider.class)
  // @Parameters({"0, 1", "1, 1", "2, 2", "3, 6"})
  public void factorial_test(int number, int expectedResult) throws Exception {
    Factorial f = new Factorial();
    Assert.assertEquals(expectedResult, f.factorial(number));
  }
}
