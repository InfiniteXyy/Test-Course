package junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

public class DynamicTestJUnit5 {

  @TestFactory
  Stream<DynamicTest> generateRandomNumberOfTests() {
    // Generates random positive integers between 0 and 100 until
    // a number evenly divisible by 5 is encountered
    Iterator<Integer> inputGenerator = new Iterator<Integer>() {

      Random random = new Random();
      int current;

      @Override
      public boolean hasNext() {
        current = random.nextInt(100);
        return current % 5 != 0;
      }

      @Override
      public Integer next() {
        return current;
      }
    };

    Function<Integer, String> displayNameGenerator = input -> "input:" + input;

    ThrowingConsumer<Integer> testExecutor = input -> assertTrue(input % 5 != 0);

    return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
  }

}
