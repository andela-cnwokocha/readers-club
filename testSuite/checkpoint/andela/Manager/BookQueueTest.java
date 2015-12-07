package checkpoint.andela.Manager;

import checkpoint.andela.main.*;
import checkpoint.andela.members.*;
import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

/**
 * Created by chidi on 12/6/15.
 */
public class BookQueueTest {

  @Test
  public void testAddToQueue() throws Exception {
    Staff staff = new Staff("Taolu", 'M', "21 09", "0800108333", 56);
    Student student = new Student("Banjo Oladimeji", 'M', "23-14-1987", "0907657353", 18,"ss2");
    BookQueue aBooksQueue = new BookQueue();

    aBooksQueue.addToQueue(staff);
    aBooksQueue.addToQueue(student);
    assertTrue(aBooksQueue.getBookQue().size() == 2);
  }

  @Test
  // Logic : if a book queue is returned, then i can pass it to a variable and access what is inside it
  public void testGetBookQue() throws Exception {
    BookQueue aBooksQueue = new BookQueue();
    Staff staff = new Staff("Rooney", 'M', "21 09 1988", "0800108333", 56);
    Student student = new Student("Banjo Oladimeji", 'M', "23-14-1987", "0907657353", 18,"ss2");

    aBooksQueue.addToQueue(staff);
    aBooksQueue.addToQueue(student);

    PriorityQueue<Member> aQueue = aBooksQueue.getBookQue();
    Member member = aQueue.peek();

    assertTrue(member.getName() == "Rooney");
    assertEquals(aQueue.size(), 2);
  }

  // The following tests, tests if a queue is properly sorted
  @Test
  /*The first entry into the queue is a new staff before an old staff*/
  public void testForNewStaffAndOldStaff() throws Exception {
    BookQueue aBooksQueue = new BookQueue();

    Staff staff1 = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
    Staff staff2 = new Staff("Chidosge Amadi", 'M', "24th January 1994", "08162082773", 5);
    Staff staff3 = new Staff("Niru Baba", 'M', "24th January 1994", "08162082773", 75);
    Thread.sleep(300);
    staff1.setDateOfReg();

    aBooksQueue.addToQueue(staff1);
    aBooksQueue.addToQueue(staff2);
    aBooksQueue.addToQueue(staff3);

    Member firstPriorityMember = aBooksQueue.getBookQue().remove();
    Member secondPriorityMember = aBooksQueue.getBookQue().remove();

    assertEquals(firstPriorityMember.getName(), "Chidosge Amadi");
    assertEquals(secondPriorityMember.getName(), "Niru Baba");
  }

  @Test
  /*The first entry into the queue is an old staff before a new staff*/
  public void testForOldStaffAndNewStaff() throws Exception {
    BookQueue aBooksQueue = new BookQueue();

    Staff staff1 = new Staff("Chidinma Ng", 'M', "24th January 1998", "08162082773", 34);
    Thread.sleep(300);
    Staff staff2 = new Staff("Chidosge Amadi", 'M', "24th January 1994", "08162082773", 75);

    aBooksQueue.addToQueue(staff1);
    aBooksQueue.addToQueue(staff2);

    Member firstPriorityMember = aBooksQueue.getBookQue().peek();

    assertTrue(aBooksQueue.getBookQue().size() == 2);
    assertEquals(firstPriorityMember.getName(), "Chidinma Ng");
  }

  @Test
  public void testForStaffAndStudent() throws Exception{
    BookQueue aBooksQueue = new BookQueue();

    Staff staff = new Staff("Chidosge Amadi", 'M', "24th January 1994", "08162082773", 75);
    Student student = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", 8, "JSS1");

    aBooksQueue.addToQueue(staff);
    aBooksQueue.addToQueue(student);

    Member firstPriorityMember = aBooksQueue.getBookQue().peek();

    assertEquals(firstPriorityMember.getName(), "Chidosge Amadi");
  }

  @Test
  // The first entry into the queue is a new student before an old student
  public void testForNewStudentAndOldStudent() throws Exception {
    BookQueue aBooksQueue = new BookQueue();

    Student student1 = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", 17, "JSS1");
    Thread.sleep(300);
    Student student2 = new Student("Dare wokocha", 'F', "24th January 1994", "08162082773", 07, "JSS1");

    aBooksQueue.addToQueue(student2);
    aBooksQueue.addToQueue(student1);

    Member firstPriorityMember = aBooksQueue.getBookQue().peek();

    assertEquals(firstPriorityMember.getName(), "Chidiebere Justice Nwokocha");
  }

  @Test
  // The first entry into the queue is an old student before a new student
  public void testForOldStudentAndNewStudent() throws Exception {
    BookQueue aBooksQueue = new BookQueue();

    Student student1 = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", 12, "JSS1");
    Thread.sleep(300);
    Student student2 = new Student("Dare wokocha", 'F', "24th January 1994", "08162082773", 56, "JSS1");

    aBooksQueue.addToQueue(student1);
    aBooksQueue.addToQueue(student2);

    Member firstPriorityMember = aBooksQueue.getBookQue().peek();

    assertEquals(firstPriorityMember.getName(), "Chidiebere Justice Nwokocha");
  }

  @Test
  public void testIfMemberIsQueueItem() throws Exception {
    BookQueue aBooksQueue = new BookQueue();

    Student student1 = new Student("Chidiebere Justice Nwokocha", 'F', "24th January 1994", "08162082773", 12, "JSS1");
    Student student2 = new Student("Dare wokocha", 'F', "24th January 1994", "08162082773", 56, "JSS1");
    Student student3 = new Student("Daberechi Amaka", 'F', "24th January 1994", "08162082773", 10, "JSS1");

    aBooksQueue.addToQueue(student1);
    aBooksQueue.addToQueue(student2);

    assertTrue(aBooksQueue.isQueueItem(student1));
    assertFalse(aBooksQueue.isQueueItem(student3));
    assertTrue(aBooksQueue.getSizeOfQueue() == 2);
  }
}