package checkpoint.andela.members;

import checkpoint.andela.main.*;

/**
 * Created by chidi on 12/3/15.
 */
public class Student extends Member{
  private int studentid;
  private String schoolclass;

  public Student(String fullname, char gender, String dateofbirth, String phonenumber, int studentid, String classroom) {
    super(fullname, gender, dateofbirth, phonenumber);
    this.studentid = studentid;
    this.schoolclass = classroom;
  }

  public String getStudentClass() {
    return schoolclass;
  }
  public void setStudentClass(String studentclass) {
    this.schoolclass = studentclass;
  }
  public int getIdentityNumber() {
    return this.studentid;
  }
}
