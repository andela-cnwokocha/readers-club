package checkpoint.andela.main;

import java.util.ArrayList;
import java.util.Date;
import checkpoint.andela.Manager.*;

/**
 * Created by chidi on 12/3/15.
 */
abstract public class Member {
  private String fullname;
  private char gender;
  private String dateofbirth;
  private String phonenumber;
  private Date dateofreg;


  public Member(String fullname, char gender, String dateofbirth, String phonenumber) {
    this.fullname = fullname;
    this.gender = gender;
    this.dateofbirth = dateofbirth;
    this.phonenumber = phonenumber;
    this.dateofreg = new Date();
  }

  public String getName() {
    return fullname;
  }

  public void setName(String membername) {
    this.fullname = membername;
  }

  public void setDateOfReg() {
    dateofreg = new Date();
  }

  public Date getDateOfReg() {
    return dateofreg;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public char getGender() {
    return gender;
  }

  public void setDateOfBirth(String dateofbirth) {
    this.dateofbirth = dateofbirth;
  }

  public String getDateOfBirth() {
    return dateofbirth;
  }

  public void setPhoneNumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public String getPhoneNumber() {
    return phonenumber;
  }

  public abstract int getIdentityNumber();

}
