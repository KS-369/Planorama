/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_HomePage.View2;

import com.mycompany.Planorama_HomePage.Model2.DBConnector;
import com.mycompany.Planorama_LoginPage.View1.LoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 *
 */
public class finalizeRSVP implements ActionListener {
    
    String event;
    JFrame frame;
    String comment;
    public static DBConnector dbConnector = new DBConnector("jdbc:sqlite:C:/Users/adupa/OneDrive/Documents/NetBeansProjects/CSProject/src/main/java/com/mycompany/Planorama_HomePage/Model2/rsvp.db");

    
    finalizeRSVP(JFrame theFrame, String eventName, JTextField theComment){
        this.event = eventName;
        this.frame = theFrame;
        this.comment = theComment.getText();
    }
 
    
    @Override
    public void actionPerformed(ActionEvent e){
            dbConnector.addRSVP(event, LoginUI.getUsername(), LoginUI.getUsername(), comment);
            RSVPView.makeScreen(frame);
            
                
    }
}
