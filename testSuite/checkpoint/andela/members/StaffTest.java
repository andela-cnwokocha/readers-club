package checkpoint.andela.members;

import checkpoint.andela.Manager.*;
import checkpoint.andela.main.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by chidi on 12/7/15.
 */
public class StaffTest {

  @Test
  public void testForMakingBookRequest() throws Exception {
    Book book1 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4556-455-533-43");
    Book book2 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4455-533-43");
    ClubManager club = new ClubManager();
    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 80);

    club.addMember(staff);
    club.addBook(book1);
    club.addBook(book2);
    staff.makeBookRequest(book1, club);
    staff.makeBookRequest(book2, club);

    assertTrue(club.getNumberOfBorrowedBooks() == 2);
  }

}