package theory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ExternalTheoryTest {

  // 执行9次
  @Theory
  public void add_numbers(
      @ParametersSuppliedBy(NumberSupplier.class) Number num1,
      @ParametersSuppliedBy(NumberSupplier.class) Number num2
  ) {
    System.out.println(
        "num1 + num2 = " + num1 + " + " + num2 + " = " + (num1.doubleValue() + num2.doubleValue()));
  }

  @Theory
  public void add_numbers_test(
      @ParametersSuppliedBy(NumberSupplier.class) Number num1,
      @ParametersSuppliedBy(NumberSupplier.class) Number num2
  ) {
    // arrange
    Adder adder = new Adder();

    // act
    double expectedSum = num1.doubleValue() + num2.doubleValue();
    double actualResult = (Double) adder.add(num1, num2);

    // assert
    assertThat(actualResult, equalTo(expectedSum));
  }

  // 执行4次
  @Theory
  public void add_String(
      @ParametersSuppliedBy(StringSupplier.class) String str1,
      @ParametersSuppliedBy(StringSupplier.class) String str2
  ) {
    System.out.println(
        "str1 + str2 = " + str1 + " + " + str2 + " = " + (str1 + str2));
  }
  @Theory
  public void add_String_test(
      @ParametersSuppliedBy(StringSupplier.class) String str1,
      @ParametersSuppliedBy(StringSupplier.class) String str2
  ) {
    // arrange
    Adder adder = new Adder();

    // act
    String expectedStr = str1 + str2;
    String actualResult = (String) adder.add(str1, str2);

    // assert
    Assert.assertEquals(expectedStr, actualResult);
  }
}
