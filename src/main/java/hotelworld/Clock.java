package hotelworld;

/**
 * @author xuyiyang
 */
class Clock {
  static int UTCTime = 0;

  public static int getUTCTime() {
    return UTCTime;
  }

  public static void setUTCTime(int UTCTime) {
    Clock.UTCTime = UTCTime;
  }
}
