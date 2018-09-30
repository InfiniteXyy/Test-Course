package hotelworld;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CityClockTest {

  private CityClock cityClock;

  private PhoneClock phoneClock;

  @Before
  public void setUp() throws Exception {
    cityClock = new CityClock(5, "Test");
    phoneClock = new PhoneClock(1);
  }

  @Test
  public void test_city_time_should_be_5_after_set_phone_clock_to_0() {
    phoneClock.setTime(0);
    assertEquals(4, cityClock.getTime());
  }

  @Test
  public void testToString() {
    assertEquals("Test: 1", cityClock.toString());
  }

  @After
  public void tearDown() throws Exception {
    Clock.setUTCTime(0);
  }
}