package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.DataBase.DBConnection;
import com.example.model.User;

public class UserDTO {

    private final Connection conn;
    public UserDTO(Connection conn) {
        this.conn = conn;
    }
    public UserDTO() {
        this.conn = DBConnection.getConnection();

        if (this.conn == null) {
            System.err.println("❌ [UserDTO] Database connection is null! Check DBConnection.");
        } else {
            System.out.println("✅ [UserDTO] Connection established successfully.");
        }
    }
    public void createTable() throws SQLException {
        if (conn == null) throw new SQLException("Database connection is null!");

        String sql = """
            CREATE TABLE IF NOT EXISTS user (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                email VARCHAR(100) NOT NULL UNIQUE,
                password VARCHAR(100),
                role VARCHAR(50)
            )
            """;

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("✅ User table created or already exists.");
        }
    }
    public void saveUser(User user) throws SQLException {
        if (conn == null) throw new SQLException("Database connection not initialized.");

        String sql = "INSERT INTO user (name, email, password, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.executeUpdate();
            System.out.println("✅ User saved successfully: " + user.getName());
        }
    }
    public User getUser(int id) throws SQLException {
        if (conn == null) throw new SQLException("Database connection not initialized.");

        String sql = "SELECT * FROM user WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("role")
                    );
                }
            }
        }
        return null;
    }
    public void updateUser(User user) throws SQLException {
        if (conn == null) throw new SQLException("Database connection not initialized.");

        String sql = "UPDATE user SET name=?, email=?, password=?, role=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.setInt(5, user.getId());
            stmt.executeUpdate();
            System.out.println("✅ User updated successfully: ID " + user.getId());
        }
    }
    public void deleteUser(int id) throws SQLException {
        if (conn == null) throw new SQLException("Database connection not initialized.");

        String sql = "DELETE FROM user WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ User deleted successfully: ID " + id);
        }
    }
    public List<User> getAllUsers() throws SQLException {
        if (conn == null) throw new SQLException("Database connection not initialized.");

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }
        }
        return users;
    }
}
