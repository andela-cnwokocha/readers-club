package checkpoint.andela.member;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by chidi on 11/27/15.
 */
public class StaffTest {

  @Test
  public void testCurrentDate() throws Exception {
    Staff staff = new Staff("Tosin", 'M', "21 09", "0800108333", 56, "itcould happen");
    Date now = new Date();
    assertEquals(staff.currentDate(), now);
  }
}