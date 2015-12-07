package checkpoint.andela.main;

import java.util.ArrayList;
import java.util.Date;
import checkpoint.andela.Manager.*;

/**
 * Created by chidi on 12/3/15.
 */
abstract public class Member {
  private String fullName;
  private char gender;
  private String dateOfBirth;
  private String phoneNumber;
  private Date dateOfReg;
  private ArrayList<String> booksBorrowed;


  public Member(String fullName, char gender, String dateOfBirth, String phoneNumber) {
    this.fullName = fullName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.dateOfReg = new Date();
  }

  public String getName() {
    return fullName;
  }
  public void setName(String memberName) {
    this.fullName = memberName;
  }
  public void setDateOfReg() {
    dateOfReg = new Date();
  }
  public Date getDateOfReg() {
    return dateOfReg;
  }
  public void setGender(char gender) {
    this.gender = gender;
  }
  public char getGender() {
    return gender;
  }
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  public String getDateOfBirth() {
    return dateOfBirth;
  }
  public void setPhoneNumber(String phonenumber) {
    this.phoneNumber = phonenumber;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setBooksBorrowed(ArrayList<String> booksborrowed) {
    this.booksBorrowed = booksborrowed;
  }
  public ArrayList<String> getBooksBorrowed() {
    return booksBorrowed;
  }
  public void addBorrowedBook(String bookName){
    booksBorrowed.add(bookName);
  }
  public abstract int getIdentityNumber();
  public int getNumberOfBorrowedBooks(){
    return this.booksBorrowed.size();
  }

  public void makeBookRequest(Book book, ClubManager club){
    club.addMemberToBookRequest(book, this);
  }
  public void returnBook(Book book, ClubManager club){
    club.addReturnedBook(this, book);
  }
  public void removeBorrowedBook(String bookName) {
    int bookIndex = booksBorrowed.indexOf(bookName);
    booksBorrowed.remove(bookIndex);
  }
  public boolean collectRequestedBook(Book book, ClubManager club) {
    return club.lendBookToMember(this, book);
  }
}
