package checkpoint.andela.clubmanager;

import checkpoint.andela.main.*;
import checkpoint.andela.member.*;
import checkpoint.andela.clubmanager.BookQueue;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * Created by chidi on 11/28/15.
 */
public class BookQueueTest {

  @Test
  // Logic : if a book queue is returned, then i can pass it to a variable and access what is inside it
  public void testGetBookQue() throws Exception {
    BookQueue aBooksQueue = new BookQueue();
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    Staff staff = new Staff("Tosin", 'M', "21 09", "0800108333", 56);

    staff.borrowBook(book);
    aBooksQueue.addToQueue(staff);

    PriorityQueue<Member> aQueue = aBooksQueue.getBookQue();
    Member member = aQueue.peek();

    assertTrue(member.getName() == "Tosin");
  }

  @Test
  public void testAddToQueue() throws Exception {
    Staff staff = new Staff("Taolu", 'M', "21 09", "0800108333", 56);
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    BookQueue aBooksQueue = new BookQueue();

    staff.borrowBook(book);

    aBooksQueue.addToQueue(staff);

    assertTrue(aBooksQueue.getQueueSize() == 1);
  }

  @Test
  //Test if member can be added to queue if member did not borrow a book
  public void testShouldReturnFalse() throws Exception {
    Staff staff = new Staff("Tosin", 'M', "21 09", "0800108333", 56);
    BookQueue aBooksQueue = new BookQueue();

    aBooksQueue.addToQueue(staff);

    assertFalse(aBooksQueue.getQueueSize() == 1);
  }

  @Test
  public void testGetFirstQueueMember() throws Exception {
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");
    BookQueue aBooksQueue = new BookQueue();

    Staff staff1 = new Staff("Iyabo", 'M', "21 09", "0800108333", 56);
    Staff staff2 = new Staff("Abaka", 'M', "21 09", "0800108333", 56);

    staff1.borrowBook(book);
    staff2.borrowBook(book);

    aBooksQueue.addToQueue(staff1);
    aBooksQueue.addToQueue(staff2);

    assertTrue(aBooksQueue.getFirstQueueMember() == "Iyabo");
  }


  // The following tests, tests if a queue is properly sorted
  @Test
  /*The first entry into the queue is a new staff before an old staff*/
  public void testNewStaffAndOldStaff() throws Exception {
    BookQueue aBooksQueue = new BookQueue();
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");

    Staff staff1 = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
    Staff staff2 = new Staff("Chidosge Amadi", 'M', "24th January 1994", "08162082773", 75);
    Staff staff3 = new Staff("Niru Baba", 'M', "24th January 1994", "08162082773", 75);
    Thread.sleep(300);
    staff1.setDateOfReg();

    staff1.borrowBook(book);
    staff2.borrowBook(book);
    staff3.borrowBook(book);

    aBooksQueue.addToQueue(staff1);
    aBooksQueue.addToQueue(staff2);
    aBooksQueue.addToQueue(staff3);

    assertTrue(aBooksQueue.getQueueSize() == 3);
    assertEquals(aBooksQueue.getFirstQueueMember(), "Chidosge Amadi");
  }

  @Test
  /*The first entry into the queue is an old staff before a new staff*/
  public void testOldStaffAndNewStaff() throws Exception {
    BookQueue aBooksQueue = new BookQueue();
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");

    Staff staff1 = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
    Thread.sleep(300);
    Staff staff2 = new Staff("Chidosge Amadi", 'M', "24th January 1994", "08162082773", 75);

    staff1.borrowBook(book);
    staff2.borrowBook(book);

    aBooksQueue.addToQueue(staff1);
    aBooksQueue.addToQueue(staff2);

    assertTrue(aBooksQueue.getQueueSize() == 2);
    assertEquals(aBooksQueue.getFirstQueueMember(), "Chidinma Ng");
  }

  @Test
  // Tests a Staff and a Student
  public void testStaffAndStudent() throws Exception{
    BookQueue aBooksQueue = new BookQueue();
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");

    Staff staff = new Staff("Chidosge Amadi", 'M', "24th January 1994", "08162082773", 75);
    Student student = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", "67", "JSS1");

    staff.borrowBook(book);
    student.borrowBook(book);

    aBooksQueue.addToQueue(staff);
    aBooksQueue.addToQueue(student);

    assertTrue(aBooksQueue.getQueueSize() == 2);
    assertEquals(aBooksQueue.getFirstQueueMember(), "Chidosge Amadi");
  }

  @Test
  // The first entry into the queue is a new student before an old student
  public void testNewStudentAndOldStudent() throws Exception {
    BookQueue aBooksQueue = new BookQueue();
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");

    Student student1 = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", "67", "JSS1");
    Thread.sleep(300);
    Student student2 = new Student("Dare wokocha", 'F', "24th January 1994", "08162082773", "67", "JSS1");

    student1.borrowBook(book);
    student2.borrowBook(book);

    aBooksQueue.addToQueue(student2);
    aBooksQueue.addToQueue(student1);

    assertEquals(aBooksQueue.getFirstQueueMember(), "Chidiebere Justice Nwokocha");
  }

  @Test
  // The first entry into the queue is an old student before a new student
  public void testOldStudentAndNewStudent() throws Exception {
    BookQueue aBooksQueue = new BookQueue();
    Book book = new Book("That guy sef!", "Chidiebere Justice", 12, "ISBN-5760-6866-8797");

    Student student1 = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", "67", "JSS1");
    Thread.sleep(300);
    Student student2 = new Student("Dare wokocha", 'F', "24th January 1994", "08162082773", "67", "JSS1");

    student1.borrowBook(book);
    student2.borrowBook(book);

    aBooksQueue.addToQueue(student1);
    aBooksQueue.addToQueue(student2);

    assertEquals(aBooksQueue.getFirstQueueMember(), "Chidiebere Justice Nwokocha");
  }

}