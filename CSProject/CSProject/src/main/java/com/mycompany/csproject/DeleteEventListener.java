/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csproject;

/**
 *
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.csproject.Controller;
import com.mycompany.csproject.Event;

public class DeleteEventListener implements ActionListener {
    private Event event;
    private Controller controller;
    private EventManagementUI ui;    

    public DeleteEventListener(Event event, Controller controller, EventManagementUI ui) {
        this.event = event;
        this.controller = controller;
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.deleteEvent(event.getTitle());
        ui.refreshEventList();
    }
}
