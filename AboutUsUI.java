/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planorama.View;

/**
 *
 * @author Kalli-Ann
 */

import javax.swing.*;
import java.awt.*;

public class AboutUsUI {
    
    /*
     * createAboutUsPage()
     *
     * #Input:
     * - None
     *
     * #Output:
     * - Displays a JFrame window showing the "About Us" information for Planorama.
     * - Includes a scrollable text area with descriptive content.
     *
     * #Example:
     * - When the user clicks "About Us" from the main UI, this function is called.
     * - A new window titled "About Us - Planorama" opens with formatted text about the app.
     */
    
    public static void createAboutUsPage() {
        JFrame frame = new JFrame();
        frame.setTitle("About Us - Planorama");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // create a layered pane to add the sidebar and content together
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 700));
       

        // create a content panel for the About Us info
        JPanel aboutContent = new JPanel();
        aboutContent.setLayout(new BorderLayout());
        aboutContent.setBounds(300, 0, 880, 700); // leave room for sidebar on the left

        JLabel titleLabel = new JLabel("About Planorama", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        aboutContent.add(titleLabel, BorderLayout.NORTH);

        JTextArea contentArea = new JTextArea();
        contentArea.setEditable(false);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        contentArea.setText(
            "Welcome to Planorama, your all-in-one solution for seamless event planning and coordination.\n\n" +
            "Our mission is to simplify the event experience for both hosts and guests. Whether you're planning a wedding, a business seminar, or a casual get-together, Planorama gives you the tools to create, manage, and RSVP to events with ease.\n\n" +
            "We built Planorama to bridge the communication gap that often causes confusion between planners, hosts, and attendees. With a clear, intuitive interface and powerful features, our platform ensures your event runs smoothly from start to finish.\n\n" +
            "What you’ll find in Planorama:\n" +
            "• A dashboard to view and discover upcoming events by region\n" +
            "• Event tools for creating, editing, and deleting your events\n" +
            "• RSVP functionality for easy guest coordination\n\n" +
            "With Planorama, planning is no longer a chore, it’s a streamlined experience designed to keep you in control, informed, and stress-free. Let us help you bring your events to life!"
        );

        JScrollPane scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        aboutContent.add(scrollPane, BorderLayout.CENTER);

        //add the about content panel to the layered pane
        layeredPane.add(aboutContent, Integer.valueOf(0));

        frame.setContentPane(layeredPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAboutUsPage();
    }
}


// GUI Testing Plan

// Test 1: Window appears with correct title and size (1200x700)
// Test 2: Content panel is scrollable and fully populated with wrapped text
// Test 3: Title label is centered, styled correctly, and not cut off
// Test 4: Layered pane correctly adds the about content without overlap
