/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Planorama_EventsManager.View;

import com.mycompany.Planorama_EventsManager.View.EditEventListener;
import com.mycompany.Planorama_EventsManager.View.DeleteEventListener;
import com.mycompany.Planorama_EventsManager.Controller.Controller;
import com.mycompany.Planorama_EventsManager.Model.Event;
import com.mycompany.Planorama_HomePage.View2.EventsNearYou;
import static com.mycompany.Planorama_HomePage.View2.HomePageUI.currentUser;
import com.mycompany.Planorama_LoginPage.View1.toEventsManager;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.ArrayList;


/* Description: 
 * - This class represents the GUI, by allowing the users to create, edit, and delete veents. 
 * Input: 
 * - Controller, User-entered data from the text-fields.
 * Output: 
 * - Displays the Create an Event Page, specifically the event list, event form, and the success dialogs.
 * - Sends the user actions to the controller and updates the UI accordingly.
 */
public class EventManagementUI extends JFrame {
    private final JTextField titleField;
    private final JTextField dateField;
    private final JTextArea descriptionArea;
    private final JButton saveButton;
    private final JPanel eventListPanel;
    private Event editingEvent = null;
    private final JButton backButton;
    
    public static Controller controller = null;
    
    //controller
    public EventManagementUI(Controller controller){
        this.controller = controller;
        setLayout(null);
        
        //title of the page
        JLabel title = new JLabel("Event Management Page");
        title.setBounds(300,-40,500,100);
        title.setFont(new Font("Verdana", Font.ITALIC, 20));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        
        JPanel formPanel = new JPanel(null);
        formPanel.setBackground(new Color(112, 182, 163));
        formPanel.setBounds(0, 0, 2000, 2000);
        
        titleField = new JTextField();
        dateField = new JTextField();
        descriptionArea = new JTextArea();
        saveButton = new JButton("Save");
        backButton = new JButton("Back");
        
        //dimensions for the title label, date label, description label (descLabel), and the save_button
        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setBounds(300,45,100,20);
        titleField.setBounds(400,45,180,20);
        
        JLabel dateLabel = new JLabel("Date: ");
        dateLabel.setBounds(300,75,100,20);
        dateField.setBounds(400,75,180,20);
        
        JLabel descLabel = new JLabel("Description: ");
        descLabel.setBounds(300,105,100,20);
        JScrollPane descScroll = new JScrollPane(descriptionArea);
        descScroll.setBounds(400,105,180,80);
        
        saveButton.setBounds(400,205,100,30);
        
        //ActionListener for the button save and connecting it to the SaveEventListener class.
        saveButton.addActionListener(new SaveEventListener(titleField, dateField, descriptionArea, saveButton, controller, this));
        
        //adding dimensions for the back to home page button
        backButton.setBounds(400,245,100,30);
        
        //adding all the variables to the panel.
        formPanel.add(title);
        formPanel.add(titleLabel);
        formPanel.add(titleField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        formPanel.add(descLabel);
        formPanel.add(descScroll);
        formPanel.add(saveButton);
        formPanel.add(backButton);
        
        //setting the background color and layout dimensions for the panel that displays all the events user signs up for.
        eventListPanel = new JPanel();
        eventListPanel.setLayout(new BoxLayout(eventListPanel, BoxLayout.Y_AXIS));
        eventListPanel.setBackground(new Color(245, 250, 255));
        
        //adding a scrollbar to the eventListPanel.
        JScrollPane scrollPane = new JScrollPane(eventListPanel);
        scrollPane.setBounds(600,10,330,340);
        
        
        add(formPanel);
        add(scrollPane);
        
        setVisible(true);

    }
    
    //method to clear the text fields: titleField, dateField, descriptionArea
    public void clearForm(){
        titleField.setText("");
        dateField.setText("");
        descriptionArea.setText("");
    }
    
    //displays a success message when the event is added to the database.
    public void displaySuccess() {
        System.out.println(this + "Event added successfully!");
    }
    
    //didsplays a failure message if the event already exsists in the database.
    public void displayEventAddingFail() {
        System.out.println(this + "Event already exsists. Choose a different title.");
    }
    
    //sets the editingEvent variable to the event object given in the parameter.
    public void setEditingEvent(Event event) {
        this.editingEvent = event;
    }
    
    //returns the editingEvent variable from this class.
    public Event getEditingEvent() {
        return editingEvent;
    }
    
    //sets the private Controller object in this class to the Controller object given in the paramaeter. It also updates the saveButton to a new SaveEventListener class with the UI window itself.
    public void setController(Controller controller) {
        this.controller = controller;
        saveButton.addActionListener(new SaveEventListener(titleField, dateField, descriptionArea, saveButton, controller, this));
        backButton.addActionListener(new BackToHomeBtn(this));
    }
    
    //resets the eventListPanel to being empty.
    public void refreshEventList(){
        eventListPanel.removeAll(); //emtpies the panel that displays the events that user signs up for.
        ArrayList<Event> events = controller.getAllEvents(); //gets all the events from the data base and stores them in the events array list.
        
        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            
            //replacing the current eventListPanel to a new, empty panel.
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
            
            //updating the editBtn and deleteBtn's ActionaListener to a this UI.
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




