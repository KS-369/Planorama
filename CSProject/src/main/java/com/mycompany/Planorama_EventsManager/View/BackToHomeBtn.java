/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_EventsManager.View;

/**
 *
 * @author adupa
 */
import com.mycompany.Planorama_LoginPage.View1.HomePageUI;
import com.mycompany.Planorama_EventsManager.Controller.Controller;
//import com.mycompany.Planorama_EventsManager.View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToHomeBtn implements ActionListener{
    private JFrame current;
    private String username;
    
    public BackToHomeBtn(JFrame frame, String username){
        this.current = frame;
        this.username = username;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        HomePageUI.currentUser = username;
        
        //block of code to open the events manager UI
        JFrame frame = new JFrame("Home");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomePageUI.homeScreen(frame);
        current.dispose();
    }
}
