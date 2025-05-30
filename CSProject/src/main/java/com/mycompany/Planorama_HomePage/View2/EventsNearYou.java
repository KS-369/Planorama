/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_HomePage.View2;

import com.mycompany.Planorama_HomePage.Model2.DBConnector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author adupa
 */
public class EventsNearYou implements ActionListener {
    JFrame frame;

    public EventsNearYou(JFrame theFrame) {

        this.frame = theFrame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        HomePageUI.refreshFrame(frame);

        RSVPView.makeScreen(frame);
    }
}
