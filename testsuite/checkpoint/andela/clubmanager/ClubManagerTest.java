package checkpoint.andela.clubmanager;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.member.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

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
  //Tests if a book queue can be added to the list
  public void testAddMemberToQueue() throws Exception {
    ClubManager club = new ClubManager();
    Book book = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");

    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    staff.borrowBook(book);
    club.addMemberToQueue(staff);

    assertFalse(club.getBorrowedBooksList().isEmpty());
    assertTrue(club.getSizeOfBookList() == 1);
  }

  @Test
  // Tests if more than member can be added to the queue of the list of borrowed books
  public void testAddingMembersToQueues() throws Exception {
    ClubManager club = new ClubManager();
    Book book1 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4543-455-533-43");

    Staff staff1 = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    Staff staff3 = new Staff("Bosun", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Yosin", 'F', "51 09", "0800108333", 06);
    Student student1 = new Student("Alapa", 'F', "51 09", "0800108333", "06", "JSS3");
    Student student2 = new Student("Chidi", 'F', "51 09", "0800108333", "06", "JSS3");
    Student student3 = new Student("Bayero", 'F', "51 09", "0800108333", "06", "JSS3");

    staff1.borrowBook(book1);
    student1.borrowBook(book1);
    staff2.borrowBook(book1);
    student2.borrowBook(book1);
    student3.borrowBook(book1);
    staff3.borrowBook(book1);

    club.addMemberToQueue(staff1);
    club.addMemberToQueue(staff2);
    club.addMemberToQueue(staff3);
    club.addMemberToQueue(student1);
    club.addMemberToQueue(student2);
    club.addMemberToQueue(student3);

    assertTrue(club.getSizeOfBookList() == 1);
    assertTrue(club.getQueueSize() == 6);
  }


}