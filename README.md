<img src="https://dl.dropboxusercontent.com/s/cpq8wvg976bqmnf/icon.png?dl=0?raw=1" alt="book clubreadme" align="right" />

#Readers Book club

#### Introduction :books:

In a given readers club, books are distributed to members (Students or Staffs) based on the rank of the requester or the date of registration of the requester. The following conditions applies before a member gets a book;  

> ###### If a Staff and a Student both request for the same book at the same time, the Staff gets the book.  
> ###### If two Staffs request for the same book at the same time, the older Staff (one with an older date of registration)    gets access to the book.  
> ###### If two Students place request for the same book at the same time, the Student who joined the club earlier gets the book.  

This project implements classes that defines properties, and behaviors of the club and its members.  

#### Classes and their Methods 
##### ClubManager class  
 
This is the main class, it manages all possible interaction between books and a club members. This class knows all members and books in the club as it maintains a list of these. It also maintains a list which contains book-queues. A book-queue holds members who requested for a given book.  
** Methods:**
`getNumberOfBooks()` - Returns the number of books in the library.  
`getNumberOfMembers()` - Returns the number of members in the club.  
`addMember(Member member)` - Adds the member to the list of members in the club. Its argument is an object of type Member or its subclasses.  
`addBook(Book book)` - Adds the book to the list of available books. Its takes as argument a Book object.  
`getNumberOfBorrowedBooks()` - Returns the number of book queues in the list of borrowed books. This will be the number of borrowed books.  
`getBookRequestSize(Book book)` - Returns the size of a book-queue. This will be the number of members that requested for a book.  
`addMemberToBookRequest(Member member, Book book)` - This adds a member to a book-queue. Before a member can be added to a book-queue, the member must have borrowed the book. This is like a registered user clicking on a *borrow book* button on a web page/app, the underlying functions (club manager here) then adds the user to a queue for the book. Other methods includes `addBooks, addMembers, getNumberOfBorrowedBooks, isClubMember, isClubBook, addReturnedBook` etc    

```java
ClubManager club = new ClubManager();
Book book = new Book("ThisBook", "Ikeme", 12, "ISBN-4543-455-533-43");
Staff staff = new Staff("Tochi", 'F', "51 09", "0800108333", 06);

staff.borrowBook(book); 

club.addMemberToQueue(staff);
    
```
`giveOutBook()` - This removes a club member from a book queue. This action also reduces the number of available bookcopies of the book that member borrowed. This project currently maintains one book in the borrowed books list, so the first member of the book queue in the borrowed books list is removed, and the number of available copies of the book that member borrowed is reduced. It returns the name of the member who got the book.


##### Member class
   
This class defines behaviors and properties applicable to all club members (Students or Staffs). It is an abstract class extended by the Student and Staff classes.   
** Methods:**
The properties applicable to all members are  the full name, date of birth, date of registration, phone number, and the gender. Hence, the methods defined in this class are mostly getters and setters for these properties. Other methods are   
`makeBookRequest(Book book, ClubManager club)` - allows a member borrow a book.    
`returnBook(Book book, ClubManager club)` - when a book is returned, the number of copies of that book is increased.    
`collectRequestedBook(Book book, ClubManager club)` - returns true if the clubmanager gives the member the requested book.    
Other methods are also defined.

##### Book class

This class defines an available book in the club.  

** Methods: **
Methods are getters and setters of a book's properties, as well as possible actions on these properties.The properties are, the number of available copies of the book, the author, ISBN number and book title.

##### BookQueue class

This class defines a book's queue. It is what is stored in the borrowed books list of the *`ClubManager`* class. When a member borrows a book, that member is pushed to the appropriate book queue for that book. The book queues are sorted based on the comparator implemented by the `MemberComparator` class.

**Methods:**
The following methods are defined  
`getSizeOfQueue()` - returns the size of the queue. This is the number of members in the queue.  
`addToQueue(Member member)` - adds a member to the queue.
`isQueueItem(Member member)`
`getMember()` - removes the first member from the queue, thereby reducing the size of the queue.  

##### MemberComparator  class


This class implements a comparator interface for sorting items on a queue. Members are sorted by their rank (Staff or Student), or date of registration. 

**Method:**  
Overrides the `compare` method of the `Comparator` interface.

##### Staff class

This class is extends `Member` class. It defines extra properties and methods specific to Staff members of the readers club. The extra methods are getters and setters for the staff's identity number.

##### Student class

This class is similar to the Staff class. But unlike the `Staff` class, it defines getters and setters for Student specific properties. These properties includes the Student's Identity number and the student's class.

