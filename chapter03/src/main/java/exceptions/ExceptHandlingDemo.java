package exceptions;

public class ExceptHandlingDemo {

  public double divideThreeBy(int divisor) {
    if (divisor == 0) {
      throw new IllegalArgumentException("Argument 'divisor' is 0");
    }
    return 3.0 / divisor;
  }

  public int tryException(Integer[] op) {
    int sum = 0;
    for (int i = 0; i < op.length; i++) {
      sum += op[i];
    }
    return sum;
  }

  public int throwException() {
    throw new RuntimeException("surprise");
  }

}
