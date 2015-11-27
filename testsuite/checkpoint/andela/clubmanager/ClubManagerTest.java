package checkpoint.andela.clubmanager;

import checkpoint.andela.main.Book;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by chidi on 11/26/15.
 */
public class ClubManagerTest {


  @Test
  /* check the number of books in the library */
  public void testGetLibrarySize() throws Exception {
    ClubManager club = new ClubManager();
    Book book = new Book("Ikemefuna", "Chidiebere", 21, "ISBN-5786-686");
    club.addBookToLibrary(book);
    assertEquals(club.getLibrarySize(),1);

  }
   @Test
  //check if a book is added to the book list
  public void testAddBookToLibrary() throws Exception {
     ClubManager club = new ClubManager();
     Book book = new Book("Ikemefuna", "Chidiebere", 21, "ISBN-5786-686");
     Book book2 = new Book("Arrowhead", "Dayo Ajere", 3, "ISBN-576-79-897");
     club.addBookToLibrary(book);
     club.addBookToLibrary(book2);
     assertEquals(club.getLibrarySize(), 2);
  }

  @Test
  // check if an .txt file about the book is created
  public void testCreateAboutBookFile() throws Exception {
    ClubManager club = new ClubManager();
    Book book = new Book("Ikemefuna", "Chidiebere", 21, "ISBN-5786-686");
    try {
      club.addBookToLibrary(book);
      String directory = Paths.get(".").toAbsolutePath().normalize().toString();
      String bookName = book.getBookName();
      boolean fileExists = new File(directory, bookName + ".txt").exists();
      assertTrue(fileExists);
    }catch(Exception e) {
      e.printStackTrace();
    }
  }

}