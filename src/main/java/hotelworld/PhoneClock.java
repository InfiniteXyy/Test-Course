package hotelworld;

/**
 * @author xuyiyang
 */
class PhoneClock extends Clock {
  private int offset;
  private int time;

  public PhoneClock(int offset) {
    this.offset = offset;
    this.time = UTCTime + offset;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
    UTCTime = time - offset;
  }
}
