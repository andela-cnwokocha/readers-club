package checkpoint.andela.main;

import java.util.Date;

/**
 * Created by chidi on 11/26/15.
 */
abstract public class Member {
  private String fullName;
  private char gender;
  private String dateOfBirth;
  private String phoneNumber;
  private Date dateOfReg;
  private boolean memberRequestedBook = false;
  private String borrowedBook;
  private Book bookBorrowed;


  public Member(String fullName, char gender, String dateOfBirth, String phoneNumber) {
    this.fullName = fullName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    Date theDate = new Date();
    this.dateOfReg = theDate;
  }

  // Get and Set a member's name
  public String getName() {
    return fullName;
  }
  public void setName(String memberName) {
    this.fullName = memberName;
  }

  // Set and Get a member's date of registration
  public void setDateOfReg() {
    dateOfReg = new Date();
  }
  public Date getDateOfReg() {
    return dateOfReg;
  }

  // Set and Get a member's gender
  public void setGender(char thegender) {
    this.gender = thegender;
  }
  public char getGender() {
    return gender;
  }

  // Set and Get a member's date of birth
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  public String getDateOfBirth() {
    return dateOfBirth;
  }


  // Set and get a member's phone number
  public void setPhoneNumber(String phonenumber) {
    this.phoneNumber = phonenumber;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }

  // Get the current date
  public Date currentDate() {
    Date currentDate = new Date();
    return currentDate;
  }

  public void borrowBook(Book book) {
    memberRequestedBook = true;
    borrowedBook = book.getBookName();
    bookBorrowed = book;
  }

  public void returnsBook(Book book) {
    memberRequestedBook = false;
    borrowedBook = book.getBookName();
    book.incrementBookCopies();
  }

  //Get borrowed book's name
  public String getBorrowedBook(){
    return borrowedBook;
  }

  public boolean isBookBorrowed() {
    return memberRequestedBook;
  }

  public Book getBookBorrowed() {
    return this.bookBorrowed;
  }

}
