package exceptions;

/**
 * 用来捕获异常，并返回
 */
public class ThrowableCapter {

  @FunctionalInterface
  public interface Actor {

    void act() throws Throwable;
  }

  public static Throwable thrownBy(Actor actor) {
    try {
      actor.act();
    } catch (Throwable throwable) {
      return throwable;
    }
    return null;
  }

}
