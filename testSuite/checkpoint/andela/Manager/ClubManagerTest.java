package checkpoint.andela.Manager;

import checkpoint.andela.main.*;
import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;
import checkpoint.andela.members.*;

/**
 * Created by chidi on 12/6/15.
 */
public class ClubManagerTest {

  @Test
  public void testGetLibrarySize() throws Exception {
    ClubManager club = new ClubManager();
    Book book1 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-89");

    club.addBook(book1);
    club.addBook(book2);

    assertEquals(club.getNumberOfBooks(), 2);
  }

  @Test
  public void testGetNumberOfMembers() throws Exception {
    ClubManager club = new ClubManager();
    Staff staff1 = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Student student = new Student("Yosin", 'F', "51 09", "0800108333", 12, "JSS3");

    club.addMember(staff1);
    club.addMember(staff1);
    club.addMember(student);

    assertEquals(club.getNumberOfMembers(), 2);
  }

  @Test
  public void testIfaMemberIsAddedMoreThanOnce() throws Exception {
    ClubManager club = new ClubManager();

    Staff staff1 = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Student student = new Student("Yosin", 'F', "51 09", "0800108333", 13, "JSS3");

    club.addMember(staff1);
    club.addMember(staff2);
    club.addMember(student);
    club.addMember(student);


    assertEquals(club.getNumberOfMembers(), 2);
  }

