/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama.Model;

/**
 *
 *
 */

/* CONTROLLER CLASS
* DESCRIPTION: 
* - The Event class represents an event oobject. In other words, it is the blueprint for an evetn in the event management system, defining the behaviour of an event.
* INPUTS: 
* - Event information (title, date, description) from the UI. 
* OUTPUTS: 
* - No outputs.
*/

public class Event {

    String title;
    String date;
    String description;

    public Event(String t, String d, String desc) {
        this.title = t;
        this.date = d;
        this.description = desc;
    }

    public void setEvent(String t, String d, String desc) {
        this.title = t;
        this.date = d;
        this.description = desc;
    }
    
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}
