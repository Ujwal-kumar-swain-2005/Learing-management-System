package com.example.dao;
import java.sql.Connection;

import com.example.DataBase.DBConnection;

public class AdminDAO {

    private final Connection conn;

    public AdminDAO() {
        conn = DBConnection.getConnection();
        if (conn == null) {
            System.err.println("❌ [AdminDAO] Database connection failed!");
        } else {
            System.out.println("✅ [AdminDAO] Connected to database successfully!");
        }
    }

  
}
