/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_HomePage.View2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author adupa
 */
public class finalizeRSVP implements ActionListener {
    
    String event;
    JFrame frame;
    String comment;
    
    
    finalizeRSVP(JFrame theFrame, String eventName, JTextField theComment){
        this.event = eventName;
        this.frame = theFrame;
        this.comment = theComment.getText();
    }
 
    
    @Override
    public void actionPerformed(ActionEvent e){
            EventsNearYou.dbConnector.addRSVP(event, "bethany_hello_123", "bethany", comment);
            RSVPView.makeScreen(frame);
            
                
    }
}
