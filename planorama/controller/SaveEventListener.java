package com.mycompany.planorama.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.planorama.model.Event;
import com.mycompany.planorama.view.EventManagementUI;

public class SaveEventListener implements ActionListener {
    private final EventController controller;
    private final JTextField titleField;
    private final JTextField dateField;
    private final JTextArea descriptionArea;
    private EventManagementUI ui;
    private JButton saveButton;
    
    public SaveEventListener(JTextField titleField, JTextField dateField, JTextArea descriptionArea,
            JButton saveButton, EventController controller, EventManagementUI ui) {
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
