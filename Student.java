/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hieudt
 */
public class Student {
   private String studentID;
    private String studentName;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String studentID, String studentName, String semester, String courseName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    
    

    public void display() {
        System.out.printf("%s%30s%30s%30s\n", studentID, studentName, semester, courseName);
    }
    

    
    
    
    
    
}
