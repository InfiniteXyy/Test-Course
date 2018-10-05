package hotelworld;


import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  private static HotelSystem initHotel() {
    HotelSystem hotelSystem = new HotelSystem();
    hotelSystem.pushClock(new CityClock(0, "London"));
    hotelSystem.pushClock(new CityClock(4, "Moscow"));
    hotelSystem.pushClock(new CityClock(8, "Beijing"));
    hotelSystem.pushClock(new CityClock(10, "Sydney"));
    hotelSystem.pushClock(new CityClock(-5, "New York"));
    return hotelSystem;
  }

  public static void main(String[] args) {
    Handler handlerObj = new ConsoleHandler();
    handlerObj.setLevel(Level.ALL);
    LOGGER.addHandler(handlerObj);
    LOGGER.setLevel(Level.ALL);
    LOGGER.setUseParentHandlers(false);
    try {
      HotelSystem system = initHotel();
      PhoneClock phoneClock = new PhoneClock(8);
      phoneClock.bindSystem(system);
      phoneClock.setTime(10);
      LOGGER.log(Level.INFO, system.getDetail());
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, e.getMessage());
    }
  }
}
