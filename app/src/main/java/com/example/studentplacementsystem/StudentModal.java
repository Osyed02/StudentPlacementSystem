package com.example.studentplacementsystem;

public class StudentModal {
    // variables for our studentname,
    // description, tracks and duration, id.
    private String studentName;
    private String studentPassword;
    private String studentId;
    private String studentBranch;
    private  String studentPercentage;
    private int id;

    // creating getter and setter methods
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentBranch() {
        return studentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        this.studentBranch = studentBranch;
    }
    public String getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(String studentPercentage) {
        this.studentPercentage = studentPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public StudentModal(String studentName, String studentPassword, String studentId, String studentBranch, String studentPercentage) {
        this.studentName = studentName;
        this.studentPassword = studentPassword;
        this.studentId = studentId;
        this.studentBranch = studentBranch;
        this.studentPercentage = studentPercentage;
    }
}
