/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_EventsManager.View;

/**
 *
 * @author adupa
 */
import com.mycompany.Planorama_EventsManager.Model.Event;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.Planorama_EventsManager.Controller.Controller;

public class SaveEventListener implements ActionListener{
    private final Controller controller;
    private final  JTextField titleField;
    private final JTextField dateField;
    private final JTextArea descriptionArea;
    private EventManagementUI ui;
    private JButton saveButton;
    
    //controller
    public SaveEventListener(JTextField titleField, JTextField dateField, JTextArea descriptionArea,
            JButton saveButton, Controller controller, EventManagementUI ui) {
        this.titleField = titleField;
        this.dateField = dateField;
        this.descriptionArea = descriptionArea;
        this.saveButton = saveButton;
        this.controller = controller;
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String title = titleField.getText();
        String date = dateField.getText();
        String desc = descriptionArea.getText();
        
        //displaying an error on the screen if the title field is left blank.
        if(title.isEmpty() || date.isEmpty() || desc.isEmpty()){
            JOptionPane.showMessageDialog(ui, "Title, Date, or Description fields cannot be blank.");
            return;
        }
        
        Event editing = ui.getEditingEvent();
        
        if (editing != null) {
            controller.updateEvent(editing.getTitle(), title, date, desc);
            ui.setEditingEvent(null);
            saveButton.setText("Save");
        } else {
            controller.addEvent(title, date, desc);
        }
    }
}
