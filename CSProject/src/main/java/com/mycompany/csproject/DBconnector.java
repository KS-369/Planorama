/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csproject;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * 
 */
public class DBconnector {
    ArrayList<Event> events = new ArrayList<>();
    String dbFileName, url, sqlTable;
    Connection con = null;
    
    public DBconnector(String fileName){
        this.dbFileName = fileName;
        String fPath = "src\\main\\java\\com\\mycompany\\csproject\\";
        this.url = "jdbc:sqlite:" + fPath + this.dbFileName;
        
        System.out.println("DB connected at: " + this.url);
        
        try {
            this.con = DriverManager.getConnection(this.url);
            Statement st = this.con.createStatement();
            sqlTable = """
                       CREATE TABLE IF NOT EXISTS event_info(
                       title TEXT PRIMARY KEY, 
                       date TEXT,
                       description TEXT
                       )""";
            st.execute(sqlTable);
            System.out.println("SQL connection made.");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("SQL Connection could not be made");
        }        
    }
    
    public boolean editTable(String sqlCode){
        try {
            Statement st = this.con.createStatement();
            st.execute(sqlCode);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("SQL edit could not be made.");
            return false;
        }
    }
    
    public ResultSet getTableData(String sqlQuery){
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
    
    public void fillEventsFromDB() {
        String q = "SELECT * FROM event_info;";
        try {
            ResultSet rs = getTableData(q);
            while (rs.next()){
                this.events.add(new Event(rs.getString("title"),rs.getString("date"),rs.getString("description")));
            }
            rs.close();
        } catch (Exception e){
            System.out.println("Problem getting events from DB");
        }
    }
    
    public boolean addEventNotDuplicate(String t, String d, String desc){
        for (Event e : events) {
            if (e.title.equals(t)) {
                System.out.println("Event already exists.");
                return false;
            }
        }
        try {
            events.add(new Event(t,d,desc));
            String sqlCommand = String.format("INSERT INTO event_info (title, date, description) VALUES ('%s', '%s', '%s');", t, d, desc);
            boolean result = editTable(sqlCommand);
            return result;
        } catch (Exception e) {
            System.out.println("Error writing to file:" + e.getMessage());
            System.out.println("Current event list size: " + events.size());
            return false;
        }
    }
    
    public void deleteEventByTitle(String title) {
        try {
            String sql = "DELETE FROM event_info WHERE title = '" + title + "';";
            editTable(sql);
            
            for (int i = 0; i < events.size(); i++) {
                Event e = events.get(i);
                if (e.title.equals(title)) {
                    events.remove(i);
                    break;
                }
            }
            System.out.println("Deleted Event: " + title);
        } catch (Exception e) {
            System.out.println("Event failed to delete: " + e.getMessage());
        }
    }
    
    public void updateEventInDB(String oldTitle, String newTitle, String date, String description) {
        try {
            String sql = "UPDATE event_info SET title = '%s', date = '%s', description = '%s' WHERE title = '%s';\", newTitle, date, description, oldTitle); ";
            editTable(sql);

            for (Event e : events) {
                if (e.title.equals(oldTitle)) {
                    e.setEvent(newTitle, date, description);
                    break;
                }
            }
            System.out.println("Event updated: " + oldTitle + "to" + newTitle);
        } catch (Exception e) {
            System.out.println("Failed to update event:" + e.getMessage());
        }
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
}



















