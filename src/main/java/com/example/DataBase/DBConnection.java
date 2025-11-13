package com.example.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.dao.CourseDao;
import com.example.dao.InstructorDao;
import com.example.dao.StudentDao;
import com.example.dao.UserDTO;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/lmsdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // ✅ Static method to get a fresh database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to MySQL successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to MySQL database!");
            e.printStackTrace();
        }
        return conn;
    }

    // ✅ Run this manually to create all tables once
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn == null) {
            System.err.println("❌ Cannot proceed — database connection is null!");
            return;
        }

        try {
            UserDTO userDao = new UserDTO(conn);
            InstructorDao instructorDao = new InstructorDao(conn);
            StudentDao studentDao = new StudentDao(conn);
            CourseDao courseDao = new CourseDao(conn);

            userDao.createTable();
            instructorDao.createTable();
            studentDao.createTable();
            courseDao.createTable();

            System.out.println("✅ All tables created successfully or already exist.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("🔒 Connection closed successfully.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
