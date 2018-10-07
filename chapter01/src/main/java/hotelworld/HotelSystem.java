package hotelworld;

import java.util.ArrayList;
import java.util.List;

public class HotelSystem {

  private int standardTime;

  private List<CityClock> clocks;

  public static HotelSystem newDemoInstance() {
    HotelSystem hotelSystem = new HotelSystem();
    hotelSystem.pushClock(new CityClock(0, "London"));
    hotelSystem.pushClock(new CityClock(4, "Moscow"));
    hotelSystem.pushClock(new CityClock(8, "Beijing"));
    hotelSystem.pushClock(new CityClock(10, "Sydney"));
    hotelSystem.pushClock(new CityClock(-5, "New York"));
    return hotelSystem;
  }

  public HotelSystem() {
    this.clocks = new ArrayList<>();
    this.standardTime = 0;
  }

  public void pushClock(CityClock cityClock) {
    this.clocks.add(cityClock);
  }

  public void setStandardTime(int time) {
    standardTime = time;
    for (CityClock cityClock : clocks) {
      int localtime = standardTime + cityClock.getOffset();
      cityClock.setLocaltime((localtime + 24) % 24);
    }
  }

  public int getStandardTime() {
    return standardTime;
  }

  public List<CityClock> getClocks() {
    return clocks;
  }

  public String getAllClocksDetail() {
    StringBuilder output = new StringBuilder();
    output.append("::HAHA Hotel::\n");
    output.append(String.format("::%d city clocks::", clocks.size()));
    output.append("\n");
    for (int i = 0; i < clocks.size(); i++) {
      output.append(String.format("%d: %s", (i + 1), clocks.get(i)));
      output.append("\n");
    }
    return output.toString();
  }
}
