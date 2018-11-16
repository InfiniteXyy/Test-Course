package main;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.DEFAULT)
public class MainTest {

  private Main main = new Main();

  @Test
  public void usualLogic() {
    assertThat(main.usualLogic(true, true, false), equalTo(true));
  }

  @Test
  public void unUsualLogic() {
    assertThat(Arrays.asList("1", "3"), hasItem("1"));
    assertThat("xyy", startsWith("x"));
  }

  @Test
  public void nestedLogic() {
  }
}