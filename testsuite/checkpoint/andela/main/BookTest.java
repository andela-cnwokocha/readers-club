package checkpoint.andela.main;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chidi on 11/26/15.
 */
public class BookTest {

  @Test
  public void testIncrementBookCopies() throws Exception {
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    book.incrementBookCopies();
    assertEquals(book.getNumberOfBookCopies(), 13);
  }

  @Test
  public void testDecrementBookCopies() throws Exception {
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    book.decrementBookCopies();
    assertEquals(book.getNumberOfBookCopies(), 11);
  }
}