package hotelworld;

import java.util.Arrays;
import java.util.List;

/**
 * @author xuyiyang
 */
class HotelSystem {

  private List<CityClock> clocks;
  private PhoneClock phoneClock = new PhoneClock(8);

  HotelSystem() {
    this.clocks = Arrays.asList(
        new CityClock(0, "London"),
        new CityClock(8, "Beijing"),
        new CityClock(4, "Moscow"),
        new CityClock(10, "Sydney"),
        new CityClock(-5, "New York")
    );
  }

  void start() {
    for (CityClock cityClock : clocks) {
      System.out.println(cityClock);
    }
    phoneClock.setTime(9);

    for (CityClock cityClock : clocks) {
      System.out.println(cityClock);
    }

  }

}
