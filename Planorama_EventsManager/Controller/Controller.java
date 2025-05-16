/**
 * Controller.java
 * Located at: src/main/java/com/mycompany/planorama_EventsManager/Controller/Controller.java
 */
package com.mycompany.Planorama_EventsManager.Controller;

import com.mycompany.Planorama_EventsManager.Model.DBconnector;
import com.mycompany.Planorama_EventsManager.Model.Event;
import com.mycompany.Planorama_EventsManager.Model.Session;
import com.mycompany.Planorama_EventsManager.View.EventManagementUI;
import java.util.ArrayList;

public class Controller {
    private DBconnector db;
    private EventManagementUI ui;
    
    public Controller(DBconnector db, EventManagementUI ui){
        this.ui  = ui;
        this.db = db;
    }
    
    public void addEvent(String title, String date, String description) {
        String username = Session.getCurrentUsername();
        boolean successful = db.addEventNotDuplicate(title, date, description, username);
        
        if (successful) {
            System.out.println("Event added!");
            ui.refreshEventList();
        } else {
            System.out.println("Event not added.");
        }
    }
    
    public void loadEvents() {
        String username = Session.getCurrentUsername();
        loadEvents(username);
    }
    
    public void loadEvents(String username) {
        db.fillEventsFromDB(username);
        ui.refreshEventList();
    }
    
    public ArrayList<Event> getAllEvents(){
        return db.getEvents();
    }
    
    public void deleteEvent(String title) {
        String username = Session.getCurrentUsername();
        db.deleteEventByTitle(title, username);
        ui.refreshEventList();
    }
    
    public void updateEvent(String oldTitle, String newTitle, String date, String desc) {
        String username = Session.getCurrentUsername();
        db.updateEventInDB(oldTitle, newTitle, date, desc, username);
        ui.refreshEventList();
    }
}
