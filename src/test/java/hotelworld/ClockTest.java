package hotelworld;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class ClockTest {

  @Test
  public void getUTCTime() {
    assertEquals(0, Clock.getUTCTime());
  }

  @Test
  public void setUTCTime() {
    Clock.setUTCTime(1);
    assertEquals(1, Clock.getUTCTime());
  }

  @After
  public void tearDown() throws Exception {
    Clock.setUTCTime(0);
  }
}