package checkpoint.andela.main;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by chidi on 12/3/15.
 */
public class BookTest {

  @Test
  public void testIncrementBookCopies() throws Exception {
    Book book = new Book("The Hermit", "Olu something", 5, "4685-696-4950-595");
    book.incrementBookCopies();
    assertSame(book.getNumberOfBookCopies(), 6);
  }

  @Test
  public void testDecrementBookCopies() throws Exception {
    Book book = new Book("The Hermit", "Olu something", 5, "4685-696-4950-595");
    book.decrementBookCopies();
    assertSame(book.getNumberOfBookCopies(), 4);
  }

  @Test
  public void testZeroOrLessBookDecrement() throws Exception {
    Book book = new Book("The Hermit", "Olu something", 2, "4685-696-4950-595");
    book.decrementBookCopies();
    book.decrementBookCopies();
    book.decrementBookCopies();
    assertSame(book.getNumberOfBookCopies(), 0);
  }
}