package hotelworld;

class CityClock {

  private int offset;
  private int localtime;
  private String city;

  CityClock(int offset, String city) {
    this.offset = offset;
    this.city = city;
  }

  public int getOffset() {
    return offset;
  }

  public int getLocaltime() {
    return localtime;
  }

  public void setLocaltime(int localtime) {
    this.localtime = localtime;
  }

  @Override
  public String toString() {
    return String.format("%s - %d:00", city, this.getLocaltime());
  }
}
