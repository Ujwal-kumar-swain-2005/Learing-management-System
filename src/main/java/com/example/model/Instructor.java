package com.example.model;

public class Instructor extends User {
    private String employeeId;
    private String specialization;

    public Instructor() {}

    public Instructor(int id, String name, String email, String password, String role, String employeeId, String specialization) {
        super(id, name, email, password, role);
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}
