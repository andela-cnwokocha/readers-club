package checkpoint.andela.clubmanager;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.member.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

    club.addBook(book1);
    club.addBook(book2);

    assertEquals(club.getNumberOfBooks(), 2);
  }

  @Test
  public void testGetNumberOfMembers() throws Exception {
    ClubManager club = new ClubManager();
    Staff staff1 = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Student student = new Student("Yosin", 'F', "51 09", "0800108333", "06", "JSS3");

    club.addMember(staff1);
    club.addMember(student);

    assertEquals(club.getNumberOfMembers(), 2);
  }

  @Test
  public void testIfaMemberIsAddedMoreThanOnce() throws Exception {
    ClubManager club = new ClubManager();

    Staff staff1 = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    Student student = new Student("Yosin", 'F', "51 09", "0800108333", "06", "JSS3");

    club.addMember(staff1);
    club.addMember(staff1);
    club.addMember(student);
    club.addMember(student);

    assertEquals(club.getNumberOfMembers(), 2);
  }

  @Test
  public void testIfaBookIsAddedToTheListMoreThanOnce() throws Exception {
    ClubManager club = new ClubManager();

    Book book = new Book("Things Fall Apart", "Ikeme", 12, "ISBN-4543-455-533-43");
    club.addBook(book);
    club.addBook(book);

    assertEquals(club.getLibrarySize(), 1);
  }

  @Test
  //Tests if a book queue can be added to the list of borrowed books
  public void testAddMemberToQueue() throws Exception {
    ClubManager club = new ClubManager();

    Book book = new Book("Things Fall Apart", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("Things Fall Apart", "Ikeme", 12, "ISBN-4543-455-533-43");
    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);

    club.addBook(book);
    club.addBook(book2);
    club.addMember(staff);

    club.addMemberToQueue(staff, book);

    assertTrue(club.getQueueSize(book) == 1);
    assertTrue(club.getQueueSize(book2) == 0)
  }

  @Test
  // Tests if more than one member can be added to queues for different borrowed books
  public void testAddingMembersToQueues() throws Exception {
    ClubManager club = new ClubManager();
    Book book1 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book3 = new Book("ThisBook one", "Ikeme", 12, "ISBN-4543-455-533-43");

    club.addBook(book1);
    club.addBook(book2);
    club.addBook(book3);


    Staff staff1 = new Staff("Tochi", 'F', "51 09", "0800108333", 80);
    Staff staff3 = new Staff("Bosun", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Yosin", 'F', "51 09", "0800108333", 12);
    Student student1 = new Student("Alapa", 'F', "51 09", "0800108333", "05", "JSS3");
    Student student2 = new Student("Chidi", 'F', "51 09", "0800108333", "03", "JSS3");
    Student student3 = new Student("Bayero", 'F', "51 09", "0800108333", "02", "JSS3");

    // registers member to the club if not already registered.
    club.addMember(staff1);
    club.addMember(staff2);
    club.addMember(staff3);
    club.addMember(student1);
    club.addMember(student2);
    club.addMember(student3);

    club.addMemberToBookRequest(staff1, book1);
    club.addMemberToQueue(staff2, book2);
    club.addMemberToQueue(staff3, book2);
    club.addMemberToQueue(student1, book1);
    club.addMemberToQueue(student2, book2);
    club.addMemberToQueue(student3, book1);

    assertTrue(club.getNumberOfBorrowedBooks() == 2);
    assertTrue(club.getLibrarySize() == 2);
    assertTrue(club.getNumberOfMembers() == 6);
  }

  @Test
  public void testIfUnavailableBookCanBeBorrowed() throws Exception {
    ClubManager club = new ClubManager();
    Book book = new Book("Cannon boy", "Ikeme", 12, "ISBN-4543-455-533-43");

    Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    club.addMember(staff);

    club.addMemberToQueue(staff, book);

    assertFalse(club.getQueueSize() == 1);
  }

  @Test
  public void testAddingListOfBooks() throws Exception {
    ClubManager mamsClub = new ClubManager();
    ClubManager papsClub = new ClubManager();
    ClubManager childrensClub = new ClubManager();

    Book book1 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book2 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book3 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");
    Book book4 = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");

    mamsClub.addBook(book1);
    papsClub.addBook(book2);
    mamsClub.addBook(book3);
    childrensClub.addBook(book4);

    childrensClub.addBook(mamsClub.getListOfBooks());
    childrensClub.addBook(papsClub.getListOfBooks());

    assertSame(childrensClub.getLibrarySize(), 4);
  }

  @Test
  public void testAddingListOfMembers() throws Exception {
    ClubManager rhodesClub = new ClubManager();
    ClubManager pharoahsClub = new ClubManager();
    ClubManager syrusClub = new ClubManager();

    Staff staff1 = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    Staff staff3 = new Staff("Bosun", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Tope", 'F', "51 09", "0800108333", 06);
    Student student1 = new Student("Alapa", 'F', "51 09", "0800108333", "06", "JSS3");
    Student student2 = new Student("Chidi", 'F', "51 09", "0800108333", "06", "JSS3");
    Student student3 = new Student("Bayero", 'F', "51 09", "0800108333", "06", "JSS3");

    rhodesClub.addMember(staff1);
    rhodesClub.addMember(staff2);
    pharoahsClub.addMember(student1);
    pharoahsClub.addMember(student2);
    syrusClub.addMember(staff3);
    syrusClub.addMember(student3);

    syrusClub.addMember(rhodesClub.getListOfMembers());
    syrusClub.addMember(pharoahsClub.getListOfMembers());

    assertSame(syrusClub.getNumberOfMembers(), 6);
  }

  @Test
  public void testLendBookToMember() throws Exception {
    ClubManager rhodesClub = new ClubManager();
    Book book = new Book("Cannon boy", "Ikeme", 3, "ISBN-4543-455-533-43");

    Staff staff1 = new Staff("Tochi", 'F', "51 09", "0800108333", 06);
    Staff staff2 = new Staff("Bosun", 'M', "21 09", "0800108333", 56);
    Student student1 = new Student("Chidi", 'F', "51 09", "0800108333", "06", "JSS3");
    Student student2 = new Student("Bayero", 'F', "51 09", "0800108333", "06", "JSS3");

    // array of members to be added to the list of members
    ArrayList<Member> members = new ArrayList<Member>(4);
    members.add(staff1);
    members.add(staff2);
    members.add(student2);
    members.add(student1);
    Thread.sleep(200);
    staff1.setDateOfReg();
    student2.setDateOfReg();


    rhodesClub.addMember(members);
    rhodesClub.addBook(book);

    rhodesClub.addMemberToQueue(staff1, book);
    rhodesClub.addMemberToQueue(staff2, book);
    rhodesClub.addMemberToQueue(student1, book);
    rhodesClub.addMemberToQueue(student2, book);

    assertTrue(rhodesClub.giveOutBook(student1, book) == false);
    assertTrue(rhodesClub.giveOutBook(staff2, book) == true);
    assertTrue(rhodesClub.giveOutBook(staff1, book) == true);
    assertTrue(book.getNumberOfBookCopies() == 0);
  }
}