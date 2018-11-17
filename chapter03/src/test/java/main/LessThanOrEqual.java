package main;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class LessThanOrEqual<T extends Comparable<T>> extends BaseMatcher<Comparable<T>> {

  private final Comparable<T> expectedValue;

  public LessThanOrEqual(T expectedValue) {
    this.expectedValue = expectedValue;
  }

  @Override
  public boolean matches(Object item) {
    return expectedValue.compareTo((T) item) > -1;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("less than or equal (<=)" + expectedValue);
  }

  @Factory
  public static <T extends Comparable<T>> Matcher<T> lessThanOrEqual(T t) {
    return (Matcher<T>) new LessThanOrEqual(t);
  }
}
