package hotelworld;

import java.util.ArrayList;
import java.util.List;

class HotelSystem {

  private int standardTime;

  private List<CityClock> clocks;

  HotelSystem() {
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

  public String getDetail() {
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
