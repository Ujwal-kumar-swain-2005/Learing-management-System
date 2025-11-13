package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.DataBase.DBConnection;
import com.example.model.Instructor;

public class InstructorDao {
    private final Connection conn;

    public InstructorDao(Connection conn) {
        this.conn = conn;
    }
    public InstructorDao(){
        this.conn = DBConnection.getConnection();

        if (this.conn == null) {
            System.err.println("❌ [InstructorDao] Database connection is null! Check DBConnection.");
        } else {
            System.out.println("✅ [InstructorDao] Connection established successfully.");
        }
    }
    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS instructor (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "name VARCHAR(255), " +
                     "email VARCHAR(100), " +
                     "password VARCHAR(100), " +
                     "role VARCHAR(50), " +
                     "employeeId VARCHAR(50), " +
                     "specialization VARCHAR(100)" +
                     ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Instructor table created or already exists.");
        }
    }

    public void saveInstructor(Instructor instructor) throws SQLException {
        String sql = "INSERT INTO instructor (name, email, password, role, employeeId, specialization) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instructor.getName());
            stmt.setString(2, instructor.getEmail());
            stmt.setString(3, instructor.getPassword());
            stmt.setString(4, instructor.getRole());
            stmt.setString(5, instructor.getEmployeeId());
            stmt.setString(6, instructor.getSpecialization());
            stmt.executeUpdate();
        }
    }
    public Instructor getInstructor(int id) throws SQLException {
        String sql = "SELECT * FROM instructor WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Instructor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("employeeId"),
                    rs.getString("specialization")
                );
            }
        }
        return null;
    }
    public void updateInstructor(Instructor instructor) throws SQLException {
        String sql = "UPDATE instructor SET name=?, email=?, password=?, role=?, employeeId=?, specialization=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instructor.getName());
            stmt.setString(2, instructor.getEmail());
            stmt.setString(3, instructor.getPassword());
            stmt.setString(4, instructor.getRole());
            stmt.setString(5, instructor.getEmployeeId());
            stmt.setString(6, instructor.getSpecialization());
            stmt.setInt(7, instructor.getId());
            stmt.executeUpdate();
        }
    }
    public void deleteInstructor(int id) throws SQLException {
        String sql = "DELETE FROM instructor WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Instructor> getAllInstructors() throws SQLException {
        List<Instructor> instructors = new ArrayList<>();
        String sql = "SELECT * FROM instructor";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                instructors.add(new Instructor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("employeeId"),
                    rs.getString("specialization")
                ));
            }
        }
        return instructors;
    }
}
