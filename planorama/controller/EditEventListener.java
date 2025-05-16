package com.mycompany.planorama.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.planorama.model.Event;
import com.mycompany.planorama.view.EventManagementUI;

public class EditEventListener implements ActionListener {
    private Event event;
    private JTextField titleField;
    private JTextField dateField;
    private JTextArea descriptionArea;
    private JButton saveButton;
    private EventManagementUI ui;
    
    public EditEventListener(Event event, JTextField titleField, JTextField dateField, JTextArea descriptionArea,
            JButton saveButton, EventManagementUI ui) {
        this.event = event;
        this.titleField = titleField;
        this.dateField = dateField;
        this.descriptionArea = descriptionArea;
        this.saveButton = saveButton;
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        titleField.setText(event.getTitle());
        dateField.setText(event.getDate());
        descriptionArea.setText(event.getDescription());
        saveButton.setText("Update");
        ui.setEditingEvent(event);
    }
}
