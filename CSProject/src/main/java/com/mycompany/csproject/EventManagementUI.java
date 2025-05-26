/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csproject;

import com.mycompany.csproject.Controller;
import com.mycompany.csproject.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * 
 */
public class EventManagementUI extends JFrame {
    private final JTextField titleField;
    private final JTextField dateField;
    private final JTextArea descriptionArea;
    private final JButton saveButton;
    private final JPanel eventListPanel;
    private Event editingEvent = null;
    
    private Controller controller = null;
    private final int editingIndex = -1;
    
    public EventManagementUI(Controller controller){
        this.controller = controller;
        
        setTitle("Event Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600); //700, 400!
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        
        JPanel formPanel = new JPanel(null);
        formPanel.setBackground(new Color(230, 240, 255));
        formPanel.setBounds(50, 10, 720, 640); //320, 340

        titleField = new JTextField();
        dateField = new JTextField();
        descriptionArea = new JTextArea();
        saveButton = new JButton("Save");
        
        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setBounds(10,30,100,20);
        titleField.setBounds(110,30,180,20);
        
        JLabel dateLabel = new JLabel("Date: ");
        dateLabel.setBounds(10,60,100,20);
        dateField.setBounds(110,60,180,20);
        
        JLabel descLabel = new JLabel("Description: ");
        descLabel.setBounds(10,90,100,20);
        JScrollPane descScroll = new JScrollPane(descriptionArea);
        descScroll.setBounds(110,90,180,80);
        
        saveButton.setBounds(110,190,100,30);
        
        saveButton.addActionListener(new SaveEventListener(titleField, dateField, descriptionArea, saveButton, controller, this));
        
        formPanel.add(titleLabel);
        formPanel.add(titleField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        formPanel.add(descLabel);
        formPanel.add(descScroll);
        formPanel.add(saveButton);
                
        eventListPanel = new JPanel();
        eventListPanel.setLayout(new BoxLayout(eventListPanel, BoxLayout.Y_AXIS));
        eventListPanel.setBackground(new Color(245, 250, 255));
        
        JScrollPane scrollPane = new JScrollPane(eventListPanel);
        scrollPane.setBounds(400,10,330,340);
        
        add(formPanel);
        add(scrollPane);
        
        setVisible(true);

    }
    
    public void clearForm(){
        titleField.setText("");
        dateField.setText("");
        descriptionArea.setText("");
    }
    
    public void displaySuccess() {
        JOptionPane.showMessageDialog(this, "Event added successfully!");
    }
    
    public void displayEventAddingFail() {
        JOptionPane.showMessageDialog(this, "Event already exsists. Choose a different title.");
    }
    
    public void setEditingEvent(Event event) {
        this.editingEvent = event;
    }

    public Event getEditingEvent() {
        return editingEvent;
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
        saveButton.addActionListener(new SaveEventListener(titleField, dateField, descriptionArea, saveButton, controller, this));
    }
    
    public void refreshEventList(){
        eventListPanel.removeAll();
        ArrayList<Event> events = controller.getAllEvents();
        
        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            
            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));
            card.setBackground(Color.white);
            
            JLabel title = new JLabel("Title: " + e.getTitle());
            JLabel date = new JLabel("Date: " + e.getDate());
            JTextArea desc = new JTextArea("Description: " + e.getDescription());
            desc.setLineWrap(true);
            desc.setEditable(false);
            desc.setBackground(card.getBackground());
            
            JButton editBtn = new JButton("Edit");
            JButton deleteBtn = new JButton("Delete");
            
            JPanel btnPanel = new JPanel();
            
            editBtn.addActionListener(new EditEventListener(e, titleField, dateField, descriptionArea, saveButton, this));
            deleteBtn.addActionListener(new DeleteEventListener(e, controller, this));
            
            btnPanel.add(editBtn);
            btnPanel.add(deleteBtn);
            
            card.add(title);
            card.add(date);
            card.add(desc);
            card.add(btnPanel);
            eventListPanel.add(card);
        }
        eventListPanel.revalidate();
        eventListPanel.repaint();
    }
    
}




