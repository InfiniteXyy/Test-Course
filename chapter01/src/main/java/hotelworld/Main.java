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
      // 创建手机对象，并与酒店系统绑定
      PhoneClock phoneClock = new PhoneClock(8);
      phoneClock.bindSystem(system);

      // 通过手机设置时间，查看酒店的所有时钟信息
      phoneClock.setTime(10);
      LOGGER.log(Level.INFO, system.getAllClocksDetail());
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, e.getMessage());
    }
  }
}
