/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_HomePage.View2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author adupa
 */
// EVENTS NEAR YOU CLASS (actionlistener)
// Events near you class implements the action listener interface and is essentially made to perform an action when a specific button is clicked (which in this case is load the events near you screen(
// Purpose (for class/constructor): 
// Navigates the user to a screen that displays the RSVP options for nearby events
// Inputs (for constructor):
// JFrame theFrame, the main window that allows elements to properly be added to the screen
// Outputs (for constructor):
// Evidently nothing is returned, but now the frame field is holding the proper JFrame value

// EXAMPLE OF USAGE:
// myButton.addActionListener(new EventsNearYou(frame));
// now when myButton (a JButton) is clicked, the code in the action performed method should be executed (in this case, it makes the events near you page pop up)

class EventsNearYou implements ActionListener {
    
    JFrame frame; //frame field to easily access it 
    
    public EventsNearYou (JFrame theFrame){ //constructor that assigns theFrame to the proper field

        this.frame = theFrame;
    
    }
    
    @Override //overiding the essential action performed method
    public void actionPerformed(ActionEvent e){ //action event e - event object that sort of represents the users click
 
        HomePageUI.refreshFrame(frame); //clears frame so it is ready to be changed
        
        RSVPView.makeScreen(frame); //calls make screen method to generate events near you page
    }
}
