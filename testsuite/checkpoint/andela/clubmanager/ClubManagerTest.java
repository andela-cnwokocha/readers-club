package checkpoint.andela.clubmanager;

import checkpoint.andela.main.Book;
import checkpoint.andela.member.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by chidi on 11/27/15.
 */
public class ClubManagerTest {

  @Test
  public void testGetLibrarySize() throws Exception {
    ClubManager club = new ClubManager();
    Book book1 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");

    club.addBookToList(book1);
    club.addBookToList(book2);

    assertEquals(club.getLibrarySize(), 2);
    assertEquals(club.getLibrarySize(), 2);
  }

  @Test
  public void testGetNumberOfMembers() throws Exception {
    ClubManager club = new ClubManager();
    Staff staff1 = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Student student = new Student("Yosin", 'F', "51 09", "0800108333", "06", "JSS3");
    club.addMemberToList(staff1);
    club.addMemberToList(student);
    assertEquals(club.getNumberOfMembers(), 2);
  }

  @Test
  public void testAddBookToList() throws Exception {
    ClubManager club = new ClubManager();
    Book book1 = new Book("ThisBook1", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("ThisBook2", "Ikeme", 12, "ISBN-4543-455-533-43");
    club.addBookToList(book1);
    club.addBookToList(book2);

    assertEquals(club.getLibrarySize(), 2);
  }

  @Test
  public void testAddMemberToList() throws Exception {
    ClubManager club = new ClubManager();
    Staff staff1 = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Yosin", 'F', "51 09", "0800108333", 06);

    club.addMemberToList(staff1);
    club.addMemberToList(staff2);
    assertEquals(club.getNumberOfMembers(), 2);
  }

  @Test
  public void testGetSizeOfQueue() throws Exception {
    ClubManager club = new ClubManager();

  }

  @Test
  public void testAddMemberToQueue() throws Exception {
    ClubManager club = new ClubManager();
    Book book = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");

    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    staff.borrowBook(book);

    club.addMemberToQueue(staff);

    assertEquals(club.firstQueueMember("ThisBook"), "Tochi");

  }

  @Test
  public void testGetFirstQueueMember() throws Exception {
    ClubManager club = new ClubManager();
    Book book = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");

    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    staff.borrowBook(book);

    club.addMemberToQueue(staff);

    assertEquals(club.firstQueueMember("ThisBook"), "Tochi");
  }
}