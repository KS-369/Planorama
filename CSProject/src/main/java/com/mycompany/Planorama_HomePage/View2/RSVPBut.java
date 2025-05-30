/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_HomePage.View2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import com.mycompany.Planorama_HomePage.Model2.DBConnector;


/**
 *
 * @author adupa
 */
// RSVP BUT CLASS (actionlistener)
// RSVPBut class implements the action listener and allows the RSVP button on the events near you page to function
// Purpose (for class/constructor): 
// IF USER IS ALREADY SIGNED UP:
// in this scenario, this actionlistener functions as a removal button by allowing the user to unrsvp
// IF THEY ARE NOT SIGED UP:
// otherwise, the button functions normally and will guide the user to another page where they can finalize their rsvp details, such as adding comments and submitting
// Inputs (for constructor):
// String eventName, just holds the name of the event so that the program knows which event it is checking the RSVP for
// JFrame theFrame, the main window that allows elements to properly be added to the screen
// boolean theBoolean, lets the program know whether the button is acting as a removal button (true) or a adding button (false). This var allows one action listener class to perform both abilities at once
// Outputs (for constructor):
// Evidently nothing is returned, but using this class/constructor, either the screen is updated OR the RSVP entry is removed

// EXAMPLE OF USAGE:
// myButton.addActionListner(new RSVPBut(frame, false));
// now when myButton is clicked (in this case since the bool is false), the user will be guided to another page to enter their final rsvp details (like the comment)

class RSVPBut implements ActionListener {
    
    String event; //creating fields for event, frame and bool
    JFrame frame;
    boolean bool;
    
    
    RSVPBut(String eventName, JFrame theFrame, boolean theBoolean){ //supplying given argumens to fields
        this.event = eventName;
        this.frame = theFrame;
        this.bool = theBoolean;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){ //when button is clicked...
        if (this.bool == true){ //if it is true (meaning they are already registered) it will allow the user to un rsvp
            DBConnector.removeRSVP(this.event, "Melika Shaban"); //removes user using method within db connector class
            RSVPView.makeScreen(this.frame); //remakes the rsvp screen so that the button switches BACK to rsvp (because now that they're un rsvped, they can rsvp again)
        }else{
            RSVPView.RSVPScreen(this.frame, this.event); //otherwise, the user is taken to the next page to finalize rsvp details
        }  
         
    }
}
