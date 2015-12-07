package checkpoint.andela.members;

import checkpoint.andela.main.*;
/**
 * Created by chidi on 12/3/15.
 */
public class Staff extends Member {
  private Integer staffNumber;

  public Staff(String fullName, char gender, String dateOfBirth, String phoneNumber, Integer identityNumber) {
    super(fullName, gender, dateOfBirth, phoneNumber);
    this.staffNumber = identityNumber;
  }

  public void setStaffNumber(Integer staffnumber) {
    this.staffNumber = staffnumber;
  }

  public int getIdentityNumber() {
    return this.staffNumber;
  }
}
