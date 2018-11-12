import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    Scanner scanner = new Scanner(System.in);
    char[] bools = getBools(scanner);
    boolean op1 = bools[0] == '1';
    boolean op2 = bools[1] == '1';
    boolean op3 = bools[2] == '1';
    System.out.println(main.usualLogic(op1, op2, op3));
    System.out.println(main.unUsualLogic(op1, op2, op3));
    System.out.println(main.nestedLogic(op1, op2, op3));
  }

  public static char[] getBools(Scanner scanner) {
    System.out.println("请输入一个0-7的数字");
    int option = scanner.nextInt();
    assert option >= 0 && option <= 7;
    char[] bools = String.format("%03d", Integer.valueOf(Integer.toString(option, 2)))
        .toCharArray();
    return bools;
  }

  public boolean usualLogic(boolean op1, boolean op2, boolean op3) {
    boolean output = false;
    if ((op1 && op2) || op3) {
      output = true;
    }
    return output;
  }

  public boolean unUsualLogic(boolean op1, boolean op2, boolean op3) {
    boolean output = false;
    boolean condition1 = op1 && op2;
    boolean condition2 = condition1 || op3;

    if (condition2) {
      output = true;
    }
    return output;
  }

  public boolean nestedLogic(boolean op1, boolean op2, boolean op3) {
    boolean output = false;
    if (op1) {
      if (op2) {
        output = true;
      } else {
        if (op3) {
          output = true;
        } else {
          output = false;
        }
      }

    } else {
      if (op3) {
        output = true;
      } else {
        output = false;
      }

    }
    return output;
  }
}
