package checkpoint.andela.clubmanager;
import checkpoint.andela.main.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chidi on 11/26/15.
 */
public class ClubManager {
  private ArrayList<Book> books;
  private ArrayList <Member> members;

  public ClubManager() {
    books = new ArrayList<Book>();
    members = new ArrayList<Member>();
  }

  // Get the number of books in the library
  public int getLibrarySize() {
    return this.books.size();
  }

  // Add a book to the book list
  public void addBookToLibrary(Book book) {
    this.books.add(book);
  }

}
