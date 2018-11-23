package junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import course.Factorial;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("A parameterized test case in JUnit 5")
public class FactorialTest {

  @ParameterizedTest
  @MethodSource("dataProvider")
  void factorial_test(int number, int expectedResult) throws Exception {
    Factorial f = new Factorial();
    assertEquals(expectedResult, f.factorial(number));
  }


  @RepeatedTest(3)
  void factorial_test_repeat() {
    Factorial f = new Factorial();
    assertEquals(1, f.factorial(1));
  }

  static Stream<Arguments> dataProvider() {
    return Stream.of(
        Arguments.of(0, 1),
        Arguments.of(3, 6)
    );
  }


}
