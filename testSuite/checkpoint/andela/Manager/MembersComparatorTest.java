package checkpoint.andela.Manager;

import checkpoint.andela.members.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by chidi on 12/6/15.
 */
public class MembersComparatorTest {

  @Test
  public void minusOneShouldbeReturned() throws Exception{
    try {
      Staff staff1 = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
      Thread.sleep(500);
      Staff staff2 = new Staff("Chidosg", 'M', "24th January 18", "08162082773", 75);

      MembersComparator membercomparator = new MembersComparator();
      assertEquals(membercomparator.compare(staff1, staff2), -1);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Test
  public void testShouldReturnOne() throws Exception {
    try {
      Staff staff1 = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
      Staff staff2 = new Staff("Chidosg", 'M', "24th January 18", "08162082773", 75);
      Thread.sleep(3000);
      staff1.setDateOfReg();

      MembersComparator membercomparator = new MembersComparator();
      assertEquals(membercomparator.compare(staff1, staff2), 1);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Test
  public void zeroShouldBeReturned() throws Exception {
    try {
      Staff staff1 = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
      Staff staff2 = new Staff("Chidosg", 'M', "24th January 18", "08162082773", 75);

      MembersComparator membercomparator = new MembersComparator();
      assertEquals(membercomparator.compare(staff1, staff2), 0);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Test
  public void testShouldReturnMinusOne() throws Exception {
    try {
      Staff staff = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
      Student student = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", 67, "JSS1");

      MembersComparator membercomparator = new MembersComparator();
      assertEquals(membercomparator.compare(staff, student), -1);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Test
  public void OneShouldbeReturned() throws Exception{
    try {
      Staff staff = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
      Student student = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", 67, "JSS1");

      MembersComparator membercomparator = new MembersComparator();
      assertEquals(membercomparator.compare(student, staff), 1);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}