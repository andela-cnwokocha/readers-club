package checkpoint.andela.clubmanager;
import checkpoint.andela.main.*;
import checkpoint.andela.member.Staff;
import checkpoint.andela.member.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Created by chidi on 11/26/15.
 */
public class ClubManager {
  private ArrayList<Book> books;
  private ArrayList <Member> members;
  //private ArrayList<>;

  public ClubManager() {
    books = new ArrayList<Book>();
    members = new ArrayList<Member>();
  }

  // Get the number of books in the library
  public int getLibrarySize() {
    return books.size();
  }

  // Get the number of members in the club
  public int getNumberOfMembers() {
    return members.size();
  }

  // Add a book to the book list
  public void addBookToList(Book book) {
    this.books.add(book);
  }

  // Add a member to the member list
  public void addMemberToList(Member member) {
    members.add(member);
  }

  // Get the size of the queue
  public int getSizeOfQueue() {
    return 0;
  }


}
