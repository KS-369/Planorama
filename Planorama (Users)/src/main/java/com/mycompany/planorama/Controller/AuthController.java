/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planorama.Controller;

/**
 *
 * @author Kalli-Ann
 */


// To Do:

// Later stuff:
// 1. Store events person is attending in their account - store an arraylist of events people are attending
// 2. Resize components in screen so that they are a bit larger?
// 3. Add logo/other graphics?
// 4. Replace successful login page with home page

import com.mycompany.planorama.Model.*;
import com.mycompany.planorama.View.*;


import javax.swing.*;
import java.awt.*; // don't need this probably
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthController {
    private UserModel model;
    private LoginUI view;
    
    /* 
     * AuthController(UserModel model, LoginUI view)
     *
     * Inputs:
     * - model: The UserModel that handles authentication logic and user data.
     * - view: The LoginUI interface where users input their credentials.
     *
     * Output:
     * - Initializes the login and register button handlers.
     * - Based on the outcome, displays appropriate message popups and may open a success page.
     *
     * Example:
     * - If a user enters valid login info → success popup and transition to login success UI.
     * - If registration info is valid and unique → success popup and transition to success UI.
     */
    
    public AuthController(UserModel model, LoginUI view) {
        this.model = model;
        this.view = view;

        view.loginButton.addActionListener(new ActionListener() {
            
            /*
             * loginButton ActionListener
             *
             * Inputs:
             * - Username and password strings from GUI input fields.
             *
             * Output:
             * - If empty: shows input error popup.
             * - If correct credentials: closes login window and shows login success UI.
             * - If incorrect: clears fields and shows error popup.
             *
             * Example:
             * - Username: "alice", Password: "123" → success if credentials are valid.
             */
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername().trim();
                String password = view.getPassword().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Please fill out both username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (model.authenticate(username, password)) {
                    view.dispose(); // Close login window
                    new LoginSuccessUI("Login successfull!");
                } else {
                    view.usernameField.setText("");
                    view.passwordField.setText("");
                    JOptionPane.showMessageDialog(view, "Invalid credentials.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        });

        view.registerButton.addActionListener(new ActionListener() {
            
             /*
             * registerButton ActionListener
             *
             * Inputs:
             * - Username and password strings from GUI input fields.
             *
             * Output:
             * - If empty: shows input error popup.
             * - If username is unique: registers user and shows registration success popup.
             * - If username already exists: shows error and clears fields.
             *
             * Example:
             * - Username: "newuser", Password: "pass123" → success if not taken.
             */
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername().trim();
                String password = view.getPassword().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Please fill out both username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (model.register(username, password)) {
                    view.dispose(); // Close login window
                    new LoginSuccessUI("Successfully registered!");
                } else {
                    view.usernameField.setText("");
                    view.passwordField.setText("");
                    JOptionPane.showMessageDialog(view, "Account already exists. Please choose a different username or log in.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }

    
}
