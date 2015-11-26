package checkpoint.andela.main;

import java.util.Date;

/**
 * Created by chidi on 11/26/15.
 */
abstract public class Member {
  private String fullName;
  private char gender;
  private String dateOfBirth;
  private String email;
  private String phoneNumber;
  private Date dateOfReg;
  /*private boolean borrowed = false;
  private int aStaff = 0;*/

  public Member(String fullName, char gender, String dateOfBirth, String phoneNumber, String email) {
    this.fullName = fullName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.email = email;
    Date theDate = new Date();
    this.dateOfReg = theDate;
  }

  // Get and Set a member's name
  public String getName() {
    return fullName;
  }
  public void setName(String memberName) {
    this.fullName = memberName;
  }

  // Set and Get a member's date of registration
  public void setDateOfReg() {
    dateOfReg = new Date();
  }
  public Date getDateOfReg() {
    return dateOfReg;
  }

  // Set and Get a member's gender
  public void setGender(char thegender) {
    this.gender = thegender;
  }
  public char getGender() {
    return gender;
  }

  // Set and Get a member's date of birth
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  // Set and Get a Member's email address
  public void setEmail(String email) {
    this.email = email;
  }
  public String getEmail() {
    return email;
  }

  // Set and get a member's phone number
  public void setPhoneNumber(String phonenumber) {
    this.phoneNumber = phonenumber;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }

  // Get the current date
  protected abstract Date currentDate();

}
