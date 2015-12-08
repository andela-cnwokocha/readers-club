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
    Staff staff2 = new Staff("Roja", 'M', "51 09", "0800108333", 15);

    club.addMember(staff);
    club.addMember(staff2);
    club.addBook(book1);
    club.addBook(book2);

    club.addMemberToBookRequest(book1, staff);
    club.addMemberToBookRequest(book1, staff2);

    assertSame(club.getNumberOfBorrowedBooks(), 1);
    assertSame(club.getNumberOfMembers(), 2);
    assertTrue(club.getBookRequestSize(book1) == 2);
    Member member = club.lendBookToMember(book1);
    assertTrue(member.getIdentityNumber()==80);
    Member nextMember = club.lendBookToMember(book1);
    assertTrue(nextMember.getIdentityNumber()==15);

  }

  @Test
  public void testBookBorrow() throws Exception {
    ClubManager club = new ClubManager();
    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 80);
    Book book1 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4556-455-533-43");
    Book book2 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4455-533-43");
    staff.setStaffNumber(5);

    club.addMember(staff);
    club.addBook(book1);
    club.addBook(book2);

    club.addMemberToBookRequest(book1, staff);
    club.addMemberToBookRequest(book2, staff);

    assertFalse(club.getNumberOfBorrowedBooks() == 3);
    assertTrue(club.getNumberOfBorrowedBooks() == 2);
    assertTrue(staff.getIdentityNumber() == 5);
  }

}