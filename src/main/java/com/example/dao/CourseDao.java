package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Course;

public class CourseDao {
    private final Connection conn;

    public CourseDao(Connection conn) {
        this.conn = conn;
    }
    public CourseDao(){
        this.conn = com.example.DataBase.DBConnection.getConnection();

        if (this.conn == null) {
            System.err.println("❌ [CourseDao] Database connection is null! Check DBConnection.");
        } else {
            System.out.println("✅ [CourseDao] Connection established successfully.");
        }
    }
    public void createTable() throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS Course (" +
                 "id INT AUTO_INCREMENT PRIMARY KEY, " +
                 "title VARCHAR(255) NOT NULL, " +
                 "description TEXT, " +
                 "instructorId INT, " +
                 "category VARCHAR(100), " +
                 "level VARCHAR(50)" +
                 ")";
    try (Statement stmt = conn.createStatement()) {
        stmt.executeUpdate(sql);
        System.out.println("Course table created or already exists.");
    }
}


    public void saveCourse(Course course) throws SQLException {
        String sql = "INSERT INTO Course (title, description, instructorId, category, level) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getTitle());
            stmt.setString(2, course.getDescription());
            stmt.setInt(3, course.getInstructorId());
            stmt.setString(4, course.getCategory());
            stmt.setString(5, course.getLevel());
            stmt.executeUpdate();
        }
    }

    public Course getCourse(int id) throws SQLException {
        String sql = "SELECT * FROM Course WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("instructorId"),
                    rs.getString("category"),
                    rs.getString("level")
                );
            }
        }
        return null;
    }

    public void updateCourse(Course course) throws SQLException {
        String sql = "UPDATE Course SET title=?, description=?, instructorId=?, category=?, level=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getTitle());
            stmt.setString(2, course.getDescription());
            stmt.setInt(3, course.getInstructorId());
            stmt.setString(4, course.getCategory());
            stmt.setString(5, course.getLevel());
            stmt.setInt(6, course.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteCourse(int id) throws SQLException {
        String sql = "DELETE FROM Course WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(new Course(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("instructorId"),
                    rs.getString("category"),
                    rs.getString("level")
                ));
            }
        }
        return courses;
    }
}
