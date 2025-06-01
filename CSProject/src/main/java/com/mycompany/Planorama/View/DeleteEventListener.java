/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama.View;

/**
 *
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.Planorama.Controller.Controller;
import com.mycompany.Planorama.Model.Event;

public class DeleteEventListener implements ActionListener {
    private Event event;
    private Controller controller;
    private EventManagementUI ui;    
    
    //controller
    public DeleteEventListener(Event event, Controller controller, EventManagementUI ui) {
        this.event = event;
        this.controller = controller;
        this.ui = ui;
    }
    
    //deletes the event while refering to the Controller class.
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.deleteEvent(event.getTitle());
        ui.refreshEventList();
    }
}
