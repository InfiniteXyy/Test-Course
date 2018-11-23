package category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryTest {

  @Category(CrazyTest.class)
  @Test
  public void crazy() {
    System.out.println("I am crazy!");
  }

  @Category(CrazyTest.class)
  @Test
  public void crazy2() {
    System.out.println("I am crazy too!");
  }

  @Category(SmartTest.class)
  @Test
  public void smart() {
    System.out.println("I am smart!");
  }

}
