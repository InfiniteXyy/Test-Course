package hotelworld;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CityClockTest {

  private CityClock cityClock;

  @Before
  public void setUp() throws Exception {
    cityClock = new CityClock(1, "Test");
  }

  @Test
  public void getTime() {
    assertEquals(1, cityClock.getTime());
    Clock.setUTCTime(1);
    assertEquals(2, cityClock.getTime());

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