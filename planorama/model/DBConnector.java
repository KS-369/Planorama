package com.mycompany.planorama.model;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private ArrayList<Event> events = new ArrayList<>();
    private String dbFileName, url;
    private Connection con = null;

    public DBConnector(String fileName) {
        this.dbFileName = fileName;
        this.url = "jdbc:sqlite:" + this.dbFileName;

        System.out.println("DB connected at: " + this.url);

        try {
            this.con = DriverManager.getConnection(this.url);
            Statement st = this.con.createStatement();
            String sqlTable = """
                CREATE TABLE IF NOT EXISTS event_info(
                    title TEXT PRIMARY KEY, 
                    date TEXT,
                    description TEXT,
                    username TEXT
                )""";
            st.execute(sqlTable);
            System.out.println("SQL connection made.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SQL Connection could not be made");
        }
    }

    public boolean editTable(String sqlCode) {
        try {
            Statement st = this.con.createStatement();
            st.execute(sqlCode);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SQL edit could not be made.");
            return false;
        }
    }

    public ResultSet getTableData(String sqlQuery) {
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SQL Query was not successful.");
            return null;
        }
    }

    // Fill all events for a particular user
    public void fillEventsFromDB(String username) {
        String q = "SELECT * FROM event_info WHERE username = '" + username + "';";
        events.clear();
        try {
            ResultSet rs = getTableData(q);
            while (rs.next()) {
                this.events.add(new Event(rs.getString("title"), rs.getString("date"), rs.getString("description")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Problem getting events from DB");
        }
    }

    // Add event for a specific user
    public boolean addEventNotDuplicate(String t, String d, String desc, String username) {
        for (Event e : events) {
            if (e.getTitle().equals(t)) {
                System.out.println("Event already exists.");
                return false;
            }
        }
        try {
            events.add(new Event(t, d, desc));
            String sqlCommand = String.format(
                "INSERT INTO event_info (title, date, description, username) VALUES ('%s', '%s', '%s', '%s');",
                t, d, desc, username);
            boolean result = editTable(sqlCommand);
            return result;
        } catch (Exception e) {
            System.out.println("Error writing to file:" + e.getMessage());
            System.out.println("Current event list size: " + events.size());
            return false;
        }
    }

    public void deleteEventByTitle(String title, String username) {
        try {
            String sql = "DELETE FROM event_info WHERE title = '" + title + "' AND username = '" + username + "';";
            editTable(sql);

            for (int i = 0; i < events.size(); i++) {
                Event e = events.get(i);
                if (e.getTitle().equals(title)) {
                    events.remove(i);
                    break;
                }
            }
            System.out.println("Deleted Event: " + title);
        } catch (Exception e) {
            System.out.println("Event failed to delete: " + e.getMessage());
        }
    }

    // Update event for a specific user
    public void updateEventInDB(String oldTitle, String newTitle, String date, String description, String username) {
        try {
            String sql = String.format(
                "UPDATE event_info SET title = '%s', date = '%s', description = '%s' WHERE title = '%s' AND username = '%s';",
                newTitle, date, description, oldTitle, username);
            editTable(sql);

            for (Event e : events) {
                if (e.getTitle().equals(oldTitle)) {
                    e.setEvent(newTitle, date, description);
                    break;
                }
            }
            System.out.println("Event updated: " + oldTitle + " to " + newTitle);
        } catch (Exception e) {
            System.out.println("Failed to update event:" + e.getMessage());
        }
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    // Get events for a specific user
    public ArrayList<Event> getEventsByUser(String username) {
        ArrayList<Event> userEvents = new ArrayList<>();
        String q = "SELECT * FROM event_info WHERE username = '" + username + "';";
        try {
            ResultSet rs = getTableData(q);
            while (rs.next()) {
                userEvents.add(new Event(rs.getString("title"), rs.getString("date"), rs.getString("description")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Problem getting events from DB");
        }
        return userEvents;
    }
}
