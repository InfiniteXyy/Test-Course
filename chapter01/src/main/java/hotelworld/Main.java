package hotelworld;


import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Handler handlerObj = new ConsoleHandler();
    handlerObj.setLevel(Level.ALL);
    LOGGER.addHandler(handlerObj);
    LOGGER.setLevel(Level.ALL);
    LOGGER.setUseParentHandlers(false);
    try {
      HotelSystem system = HotelSystem.newDemoInstance();
      PhoneClock phoneClock = new PhoneClock(8);
      phoneClock.bindSystem(system);
      phoneClock.setTime(10);
      LOGGER.log(Level.INFO, system.getDetail());
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, e.getMessage());
    }
  }
}
