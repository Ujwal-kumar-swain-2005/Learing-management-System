package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Student;

public class StudentDao {
    private final Connection conn;

    public StudentDao(Connection conn) {
        this.conn = conn;
    }
    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS student (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "name VARCHAR(255), " +
                     "email VARCHAR(100), " +
                     "password VARCHAR(100), " +
                     "role VARCHAR(50), " +
                     "studentId VARCHAR(50), " +
                     "department VARCHAR(100), " +
                     "year INT" +
                     ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Student table created or already exists.");
        }
    }
    public void saveStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (name, email, password, role, studentId, department, year) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getPassword());
            stmt.setString(4, student.getRole());
            stmt.setString(5, student.getStudentId());
            stmt.setString(6, student.getDepartment());
            stmt.setInt(7, student.getYear());
            stmt.executeUpdate();
        }
    }
    public Student getStudent(int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("studentId"),
                    rs.getString("department"),
                    rs.getInt("year")
                );
            }
        }
        return null;
    }
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET name=?, email=?, password=?, role=?, studentId=?, department=?, year=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getPassword());
            stmt.setString(4, student.getRole());
            stmt.setString(5, student.getStudentId());
            stmt.setString(6, student.getDepartment());
            stmt.setInt(7, student.getYear());
            stmt.setInt(8, student.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("studentId"),
                    rs.getString("department"),
                    rs.getInt("year")
                ));
            }
        }
        return students;
    }
}
