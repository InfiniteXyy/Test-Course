package course;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FactorialTest {

  private int number;
  private int expectedResult;

  @Parameters
  public static Collection<Object[]> factorialData() {
    return Arrays
        .asList(new Object[][]{{0, 1}, {1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}, {6, 720}});
  }

  public FactorialTest(int input, int expected) {
    number = input;
    expectedResult = expected;
  }

  @Test
  public void test_factorial_with_parameters() throws Exception {
    Factorial f = new Factorial();
    assertEquals(expectedResult, f.factorial(number));
  }
}