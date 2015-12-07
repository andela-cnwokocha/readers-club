package checkpoint.andela.Manager;

import java.util.Comparator;

import checkpoint.andela.main.*;
import checkpoint.andela.members.*;

/**
 * Created by chidi on 12/3/15.
 */

public class MembersComparator implements Comparator<Member> {
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