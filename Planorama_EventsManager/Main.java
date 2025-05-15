package com.mycompany.Planorama_EventsManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 */
import com.mycompany.Planorama_EventsManager.Controller.Controller;
import com.mycompany.Planorama_EventsManager.Model.DBconnector;
import com.mycompany.Planorama_EventsManager.View.EventManagementUI;

public class Main {
    public static void main(String[] args) {
        DBconnector db = new DBconnector("events.db");
        EventManagementUI ui = new EventManagementUI(null);
        Controller controller = new Controller(db,ui);
        ui.setController(controller);
        controller.loadEvents();

    }
}
