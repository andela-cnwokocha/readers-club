package checkpoint.andela.main;

/**
 * Created by chidi on 11/26/15.
 */
public class Book {
  // set default properties for the class
  private String bookName;
  private String author;
  private Integer numberOfBookCopies = 0;
  private String isbnNumber;

  public Book(String bookName, String author, int numberOfBookCopies, String isbnNumber) {
    this.bookName = bookName;
    this.author = author;
    this.numberOfBookCopies = numberOfBookCopies;
    this.isbnNumber = isbnNumber;
  }

  // Set and Get the name of the book
  private void setBookName(String bookname) {
    this.bookName = bookname;
  }
  public String getBookName() {
    return bookName;
  }

  // Set and Get the author of the book
  private void setAuthor(String author) {
    this.author = author;
  }
  public String getAuthor() {
    return author;
  }

  // Set and Get the number of copies of the book
  private void setBookCopies(Integer numberOfBookCopies) {
    this.numberOfBookCopies = numberOfBookCopies;
  }
  public int getNumberOfBookCopies() {
    return numberOfBookCopies;
  }

  // Set and Get the ISBN number of the book
  private void setIsbnNumber(String isbnNumber) {
    this.isbnNumber = isbnNumber;
  }
  public String getIsbnNumber() {
    return isbnNumber;
  }

  // Increment the number of book copies
  public void incrementBookCopies() {
    numberOfBookCopies++;
  }

  // Decrement the number of book copies
  public void decrementBookCopies() {
    numberOfBookCopies--;
  }
}
