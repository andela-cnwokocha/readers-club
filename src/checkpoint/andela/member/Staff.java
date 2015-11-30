package checkpoint.andela.member;
import checkpoint.andela.main.*;
import java.util.Date;
/**
 * Created by chidi on 11/27/15.
 */
public class Staff extends Member {
  private Integer staffNumber;

  // create the Staff subclass from the Member superclass
  public Staff(String fullName, char gender, String dateOfBirth, String phoneNumber, Integer staffNumber) {
    super(fullName, gender, dateOfBirth, phoneNumber);
    this.staffNumber = staffNumber;
  }

  // Get and Set Staff number
  public Integer getStaffNumber() {
    return staffNumber;
  }
  public void setStaffNumber(Integer staffnumber) {
    staffNumber = staffnumber;
  }
}
