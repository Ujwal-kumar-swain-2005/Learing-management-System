package com.example.model;

public class Student extends User {
    private String studentId;
    private String department;
    private int year;

    public Student() {}

    public Student(int id, String name, String email, String password, String role, String studentId, String department, int year) {
        super(id, name, email, password, role);
        this.studentId = studentId;
        this.department = department;
        this.year = year;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}