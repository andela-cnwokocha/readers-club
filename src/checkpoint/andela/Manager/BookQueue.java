package checkpoint.andela.Manager;

import checkpoint.andela.main.*;
import java.util.*;

/**
 * Created by chidi on 12/6/15.
 */
public class BookQueue {
  private PriorityQueue<Member> bookque;

  public BookQueue() {
    Comparator compareMembers = new MembersComparator();
    this.bookque = new PriorityQueue<Member>(10, compareMembers);
  }

  public PriorityQueue<Member> getBookQue() {
    return bookque;
  }

  public void addToQueue(Member member) {
    this.bookque.add(member);
  }

  public int getSizeOfQueue() {
    return this.bookque.size();
  }

  public Member getMember(){
     return bookque.remove();
  }

  public boolean isQueueItem(Member member) {
    boolean isQueueItem = false;
    Iterator<Member> members = this.bookque.iterator();
    while(members.hasNext()){
      if(members.next().getIdentityNumber()== member.getIdentityNumber()){
        isQueueItem = true;
      }
    }
    return isQueueItem;
  }

}
