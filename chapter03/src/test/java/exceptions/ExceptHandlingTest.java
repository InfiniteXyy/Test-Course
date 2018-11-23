package exceptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ExceptHandlingTest {

  private ExceptHandlingDemo demo = new ExceptHandlingDemo();

  /**
   * 简单 try-fail-catch 模式
   */
  @Test
  public void divide_0_should_throw_exception() throws Exception {
    try {
      demo.divideThreeBy(0);
      fail("An IllegalArgumentException should be throw");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), equalTo("Argument 'divisor' is 0"));
    }
  }

  /**
   * expected 用来处理异常或者添加执行时长约束
   * <code>@Test(expected)</code> demo
   */
  @Test(expected = NullPointerException.class)
  public void test_tryException_method_throw_Expected_Exception() {
    Integer[] op = null;
    demo.tryException(op);
  }

  // it will cause error
  @Test(expected = IndexOutOfBoundsException.class)
  public void test_tryException_method_throw_unExpected_Exception() {
    Integer[] op = null;
    demo.tryException(op);
  }

  @Test(expected = RuntimeException.class)
  public void test_throwException_method_should_throw_RuntimeException() {
    demo.throwException();
  }

}