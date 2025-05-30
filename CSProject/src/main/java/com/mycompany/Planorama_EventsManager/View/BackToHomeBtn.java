package com.mycompany.Planorama_EventsManager.View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * 
 */
import com.mycompany.Planorama_HomePage.View2.*;
import com.mycompany.Planorama_EventsManager.Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToHomeBtn implements ActionListener{
    private JFrame current;
    
    //Controller
    public BackToHomeBtn(JFrame frame){
        this.current = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        //block of code to open the events manager UI
        JFrame frame = new JFrame("Home");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomePageUI.homeScreen(frame);
        current.dispose();
    }
}
