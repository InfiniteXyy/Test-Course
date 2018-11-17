package course;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FactorialTestTwo {

  // 这里需要使用public可见性
  @Parameter(value = 0)
  public int number;

  @Parameter(value = 1)
  public int expectedResult;

  // 提高测试代码可读性
  @Parameters(name = "{index}: factorial({0}) = {1}")
  public static Collection<Object[]> factorialData() {
    return Arrays
        .asList(new Object[][]{{0, 1}, {1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}, {6, 720}});
  }

  @Test
  public void test_factorial_with_parameters() throws Exception {
    Factorial f = new Factorial();
    assertEquals(expectedResult, f.factorial(number));
  }
}
