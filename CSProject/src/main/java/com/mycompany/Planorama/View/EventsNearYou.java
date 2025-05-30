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
