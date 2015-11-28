package checkpoint.andela.clubmanager;
//import java.lang.reflect.Member;
import java.util.Comparator;
import java.util.PriorityQueue;
import checkpoint.andela.main.*;
/**
 * Created by chidi on 11/28/15.
 */
public class BookQueue {
  private PriorityQueue<Member> bookQue;

  public BookQueue() {
    Comparator compareMembers = new MemberComparator();
    this.bookQue = new PriorityQueue<Member>(10, compareMembers);
  }

  public PriorityQueue<Member> getBookQue() {
    return this.bookQue;
  }

  public int getQueueSize (){
    return this.bookQue.size();
  }

  public void addToQueue(Member member) {
    if(member.isBookBorrowed()){
      this.bookQue.add(member);
    }
  }

  public String getFirstQueueMember (){
    Member member = this.bookQue.peek();
    return member.getName();
  }
}
