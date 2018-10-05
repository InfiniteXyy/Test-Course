package hotelworld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import hotelworld.PhoneClock.NotBindException;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HotelSystemTest {

  private HotelSystem system;
  private PhoneClock phoneClock;

  @Before
  public void setUp() throws Exception {
    system = HotelSystem.newDemoInstance();
    phoneClock = new PhoneClock(8);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void system_standard_clock_should_be_init_at_0() {
    assertEquals(0, system.getStandardTime());
  }

  @Test
  public void demo_system_should_contain_five_city_clocks() {
    assertEquals(5, system.getClocks().size());
  }

  @Test
  public void beijing_time_should_be_9_when_standard_time_is_1() {
    system.setStandardTime(1);
    Optional<CityClock> beijingClock = system.getClocks().stream()
        .filter(item -> item.getCity().equals("Beijing")).findFirst();
    if (!beijingClock.isPresent()) {
      fail("No Beijing clock in demo system");
    }
    assertEquals(9, beijingClock.get().getLocaltime());
  }

  @Test
  public void standard_time_should_be_1_when_phone_clock_is_9() {
    try {
      phoneClock.bindSystem(system);
      phoneClock.setTime(9);
      assertEquals(1, system.getStandardTime());
    } catch (NotBindException e) {
      fail("Phone Clock should bind system correctly");
    }
  }

}