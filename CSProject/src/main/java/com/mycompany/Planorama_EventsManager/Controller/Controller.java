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
 *
 */

/* CONTROLLER CLASS
* DESCRIPTION: 
* - The controller class acts as the controller for the MVC.
* - It's a connection between model *EventManagementUI and the view (DBconnetor). 
* - It also handles actions like loading, editing, and updating events for the user. 
* - Lastly, it also ensures that the events created are private to every user and that they are stored and accessed per user. 
* INPUTS: 
* - Event information (title, date, description) from the UI. 
* - Accessing the Database through the DBconnector class.
* OUTPUTS: 
* - Updates the model (db) based on the addition or deletion of events.
* - Displays the event data on the user's screen through the UI.
*/

public class Controller {
    private DBconnector db;
    private EventManagementUI ui;
    private String currentUser;
    
    //Controller: takes the model and view as parameters. 
    public Controller(DBconnector db, EventManagementUI ui){
        this.ui  = ui;
        this.db = db;
    }
    
    //Method to instantiate the current user.
    public void setCurrentuser(String username){
        this.currentUser = username;
    }
    
    //Getting the current user.
    public String getCurrentUser(){
        return this.currentUser;
    }
    
    //Method to add the title, date, and description provided in the parameter to the database.
    public void addEvent(String title, String date, String description) {
        boolean successful = db.addEventNotDuplicate(title,date,description, currentUser);
        
        //prints a success/failure message to the console, when trying to add an event to the database.
        if (successful) {
            System.out.println("Event added!");
            ui.refreshEventList();
        } else {
            System.out.println("Event not added.");
        }
    }
    
    //Return the events and clears the panel
    public void loadEvents() {
        db.fillEventsFromDB(currentUser); //returns all the events created in the database of the user
        ui.refreshEventList(); //clears the panel that shows all the events the user signs up for
    }
    
    //Returns all events created in the databse.
    public ArrayList<Event> getAllEvents(){
        return db.getEvents();
    }
    
    //Deletes events through the title given in the parameter in the databse.
    public void deleteEvent(String title) {
        db.deleteEventByTitle(title, currentUser);
    }
    
    //Updates the events with the oldTitle to newTitle, date, and description provided in the parameter.
    public void updateEvent(String oldTitle, String newTitle, String date, String desc) {
        db.updateEventInDB(oldTitle, newTitle, date, desc); //Deletes from the database using the DBconnector class.
        ui.refreshEventList(); //Refreshes the eventListPanel.
    }
}
