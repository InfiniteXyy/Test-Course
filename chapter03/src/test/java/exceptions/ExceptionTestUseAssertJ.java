package exceptions;

import static exceptions.ThrowableCapter.thrownBy;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;

public class ExceptionTestUseAssertJ {

  @Test
  public void test_tryException_method_throw_Expected_Exception() {
    // arrange
    Integer[] op = null;
    ExceptHandlingDemo demo = new ExceptHandlingDemo();

    // act
    Throwable actual = thrownBy(() -> demo.tryException(op));

    // assert
    assertThat(actual).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void test_throwException_method_should_throw_RuntimeException() {
    // arrange
    ExceptHandlingDemo demo = new ExceptHandlingDemo();

    // act
    Throwable actual = thrownBy(() -> demo.throwException());

    // assert
    assertThat(actual)
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("su");
  }

}
