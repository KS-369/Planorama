/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.planorama.Model;

/**
 *
 * @author Kalli-Ann
 */

import java.sql.*;

public class UserModel {
    private Connection conn;
    
    /*
     * UserModel()
     *
     * Output:
     * - Connects to the SQLite database using the specified path.
     * - If the database file does not exist, it is created automatically.
     * - Calls createTable() to ensure the user table is initialized.
     *
     * Example:
     * - Initializes a new connection to `users.db` and sets up the schema if not already present.
     */

    public UserModel() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite://home//Kalli-Ann//NetBeansProjects//Planorama//src//main//java//com//mycompany//planorama//Model//users.db"); // change this to create db file in different file path
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * UserModel()
     *
     * Output:
     * - Connects to the SQLite database using the specified path.
     * - If the database file does not exist, it is created automatically.
     * - Calls createTable() to ensure the user table is initialized.
     *
     * Example:
     * - Initializes a new connection to `users.db` and sets up the schema if not already present.
     */
    
    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT NOT NULL)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

     /*
     * authenticate(String username, String password)
     *
     * Inputs:
     * - username: The input username from the login form.
     * - password: The input password from the login form.
     *
     * Output:
     * - Returns true if the credentials match an existing user in the database.
     * - Returns false if the credentials are incorrect or if a database error occurs.
     *
     * Example:
     * - authenticate("alice", "123") → true if "alice" exists with password "123"
     */
    
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

     /*
     * register(String username, String password)
     *
     * Inputs:
     * - username: The desired new username to register.
     * - password: The password to associate with the username.
     *
     * Output:
     * - Returns true if registration is successful.
     * - Returns false if the username already exists or a database error occurs.
     *
     * Example:
     * - register("newuser", "mypassword") → true if username not already taken.
     */
    
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
    
    /*
     * userExists(String username)
     *
     * Input:
     * - username: The username to check in the database.
     *
     * Output:
     * - Returns true if the username is already present in the `users` table.
     * - Returns false otherwise.
     *
     * Example:
     * - userExists("bob") → true if "bob" is in the table.
     */
    
    private boolean userExists(String username) throws SQLException {
        String sql = "SELECT username FROM users WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
