package checkpoint.andela.clubmanager;
import java.lang.reflect.Member;
import java.util.Comparator;
import java.util.PriorityQueue;
import checkpoint.andela.member.*;
/**
 * Created by chidi on 11/28/15.
 */
public class BookQueue {
  private PriorityQueue<Member> bookQue;

  public BookQueue () {
    bookQue = new PriorityQueue<>();
  }

}
