package exceptions;

import static exceptions.ThrowableCapter.thrownBy;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExceptionTestUseFunctionalInterface {

  @Test
  public void test_tryException_method_throw_Expected_Exception() {
    // arrange
    Integer[] op = null;
    ExceptHandlingDemo demo = new ExceptHandlingDemo();

    // act
    Throwable actual = thrownBy(() -> demo.tryException(op));

    // assert
    assertNotNull(actual);
    assertTrue(actual instanceof NullPointerException);
  }

  @Test
  public void test_throwException_method_should_throw_RuntimeException() {
    // arrange
    ExceptHandlingDemo demo = new ExceptHandlingDemo();

    //act
    Throwable actual = thrownBy(demo::throwException);

    // assert
    assertNotNull(actual);
    assertTrue(actual instanceof RuntimeException);
    assertThat(actual.getMessage(), containsString("su"));
  }

}
