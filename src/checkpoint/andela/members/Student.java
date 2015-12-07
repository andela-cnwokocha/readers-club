package checkpoint.andela.members;

import checkpoint.andela.main.*;

/**
 * Created by chidi on 12/3/15.
 */
public class Student extends Member{
  private int studentID;
  private String schoolClass;

  public Student(String fullname, char gender, String dateofbirth, String phoneNumber, int studentID, String classroom) {
    super(fullname, gender, dateofbirth, phoneNumber);
    this.studentID = studentID;
    this.schoolClass = classroom;
  }

  public void setStudentID(int studentId) {
    this.studentID = studentId;
  }
  public String getStudentClass() {
    return schoolClass;
  }
  public void setStudentClass(String studentClass) {
    this.schoolClass = studentClass;
  }
  public int getIdentityNumber() {
    return studentID;
  }
}
