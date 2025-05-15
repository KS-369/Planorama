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
    
    public Controller(DBconnector db, EventManagementUI ui){
        this.ui  = ui;
        this.db = db;
    }
    
    public void addEvent(String title, String date, String description) {
        boolean successful = db.addEventNotDuplicate(title,date,description);
        
        if (successful) {
            System.out.println("Event added!");
            ui.refreshEventList();
        } else {
            System.out.println("Event not added.");
        }
    }
    
    public void loadEvents() {
        db.fillEventsFromDB();
        ui.refreshEventList();
    }
    
    public ArrayList<Event> getAllEvents(){
        return db.getEvents();
    }
    
    public void deleteEvent(String title) {
        db.deleteEventByTitle(title);
    }
    
    public void updateEvent(String oldTitle, String newTitle, String date, String desc) {
        db.updateEventInDB(oldTitle, newTitle, date, desc);
        ui.refreshEventList();
    }
}
