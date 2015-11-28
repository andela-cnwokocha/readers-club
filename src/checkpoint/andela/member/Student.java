package checkpoint.andela.member;

import checkpoint.andela.main.Member;

/**
 * Created by chidi on 11/27/15.
 */
public class Student extends Member {
  private String studentID;
  private String schoolClass;

  public Student(String fullname, char gender, String dateofbirth, String phoneNumber, String studentID, String classroom) {
    super(fullname, gender, dateofbirth, phoneNumber);
    this.studentID = studentID;
    this.schoolClass = classroom;
  }

  // Get StudentID
  public String getStudentID() {
    return studentID;
  }
  // Set StudentID
  public void setStudentID(String studentid) {
    studentID = studentid;
  }

  // Get the Student's class
  public String getStudentClass() {
    return schoolClass;
  }
  // Set Student's class
  public void setStudentClass(String studentclass) {
    schoolClass = studentclass;
  }
}
