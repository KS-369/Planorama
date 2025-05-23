import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*


 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shabm2770
 */

class EventsNearYou implements ActionListener {
    
        
    public static DBConnector dbConnector = new DBConnector("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\rsvp.db");
    
    JFrame frame;
    
    public EventsNearYou (JFrame theFrame){

        this.frame = theFrame;
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
 
        MyProgram.refreshFrame(frame);
        
        RSVPModel.makeScreen(frame);
    }
}

class RSVPBut implements ActionListener {
    
    String event;
    JFrame frame;
    
    
    RSVPBut(String eventName, JFrame theFrame){
        this.event = eventName;
        this.frame = theFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
            RSVPModel.RSVPScreen(frame, event);
            
                
    }
}

class finalizeRSVP implements ActionListener {
    
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
            RSVPModel.makeScreen(frame);
            
                
    }
}



