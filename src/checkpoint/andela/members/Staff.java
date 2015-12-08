package checkpoint.andela.members;

import checkpoint.andela.main.*;
/**
 * Created by chidi on 12/3/15.
 */
public class Staff extends Member {
  private Integer staffnumber;

  public Staff(String fullName, char gender, String dateOfBirth, String phoneNumber, int identitynumber) {
    super(fullName, gender, dateOfBirth, phoneNumber);
    this.staffnumber = identitynumber;
  }

  public void setStaffNumber(Integer staffnumber) {
    this.staffnumber = staffnumber;
  }

  public int getIdentityNumber() {
    return this.staffnumber;
  }

}
