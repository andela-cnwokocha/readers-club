package checkpoint.andela.main;

/**
 * Created by chidi on 12/3/15.
 */
public class Book {
  private String bookName;
  private String author;
  private Integer numberOfBookCopies = 0;
  private String isbnNumber;

  public Book(String bookName, String author, int numberofbookcopies, String isbnNumber) {
    this.bookName = bookName;
    this.author = author;
    this.numberOfBookCopies = numberofbookcopies;
    this.isbnNumber = isbnNumber;
  }

  private void setBookName(String bookName) {
    this.bookName = bookName;
  }
  public String getBookName() {
    return bookName;
  }
  private void setAuthor(String author) {
    this.author = author;
  }
  public String getAuthor() {
    return author;
  }
  private void setBookCopies(Integer numbOfBookCopies) {
    this.numberOfBookCopies = numbOfBookCopies;
  }
  public int getNumberOfBookCopies() {
    return numberOfBookCopies;
  }
  private void setIsbnNumber(String isbnNumber) {
    this.isbnNumber = isbnNumber;
  }
  public String getIsbnNumber() {
    return isbnNumber;
  }
  public void incrementBookCopies() {
    numberOfBookCopies++;
  }
  public void decrementBookCopies() {
    if(this.numberOfBookCopies > 0)
      numberOfBookCopies--;
  }
}
