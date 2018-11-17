package main;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class AssertThatCollectionMatcher {

  @Test
  public void verify_collection_values() throws Exception {
    List<Double> salary = Arrays.asList(50.0, 200.0, 500.0);
    assertThat(salary, hasItem(50.0));
    assertThat(salary, hasItems(50.0, 200.0));
    assertThat(salary, not(hasItem(5.0)));
  }
}