  @Test
  public void testIfaBookIsAddedToTheListMoreThanOnce() throws Exception {
    ClubManager club = new ClubManager();

    Book book = new Book("Things Fall Apart", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("Things Fall Apart", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book3 = new Book("Things Fall Apart", "Eleme", 12, "ISBN-0000-455-533-43");
    club.addBook(book);
    club.addBook(book);
    club.addBook(book2);
    club.addBook(book3);

    assertEquals(club.getNumberOfBooks(), 2);
  }


  @Test
  //Tests if a book queue can be added to the list of borrowed books
  public void testAddMemberToQueue() throws Exception {
    ClubManager club = new ClubManager();

    Book book = new Book("Things Fall Apart", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("Things Fall Apart", "Ikeme", 12, "ISBN-4543-533-43");
    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    Staff staff2 = new Staff("Tochi", 'F', "51 09", "0800108333", 8);

    club.addBook(book);
    club.addBook(book2);
    club.addMember(staff);
    club.addMember(staff2);

    club.addMemberToBookRequest(book, staff);
    club.addMemberToBookRequest(book, staff2);
    club.addMemberToBookRequest(book2, staff);

    assertTrue(club.getNumberOfBorrowedBooks() == 2);
    assertTrue(club.getBookRequestSize(book) == 2);
    assertTrue(club.getBookRequestSize(book2)== 1);
  }

  @Test
  // Tests if more than one member can be added to queues for different borrowed books
  public void testAddingMembersToQueues() throws Exception {
    ClubManager club = new ClubManager();
    Book book1 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4556-455-533-43");
    Book book2 = new Book("ThisBook one", "Ikeme", 12, "ISBN-443-455-533-43");
    Book book3 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4543-458-533-43");

    club.addBook(book1);
    club.addBook(book2);
    club.addBook(book3);

    Staff staff1 = new Staff("Tochi", 'F', "51 09", "0800108333", 80);
    Staff staff3 = new Staff("Bosun", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Yosin", 'F', "51 09", "0800108333", 12);
    Student student1 = new Student("Alapa", 'F', "51 09", "0800108333", 9, "JSS3");
    Student student2 = new Student("Chidi", 'F', "51 09", "0800108333", 10, "JSS3");
    Student student3 = new Student("Bayero", 'F', "51 09", "0800108333", 11, "JSS3");

    // registers member to the club if not already registered.
    club.addMember(staff1);
    club.addMember(staff2);
    club.addMember(staff3);
    club.addMember(student1);
    club.addMember(student2);
    club.addMember(student3);

    club.addMemberToBookRequest(book1, staff1);
    club.addMemberToBookRequest(book2, staff2);
    club.addMemberToBookRequest(book2, staff3);
    club.addMemberToBookRequest(book1,student1);
    club.addMemberToBookRequest(book2,student2);
    club.addMemberToBookRequest(book1,student3);

    assertTrue(club.getNumberOfBorrowedBooks() == 2);
    assertTrue(club.getBookRequestSize(book2) == 3);
    assertTrue(club.getBookRequestSize(book1) == 3);
    assertTrue(club.getNumberOfMembers() == 6);
  }

  @Test
  public void testIfUnavailableBookCanBeBorrowed() throws Exception {
    ClubManager club = new ClubManager();
    Book book = new Book("Cannon boy", "Ikeme", 12, "ISBN-4543-455-533-43");

    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    club.addMember(staff);

    club.addMemberToBookRequest(book, staff);

    assertFalse(club.getNumberOfBorrowedBooks() == 1);
  }

  @Test
  public void testAddingListOfBooks() throws Exception {
    ClubManager mamsClub = new ClubManager();
    ClubManager papsClub = new ClubManager();
    ClubManager childrensClub = new ClubManager();

    Book book1 = new Book("Thisook", "Ikeme", 12, "ISBN-454-455-533-43");
    Book book2 = new Book("ThiBook", "Ikeme", 12, "ISBN-453-455-533-43");
    Book book3 = new Book("ThisBok", "Ikeme", 12, "ISBN-443-455-533-43");
    Book book4 = new Book("Thiook", "Ikeme", 12, "ISBN-543-455-533-43");

    mamsClub.addBook(book1);
    papsClub.addBook(book2);
    mamsClub.addBook(book3);
    childrensClub.addBook(book4);

    childrensClub.addBooks(mamsClub.getClubBooks());
    childrensClub.addBooks(papsClub.getClubBooks());

    assertSame(childrensClub.getNumberOfBooks(), 4);
  }

  @Test
  public void testAddingListOfMembers() throws Exception {
    ClubManager rhodesClub = new ClubManager();
    ClubManager pharoahsClub = new ClubManager();
    ClubManager syrusClub = new ClubManager();

    Staff staff1 = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    Staff staff3 = new Staff("Bosun", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Tope", 'F', "51 09", "0800108333", 8);
    Student student1 = new Student("Alapa", 'F', "51 09", "0800108333", 5, "JSS3");
    Student student2 = new Student("Chidi", 'F', "51 09", "0800108333", 6, "JSS3");
    Student student3 = new Student("Bayero", 'F', "51 09", "0800108333", 7, "JSS3");

    rhodesClub.addMember(staff1);
    rhodesClub.addMember(staff2);
    pharoahsClub.addMember(student1);
    pharoahsClub.addMember(student2);
    syrusClub.addMember(staff3);
    syrusClub.addMember(student3);

    syrusClub.addMembers(rhodesClub.getClubMembers());
    syrusClub.addMembers(pharoahsClub.getClubMembers());

    assertSame(syrusClub.getNumberOfMembers(), 6);
  }

  @Test
  public void testLendBookToMember() throws Exception {
    ClubManager rhodesClub = new ClubManager();
    Book book = new Book("Cannon boy", "Ikeme", 3, "ISBN-4543-455-533-43");

    Staff staff1 = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    Staff staff2 = new Staff("Bosun", 'M', "21 09", "0800108333", 56);
    Student student1 = new Student("Chidi", 'F', "51 09", "0800108333", 9, "JSS3");
    Student student2 = new Student("Bayero", 'F', "51 09", "0800108333", 10, "JSS3");

    // array of members to be added to the list of members
    Thread.sleep(200);
    staff1.setDateOfReg();
    student2.setDateOfReg();

    rhodesClub.addMember(staff1);
    rhodesClub.addMember(staff2);
    rhodesClub.addMember(student1);
    rhodesClub.addMember(student2);
    rhodesClub.addBook(book);

    rhodesClub.addMemberToBookRequest(book, staff1);
    rhodesClub.addMemberToBookRequest(book, staff2);
    rhodesClub.addMemberToBookRequest(book,student1);
    rhodesClub.addMemberToBookRequest(book, student2);

    assertTrue(rhodesClub.getNumberOfBorrowedBooks() == 1);
    assertTrue(rhodesClub.getBookRequestSize(book)== 4);
    //assertTrue(rhodesClub.lendBookToMember(student1, book));
    /*assertTrue(rhodesClub.lendBookToMember(staff2, book));
    assertTrue(rhodesClub.lendBookToMember(staff1, book));
    assertFalse(rhodesClub.lendBookToMember(student2, book));
    assertTrue(book.getNumberOfBookCopies() == 0);*/
  }


}