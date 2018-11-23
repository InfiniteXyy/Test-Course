package theory;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class MyTheories {

  @DataPoint
  public static String firstName = "Yiyang";
  @DataPoint
  public static String lastName = "Xu";
  //  @DataPoint
//  public static String wtf = "wtf";
  @DataPoints
  public static char[] mid = new char[]{'A', 'B', 'C'};


  /**
   * 并非测试用例！
   * 这里没有与期望值的比较
   * @param firstName
   * @param lastName
   */
  @Theory
  public void sanity(String firstName, String lastName) {
    System.out.println("Sanity Check: " + firstName + ", " + lastName);
  }

  @Theory
  public void sanity_fullName(String firstName, char middleName, String lastName) {
    System.out.println("Sanity Check Full Name: " + firstName + ", " + middleName + ", " + lastName);
  }
}
