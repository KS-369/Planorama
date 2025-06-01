/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama.View;

/**
 *
 * 
 */
import com.mycompany.Planorama.View.HomePageUI;
import com.mycompany.Planorama.View.AboutUsUI;
import com.mycompany.Planorama.Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class toAboutUs implements ActionListener{
//    private JFrame current;
    private String username;
    
    //Controller
    public toAboutUs(String username){
//        this.current = frame;
        this.username = username;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        HomePageUI.currentUser = username;
        
        //block of code to open the About Us UI
        JFrame frame = new JFrame("About Us");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AboutUsUI.createAboutUsPage();
//        current.dispose();
    }
}