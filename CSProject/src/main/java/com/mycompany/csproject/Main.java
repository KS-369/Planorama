package com.mycompany.csproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 */
import com.mycompany.csproject.Controller;
import com.mycompany.csproject.DBconnector;
import com.mycompany.csproject.EventManagementUI;

public class Main {
    public static void main(String[] args) {
        DBconnector db = new DBconnector("events.db");
        EventManagementUI ui = new EventManagementUI(null);
        Controller controller = new Controller(db,ui);
        ui.setController(controller);
        controller.loadEvents();

    }
}
