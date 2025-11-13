package com.example.model;


public class Admin extends User {

    private String adminCode;  

    public Admin() {
        super();
    }
    public Admin(int id, String name, String email, String password, String role, String adminCode) {
        super(id, name, email, password, role);
        this.adminCode = adminCode;
    }

    public Admin(String name, String email, String password, String role, String adminCode) {
        super(0, name, email, password, role); 
        this.adminCode = adminCode;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + getRole() + '\'' +
                ", adminCode='" + adminCode + '\'' +
                '}';
    }
}
