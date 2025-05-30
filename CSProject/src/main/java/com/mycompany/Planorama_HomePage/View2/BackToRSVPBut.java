/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_HomePage.View2;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

/**
 *
 * 
 */
public class BackToRSVPBut implements ActionListener{
    private JFrame current;
    
    //Controller
    public BackToRSVPBut(JFrame frame){
        this.current = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        //block of code to open the RSVPView screen
        JFrame frame = new JFrame("RSVP Page");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RSVPView.makeScreen(frame);
    }
}
