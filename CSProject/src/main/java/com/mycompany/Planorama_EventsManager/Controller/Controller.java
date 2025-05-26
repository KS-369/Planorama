/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_EventsManager.Controller;

import com.mycompany.Planorama_EventsManager.Model.DBconnector;
import com.mycompany.Planorama_EventsManager.Model.Event;
import com.mycompany.Planorama_EventsManager.View.EventManagementUI;
import java.util.ArrayList;
/**
 *
 * @author adupa
 */
public class Controller {
    private DBconnector db;
    private EventManagementUI ui;
    private String currentUser;
    
    //controller
    public Controller(DBconnector db, EventManagementUI ui){
        this.ui  = ui;
        this.db = db;
    }
    
    //method to instantiate the current user.
    public void setCurrentuser(String username){
        this.currentUser = username;
    }
    
    //getting the current user.
    public String getCurrentUser(){
        return this.currentUser;
    }
    
    //method to add the title, date, and description provided in the parameter to the database.
    public void addEvent(String title, String date, String description) {
        boolean successful = db.addEventNotDuplicate(title,date,description, currentUser);
        
        //prints a success/failure message to the console, whne trying to add anevent to the database.
        if (successful) {
            System.out.println("Event added!");
            ui.refreshEventList();
        } else {
            System.out.println("Event not added.");
        }
    }
    
    //return the events and clears the panel
    public void loadEvents() {
        db.fillEventsFromDB(currentUser); //returns all the events created in the database
        ui.refreshEventList(); //clears the panel that shows all the events the user signs up for.
    }
    
    //returns all events created in the databse.
    public ArrayList<Event> getAllEvents(){
        return db.getEvents();
    }
    
    //deletes events through the title given in the parameter in the databse.
    public void deleteEvent(String title) {
        db.deleteEventByTitle(title, currentUser);
    }
    
    //updates the events with the oldTitle to newTitle, date, and description provided in the parameter.
    public void updateEvent(String oldTitle, String newTitle, String date, String desc) {
        db.updateEventInDB(oldTitle, newTitle, date, desc); //deletes from the database using the DBconnector class.
        ui.refreshEventList(); //refreshes the eventListPanel.
    }
}
