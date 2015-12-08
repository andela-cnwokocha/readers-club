package checkpoint.andela.Manager;

import checkpoint.andela.main.*;
import checkpoint.andela.main.Member;
import java.util.*;


/**
 * Created by chidi on 12/6/15.
 */
public class ClubManager {
  ArrayList<Book> clubBooks;
  ArrayList<Member> clubMembers;
  HashMap<String, BookQueue> borrowedBooks;

  public ClubManager () {
    clubBooks = new ArrayList<Book>();
    clubMembers = new ArrayList<Member>();
    borrowedBooks = new HashMap<String, BookQueue>();
  }

  public void addBook(Book book) {
    if(!isClubBook(book)){
      clubBooks.add(book);
    }
  }

  public void addBooks(ArrayList<Book> books) {
    clubBooks.addAll(books);
  }

  public void addMember(Member member) {
    if(!isClubMember(member)) {
      clubMembers.add(member);
    }
  }

  public void addMembers(ArrayList<Member> members) {
    clubMembers.addAll(members);
  }

  public int getNumberOfBooks() {
    return clubBooks.size();
  }

  public int getNumberOfMembers() {
    return clubMembers.size();
  }

  public ArrayList<Book> getClubBooks() {
    return this.clubBooks;
  }

  public ArrayList<Member> getClubMembers() {
    return this.clubMembers;
  }

  public int getNumberOfBorrowedBooks() {
    return borrowedBooks.size();
  }

  public void addMemberToBookRequest(Book book, Member member){
    if(isClubMember(member) && isClubBook(book)){
      String isbnNumber = book.getIsbnNumber();
      if(borrowedBooks.containsKey(isbnNumber)) {
        borrowedBooks.get(isbnNumber).addToQueue(member);
      }else {
        BookQueue bookQueue = new BookQueue();
        bookQueue.addToQueue(member);
        borrowedBooks.put(isbnNumber, bookQueue);
      }
    }
  }

  public int getBookRequestSize(Book book){
    int numberOfBookRequest = 0;
    if(borrowedBooks.containsKey(book.getIsbnNumber()))
      numberOfBookRequest = borrowedBooks.get(book.getIsbnNumber()).getSizeOfQueue();
    return numberOfBookRequest;
  }

  private boolean isClubMember(Member member) {
    boolean isMember = false;
    if(getNumberOfMembers() > 0) {
      for(Member clubMember : clubMembers) {
        if(clubMember.getIdentityNumber() == member.getIdentityNumber())
          isMember = true;
      }
    }
    return isMember;
  }

  private boolean isClubBook(Book book) {
    boolean isClubBook = false;
    if(getNumberOfBooks() > 0) {
      for(Book clubBook : clubBooks) {
        if(clubBook.getIsbnNumber().equals(book.getIsbnNumber()))
          isClubBook = true;
      }
    }
    return isClubBook;
  }

  public boolean lendBookToMember(Member member, Book book){
    boolean isLendingSuccessful = false;
    if(isBookBorrowed(book) && isRequestMade(member, book)){
      Member whoGets = borrowedBooks.get(book.getIsbnNumber()).getMember();
      if(whoGets.getIdentityNumber() == member.getIdentityNumber()){
        decrementBookCopies(book);
        isLendingSuccessful = true;
      }
    }
    return isLendingSuccessful;
  }

  private Boolean isRequestMade(Member member, Book book) {
    Boolean requester = false;
    BookQueue bookRequests = borrowedBooks.get(book.getIsbnNumber());
    for(Member bookrequest : bookRequests.getBookQue()){
      if(bookrequest.getIdentityNumber() == member.getIdentityNumber()){
        requester = true;
        break;
      }
    }
    return requester;
  }

  private boolean isBookBorrowed(Book book){
    return borrowedBooks.containsKey(book.getIsbnNumber());
  }

  private BookQueue getBookRequest(Book book) {
    return borrowedBooks.get(book.getIsbnNumber());
  }

  private void decrementBookCopies(Book book){
    book.decrementBookCopies();
  }

  private void incrementBookCopies(Book book) {book.incrementBookCopies();}

  public void addReturnedBook(Member member, Book book) {
    member.removeBorrowedBook(book.getBookName());
    incrementBookCopies(book);
  }

}
