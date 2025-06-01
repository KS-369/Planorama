/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama.View;

/**
 *
 * 
 */
import com.mycompany.Planorama.Controller.Controller;
import com.mycompany.Planorama.Model.DBconnector;
import com.mycompany.Planorama.View.EventManagementUI;
import com.mycompany.Planorama.Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class toEventsManager implements ActionListener {
    private final String username;
    Controller controller;
    
    //controller
    public toEventsManager(String username){
        this.username = username;
    }

    //connecting to the events manager page (the page that allows users to create and edit their events).
    @Override
    public void actionPerformed(ActionEvent e) {
        DBconnector db = new DBconnector("events.db");
        EventManagementUI ui = new EventManagementUI(controller);
        Controller controller = new Controller(db, ui);
        
        controller.setCurrentuser(username);
        ui.setController(controller);
        controller.loadEvents();
        
        //block of code to open the events manager UI
        JFrame frame = new JFrame("Create Event");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,700);
        frame.setContentPane(ui.getContentPane());
        frame.setVisible(true);
    }
}
