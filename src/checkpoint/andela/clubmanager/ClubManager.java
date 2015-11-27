package checkpoint.andela.clubmanager;
import checkpoint.andela.main.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

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
    String bookName = book.getBookName();
    String directory = Paths.get(".").toAbsolutePath().normalize().toString();
    boolean fileExists = new File(directory, bookName + ".txt").exists();
    if(fileExists){
    }else
      this.makeAboutBookFile(bookName);
  }

  //  create a file with details of the book
  private void makeAboutBookFile(String bookName) {
    try{
      String directory = Paths.get(".").toAbsolutePath().normalize().toString();
      File file = new File(directory + "/" + bookName + ".txt");
      boolean isCreated = file.createNewFile();
    }catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
