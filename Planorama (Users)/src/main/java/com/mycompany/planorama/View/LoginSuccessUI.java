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

public class LoginSuccessUI extends JFrame {
    
     /*
     * LoginSuccessUI(String message)
     * 
     * Input:
     * - message: A string to be displayed in the center of the success window.
     * 
     * Output:
     * - Displays a simple pop-up JFrame window with a message (e.g., "Login successful!" or "Successfully registered!")
     * - Uses a bold font in a centered JLabel.
     *
     * Example:
     * - new LoginSuccessUI("Successfully registered!") → displays a centered success message in a window.
     */
    
    public LoginSuccessUI(String message) {
        setTitle("Success");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));

        add(label);
        setVisible(true);
    }
}
