package checkpoint.andela.clubmanager;
import checkpoint.andela.main.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.Scanner;

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
        this.books.add(book);
        String author = book.getAuthor();
        int numberOfCopies = book.getNumberOfBookCopies();
        File createdFile = new File(currentDirectory + "/" + bookName + ".txt");
        this.addBookInfo(createdFile, author, numberOfCopies);
        isAddedSuccessfully = true;
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

  // write details of file to a book to its info file
  private void addBookInfo(File bookInfoFile, String author, int numberOfBookCopies) {
    BufferedWriter bufferedWriter = null;
    String detailsToWrite = getBookReview();
    try {
      FileWriter fileWriter = new FileWriter(bookInfoFile, true);
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write("Author: " + author);
      PrintWriter printWriter = new PrintWriter(bufferedWriter);
      printWriter.println("");
      printWriter.println("Rating: ");
      printWriter.println("Available copies: " + numberOfBookCopies);
      printWriter.println("Book Info: " + detailsToWrite);
      printWriter.close();
    }catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  //asks for user review about book and returns it
  private String getBookReview() {
    Scanner reviewScanner = new Scanner(System.in);
    System.out.print("Enter the review please: ");
    String review = reviewScanner.nextLine();
    return review;
  }
}
