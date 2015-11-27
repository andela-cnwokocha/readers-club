package checkpoint.andela.clubmanager;
import checkpoint.andela.main.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.nio.file.Paths;

/**
 * Created by chidi on 11/26/15.
 */
public class ClubManager {
  private ArrayList<Book> books;
  private ArrayList <Member> members;
  private String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();

  public ClubManager() {
    books = new ArrayList<Book>();
    members = new ArrayList<Member>();
  }

  // Get the number of books in the library
  public int getLibrarySize() {
    return this.books.size();
  }

  // Add a book to the book list
  public boolean addBookToLibrary(Book book) {
    boolean isAddedSuccessfully = false;
    String bookName = book.getBookName();
    boolean fileExists = new File(currentDirectory, bookName + ".txt").exists();
    if(!fileExists){
      boolean isFileCreated = this.makeAboutBookFile(bookName);
      if(isFileCreated) {
        this.books.add(book); // add book to the library
        File createdFile = new File(currentDirectory + "/" + bookName + ".txt"); // create file connection
        BufferedWriter bufferedWriter = null; // connect to bufferedwriter
        String detailsToWrite = "Chidi did it"; // Detailed book info to write
        try {
          FileWriter fileWriter = new FileWriter(createdFile, true);
          bufferedWriter = new BufferedWriter(fileWriter);
          bufferedWriter.write("Author: " + book.getAuthor());
          PrintWriter printWriter = new PrintWriter(bufferedWriter);
          printWriter.println("");
          printWriter.println("Rating: ");
          printWriter.println("Book Info: " + detailsToWrite);
          printWriter.close();
          isAddedSuccessfully = true;
          System.out.println("Chidi did it");
        }catch(IOException ioe) {
          ioe.printStackTrace();
        }
      }
    }
    return isAddedSuccessfully;
  }

  // create a file with details of the book
  private boolean makeAboutBookFile(String bookName) {
    boolean isCreated = false;
    try{
      File file = new File(currentDirectory + "/" + bookName + ".txt");
      isCreated = file.createNewFile();
    }catch(IOException ioe) {
      ioe.printStackTrace();
    }
    return isCreated;
  }

  // Write details of file to the file
  private void addBookInfo(File bookInfoFile) {

  }


}
