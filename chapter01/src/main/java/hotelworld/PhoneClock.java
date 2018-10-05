package hotelworld;


class PhoneClock {

  private HotelSystem system;
  private int offset;
  private int time;

  public PhoneClock(int offset) {
    this.offset = offset;
  }

  public void bindSystem(HotelSystem system) {
    this.system = system;
  }

  public int getOffset() {
    return offset;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) throws NotBindException {

    this.time = time;
    if (system != null) {
      system.setStandardTime(time - offset);
    } else {
      throw new NotBindException();
    }
  }

  class NotBindException extends Exception {

    public NotBindException() {
      super("this phone has not bind hotel system");
    }
  }
}
