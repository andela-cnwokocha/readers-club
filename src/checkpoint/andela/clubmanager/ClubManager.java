package checkpoint.andela.clubmanager;
import checkpoint.andela.main.*;

import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * Created by chidi on 11/26/15.
 */
public class ClubManager {
  private ArrayList<Book> books;
  private ArrayList <Member> members;
  private PriorityQueue <Member> bookRequesters;

  public ClubManager() {
    books = new ArrayList<Book>();
    members = new ArrayList<Member>();
    bookRequesters = new PriorityQueue<Member>();
  }

  // Get the number of books in the library
  public int getLibrarySize() {
    return 0;
  }

  // Get the number of members in the club
  public int getNumberOfMembers() {
    return 0;
  }

  // Add a book to the book list
  public void addBookToList(Book book) {

  }

  // Add a member to the member list
  public void addMemberToList(Member member) {

  }

  // Get the size of the queue
  public int getSizeOfQueue() {
    return 0;
  }

  // Add a member to the queue

}
