package checkpoint.andela.clubmanager;

/**
 * Created by chidi on 11/28/15.
 */
import java.util.Comparator;

import checkpoint.andela.main.*;
import checkpoint.andela.member.*;


public class MemberComparator implements Comparator<Member> {

  @Override
  public int compare(Member memberA, Member memberB) {
    if(memberA.getClass() == memberB.getClass()){
      return(memberA.getDateOfReg().compareTo(memberB.getDateOfReg()));
    }else if(memberA instanceof Staff) {
      return -1;
    }else
      return 1;
  }
}
