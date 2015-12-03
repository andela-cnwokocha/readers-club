package checkpoint.andela.clubmanager;
import checkpoint.andela.main.*;
import checkpoint.andela.member.Staff;
import checkpoint.andela.member.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Created by chidi on 11/26/15.
 */
public class ClubManager {
  private ArrayList<Book> books;
  private ArrayList <Member> members;
  List<BookQueue> borrowedBooks = new ArrayList<BookQueue>();

  public ClubManager() {
    books = new ArrayList<Book>();
    members = new ArrayList<Member>();
  }

  // Get the number of books in the library
  public int getNumberOfBooks() {
    return books.size();
  }

  // Get the number of members in the club
  public int getNumberOfMembers() {
    return members.size();
  }

  // Add a book to the book list
  public void addBook(Book book) {
    this.books.add(book);
  }

  // Add a member to the member list
  public void addMember(Member member) {
    members.add(member);
  }

  // Get the size of the queue
  public int getNumberOfBorrowedBooks() {
    return borrowedBooks.size();
  }

  // Let member borrow book
  public void addMemberToQueue(Member member, Book book) {
    BookQueue aBooksQueue = new BookQueue();
    books.add(book);
    if(borrowedBooks.size() >= 1){
      borrowedBooks.get(0).addToQueue(member);
    }else {
      aBooksQueue.addToQueue(member);
      borrowedBooks.add(aBooksQueue);
    }
  }

  // this returns the size of the bookqueue in the borrowedbooklist
  public int getQueueSize(){
    int size = 0;
    if(!borrowedBooks.isEmpty()){
      BookQueue aBooksQueue = borrowedBooks.get(0);
      size = aBooksQueue.getQueueSize();
    }
    return size;
  }

  // Give book to member
  public String giveOutBook() {
    Member member = null;
    if(borrowedBooks.size() == 1){
      BookQueue bookQueue = borrowedBooks.get(0);
      member = bookQueue.takeOutMember();
      Book bookBorrowed = member.getBookBorrowed();
      bookBorrowed.decrementBookCopies();
    }
    return member.getName();
  }

}
