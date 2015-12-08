package checkpoint.andela.Manager;

import checkpoint.andela.main.*;
import java.util.*;

/**
 * Created by chidi on 12/6/15.
 */
public class BookQueue {
  private PriorityQueue<Member> bookQue;

  public BookQueue() {
    Comparator compareMembers = new MembersComparator();
    this.bookQue = new PriorityQueue<Member>(10, compareMembers);
  }

  public PriorityQueue<Member> getBookQue() {
    return bookQue;
  }

  public void setBookQueue(PriorityQueue<Member> bookQueue) {
    this.bookQue = bookQueue;
  }

  public void addToQueue(Member member) {
    this.bookQue.add(member);
  }

  public int getSizeOfQueue() {
    return this.bookQue.size();
  }

  public Member getMember(){
     return bookQue.remove();
  }

  public boolean isQueueItem(Member member) {
    boolean isQueueItem = false;
    Iterator<Member> members = this.bookQue.iterator();
    while(members.hasNext()){
      if(members.next().getIdentityNumber()== member.getIdentityNumber()){
        isQueueItem = true;
      }
    }
    return isQueueItem;
  }

}
