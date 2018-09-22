package hotelworld;

/**
 * @author xuyiyang
 */
class CityClock extends Clock {

  private int offset = 0;
  private String city = "";

  CityClock(int offset, String city) {
    this.offset = offset;
    this.city = city;
  }

  int getTime() {
    return UTCTime + offset;
  }

  @Override
  public String toString() {
    return String.format("%s: %d", city, this.getTime());
  }
}
