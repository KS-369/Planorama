/**
 * UserModel.java
 * Located at: src/main/java/com/mycompany/planorama/Model/UserModel.java
 */
package com.mycompany.planorama.Model;

import java.sql.*;

public class UserModel {
    private Connection conn;

    public UserModel() {
        try {
            // Use a relative path that works across different systems
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT NOT NULL)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }
    
    public boolean authenticate(String username, String password) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean register(String username, String password) {
        try {
            if (userExists(username)) return false;

            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private boolean userExists(String username) throws SQLException {
        String sql = "SELECT username FROM users WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
