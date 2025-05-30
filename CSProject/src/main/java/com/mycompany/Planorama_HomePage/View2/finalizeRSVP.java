
package com.mycompany.Planorama_HomePage.View2;

import com.mycompany.Planorama_HomePage.Model2.DBConnector;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author adupa
 */

    // FINALIZE RSVP CLASS (actionlistener)
// Finalize rsvp class implements the action listener interface and simply updates the rsvp database to rsvp the user for their chosen event
// Purpose (for class/constructor): 
// Final step where the user's RSVP is stored along with their comment. This class determines what happens when the user selects the rsvp button on the final rsvp page (where they input their comment and whatnot)
// Inputs (for constructor):
// JFrame theFrame, the main window that allows elements to properly be added to the screen
// String eventName, just holds the name of the event so that the program knows which event it is checking the RSVP for
// JTextField theComment, the text box containing the users comment so taht this class can access what they submitted as their comment and store it in db
// Outputs (for constructor):
// Evidently nothing is returned, but now the DB is updated to ensure the user is rsvpd, and the screen is refreshed to take the user back to the events option page

// EXAMPLE OF USAGE:
// myButton.addActionListener(new finalizeRSVP(frame, name, text));
// now when myButton (a JButton) is clicked, a new slot is created within the db for a reservation storing the 

class finalizeRSVP implements ActionListener {
    
    String event; //making fields for event name (to ensure user is rsvpd for right thing(, the frame, and the comment (to add to db)
    JFrame frame;
    String comment;
    
    
    finalizeRSVP(JFrame theFrame, String eventName, JTextField theComment){
        this.event = eventName; //ensuring info supplied as arguments is assigned to fields
        this.frame = theFrame;
        this.comment = theComment.getText();
        if (this.comment.equals("Enter your comment...")){
            this.comment = "";
        }
    }
 
    
    @Override // overriding actionperformed to determine what code is executed when the final rsvp button is clicked
    public void actionPerformed(ActionEvent e){
            DBConnector.addRSVP(event, "Melika Shaban", comment); //adds user to db by supplying event name, username, and comment using add rsvp method within db connector class
            RSVPView.makeScreen(frame); //calls make screen method to take user back to events option page when the rsvp is complete
            
                
    }
}
