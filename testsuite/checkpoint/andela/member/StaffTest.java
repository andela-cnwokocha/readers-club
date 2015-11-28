package checkpoint.andela.member;

import checkpoint.andela.main.Book;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by chidi on 11/27/15.
 */
public class StaffTest {

  @Test
  public void testCurrentDate() throws Exception {
    Staff staff = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Date now = new Date();
    assertEquals(staff.currentDate(), now);
  }

  @Test
  public void testBorrowBook() throws Exception {
    Staff staff = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    staff.borrowBook(book);
    assertTrue(staff.getBorrowedBook() =="That guy sef!");
    assertTrue(staff.isBookBorrowed());
  }

  @Test
  public void testGetBorrowedBook() throws Exception {
    Staff staff = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    staff.borrowBook(book);
    assertTrue(staff.getBorrowedBook() == "That guy sef!");
  }

  @Test
  public void testReturnBook() throws Exception {
    Staff staff = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    staff.returnsBook(book);
    assertTrue(staff.getBorrowedBook() =="That guy sef!");
    assertFalse(staff.isBookBorrowed());

  }

}