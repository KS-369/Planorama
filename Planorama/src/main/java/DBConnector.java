/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shabm2770
 */

import java.nio.file.*;
import java.sql.*;

public class DBConnector {
    private String url;

    // Constructor - pass the full path to the DB file
    public DBConnector(String dbFilePath) {
        this.url = "jdbc:sqlite:" + dbFilePath;
        createTableIfNotExists();
    }

    // Create the RSVP table if it doesn't exist yet
    private void createTableIfNotExists() {
        String sqlCreateTable = """
            CREATE TABLE IF NOT EXISTS RSVP (
                RSVP_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                EventName TEXT,
                Username TEXT,
                ActualName TEXT,
                Comment TEXT
            );
        """;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreateTable);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating RSVP table");
        }
    }

    // Method to insert one RSVP entry
    public void addRSVP(String eventName, String username, String actualName, String comment) {
        String sqlInsert = "INSERT INTO RSVP (EventName, Username, ActualName, Comment) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
            
            pstmt.setString(1, eventName);
            pstmt.setString(2, username);
            pstmt.setString(3, actualName);
            pstmt.setString(4, comment);
            
            pstmt.executeUpdate();
            System.out.println("RSVP added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting RSVP");
        }
    }
}