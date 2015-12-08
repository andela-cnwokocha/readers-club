package checkpoint.andela.main;

/**
 * Created by chidi on 12/3/15.
 */
public class Book {
  private String bookname;
  private String author;
  private Integer numberofbookcopies = 0;
  private String isbnnumber;

  public Book(String bookname, String author, int numberofbookcopies, String isbnnumber) {
    this.bookname = bookname;
    this.author = author;
    this.numberofbookcopies = numberofbookcopies;
    this.isbnnumber = isbnnumber;
  }

  private void setBookName(String bookname) {
    this.bookname = bookname;
  }

  public String getBookName() {
    return bookname;
  }

  private void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setBookCopies(Integer numbOfbookcopies) {
    this.numberofbookcopies = numbOfbookcopies;
  }

  public int getNumberOfBookCopies() {
    return numberofbookcopies;
  }

  private void setIsbnNumber(String isbnnumber) {
    this.isbnnumber = isbnnumber;
  }

  public String getIsbnNumber() {
    return isbnnumber;
  }

  public void incrementBookCopies() {
    numberofbookcopies++;
  }

  public void decrementBookCopies() {
    if(this.numberofbookcopies > 0)
      numberofbookcopies--;
  }
}
