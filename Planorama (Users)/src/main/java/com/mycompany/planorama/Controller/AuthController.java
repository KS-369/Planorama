/**
 * AuthController.java
 * Located at: src/main/java/com/mycompany/planorama/Controller/AuthController.java
 */
package com.mycompany.planorama.Controller;

import com.mycompany.planorama.Model.*;
import com.mycompany.planorama.View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthController {
    private UserModel model;
    private LoginUI view;
    
    public AuthController(UserModel model, LoginUI view) {
        this.model = model;
        this.view = view;

        view.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername().trim();
                String password = view.getPassword().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Please fill out both username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (model.authenticate(username, password)) {
                    Session.setCurrentUsername(username);
                    // Also set username in the EventsManager Session
                    com.mycompany.planorama_EventsManager.Model.Session.setCurrentUsername(username);
                    view.dispose(); // Close login window
                    new LoginSuccessUI("Login successful!");
                } else {
                    view.usernameField.setText("");
                    view.passwordField.setText("");
                    JOptionPane.showMessageDialog(view, "Invalid credentials.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername().trim();
                String password = view.getPassword().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Please fill out both username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (model.register(username, password)) {
                    Session.setCurrentUsername(username);
                    // Also set username in the EventsManager Session
                    com.mycompany.planorama_EventsManager.Model.Session.setCurrentUsername(username);
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
