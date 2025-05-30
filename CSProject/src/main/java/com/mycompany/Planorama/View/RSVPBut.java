/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama.View;

import com.mycompany.Planorama.Model.DBConnector_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * 
 */
public class RSVPBut implements ActionListener {
    
    String event;
    JFrame frame;
    
    RSVPBut(String eventName, JFrame theFrame){
        this.event = eventName;
        this.frame = theFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        RSVPView.RSVPScreen(frame, event);
        
                
    }
}



