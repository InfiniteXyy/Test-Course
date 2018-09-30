package hotelworld;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneClockTest {
  private PhoneClock phoneClock;

  @Before
  public void setUp() throws Exception {
    phoneClock = new PhoneClock(8);
  }

  @Test
  public void getTime() {
    assertEquals(8, phoneClock.getTime());
  }

  @Test
  public void setTime() {
    phoneClock.setTime(9);
    assertEquals(9, phoneClock.getTime());
    assertEquals(1, Clock.UTCTime);
  }
}