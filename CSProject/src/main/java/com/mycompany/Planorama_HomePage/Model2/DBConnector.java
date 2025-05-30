package com.mycompany.Planorama_HomePage.Model2;

import java.sql.*;

// DBConnector handles all database operations related to RSVP data, and it allows adding, checking, removing RSVPs, and ensures the table exists.

public class DBConnector {

    // file path to databse
    static String DB_PATH = "jdbc:sqlite:C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\planorama.db";

    
    // CREATE TABLE IF NOT EXIST:
    // Purpose:
    // Creates the RSVP table in the database if it does not already exist, and it ensres the program won't fail (for instance if the table is missing, because it allows us to always make a table if there isn't already one)
    // Input: None
    // Output: Evidently nothing is returned, but as a result of this method, a table will be created if it does not already exist
    
    // Example:
    // DBConnector.createTableIfNotExists();
    
    public static void createTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS RSVP (
                RSVP_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                EventName TEXT,
                Username TEXT,
                Comment TEXT
            );
        """;

        try (Connection conn = DriverManager.getConnection(DB_PATH);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("RSVP table ready.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating RSVP table");
        }
    }

    // ADD RSVP:
    // Purpose:
    // Adds a new RSVP entry to the database with the given event, user, and comment
    // Inputs:
    // String eventName - the name of the event
    // String username - the name of the user RSVPing
    // String comment - a comment provided by the user
    // Output:
    // Returns nothing BUT will update database to add a new entry with the given information
    
    // Examples:
    // DBConnector.addRSVP("Cheese Tasting", "Melika_Shaban", "Cannot wait!");
    // This will result in a new entry in the table for the event of cheese tasting, the username Melika_Shaban, and the comment cannot wait for the host. Also, the db will automatically provide a rsvp id depending on the spot within the table.
    
    
    public static void addRSVP(String eventName, String username, String comment) {
        String sql = "INSERT INTO RSVP (EventName, Username, Comment) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_PATH);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, eventName);
            pstmt.setString(2, username);
            pstmt.setString(3, comment);

            pstmt.executeUpdate();
            System.out.println("RSVP added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting RSVP");
        }
    }
    
    // HAS RSVP:
    // Purpose:
    // Checks if a user has already RSVPed to a specific event. If so,  the program will return true, otherwise false
    // Inputs:
    // String eventName - the name of the event to check
    // String username - the user's name to check for an RSVP
    // Output:
    // a boolean value that will be true if RSVP currectly exists within the table, and false otherwise
    
    // Example:
    // boolean usersRSVP = DBConnector.hasRSVP("Dog Yoga", "Melika_Shaban");
    // now, the var boolean will either have a value of true (if the individual with that username IS registered for that specific event), an false otherwise.

    public static boolean hasRSVP(String eventName, String username) {
        String sql = "SELECT * FROM RSVP WHERE EventName = ? AND Username = ?";

        try (Connection conn = DriverManager.getConnection(DB_PATH);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, eventName);
            pstmt.setString(2, username);

            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // true if a match is found

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error checking RSVP");
        }
        return false;
    }

    // REMOVE RSVP:
    // Purpose:
    // Removes an existing RSVP from the database based on the event and username supplied 
    // Inputs:
    // String eventName - the name of the event
    // String username - the name of the user whose RSVP should be removed
    // Output:
    // Does not return anything (void), but will end up removing the user's RSVP to ensure they are no longer signed up for the given event
    
    // Example:
    // DBConnector.removeRSVP("Spring Festival", "Melika_Shaban");
    // This line of code will remove the user with the username Melika_Shaban from the rsvp for the spring festival
    
    // *Please note that this method will only ever be used after the program checks to see if the rsvp exists in the first place, which prevents crashing and errors.
    
    public static void removeRSVP(String eventName, String username) {
        String sql = "DELETE FROM RSVP WHERE EventName = ? AND Username = ?";

        try (Connection conn = DriverManager.getConnection(DB_PATH);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, eventName);
            pstmt.setString(2, username);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + " RSVP(s) removed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error removing RSVP");
        }
    }
}