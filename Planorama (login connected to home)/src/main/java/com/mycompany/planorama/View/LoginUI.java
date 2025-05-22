/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.planorama.View;

/**
 *
 * @author Kalli-Ann
 */

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    public JTextField usernameField = new JTextField(15);
    public JPasswordField passwordField = new JPasswordField(15);
    public JButton loginButton = new JButton("Login");
    public JButton registerButton = new JButton("Register");
    public JLabel messageLabel = new JLabel("");

    /*
     * LoginUI()
     *
     * Input:
     * - None.
     *
     * Output:
     * - A visible GUI window allowing the user to enter a username and password,
     *   and either log in or register via corresponding buttons.
     *
     * Example:
     * - new LoginUI() → Displays a 1200x700 window with login/register form centered on screen.
     */
    
    public LoginUI() {
        setTitle("Login Page");
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // grid bag layout
        gbc.insets = new Insets(10, 10, 10, 10); // spacing around components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(registerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(messageLabel, gbc);

        // Limit component preferred sizes
        usernameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));
        loginButton.setPreferredSize(new Dimension(100, 30));
        registerButton.setPreferredSize(new Dimension(100, 30));

        add(panel);
        setVisible(true);
    }

     /*
     * getUsername()
     *
     * Input: None
     * Output: Returns the text from the username input field
     * Example: If the field contains "admin", getUsername() returns "admin"
     */
    
    public String getUsername() {
        return usernameField.getText();
    }
    
    /*
     * getPassword()
     *
     * Input: None
     * Output: Returns the password entered in the password field as a String
     * Example: If the field contains "abc123", getPassword() returns "abc123"
     */
    
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    /*
     * setMessage(String msg)
     *
     * Input: 
     * - msg: a string message to display in the messageLabel (currently not used)
     * Output: Displays msg in the messageLabel (useful if not using popups)
     * Example: setMessage("Invalid credentials") sets the messageLabel to show that message
     */
    
    public void setMessage(String msg) {
        messageLabel.setText(msg);
    }
}


// GUI Testing Plan

// Test 1: Login with Empty Fields
// Action: Press login with both username and password empty.
// Expected: Popup: “Please fill out both username and password.”

// Test 2: Login with Wrong Credentials
// Action: Enter wrong username/password, press login.
// Expected: Popup: “Invalid credentials.” Inputs should clear.

// Test 3: Successful Login
// Action: Enter correct credentials, press login.
// Expected: Login window closes, “Login successful!” window opens.

// Test 4: Register with Empty Fields
// Action: Press register with both fields empty.
// Expected: Popup: “Please fill out both username and password.”

// Test 5: Register a New User
// Action: Enter new username/password, press register.
// Expected: Registration popup success window.

// Test 6: Register Duplicate User
// Action: Enter same username again, press register.
// Expected: Popup: “Account already exists.”

// Test 7: Resize Window
// Action: Resize main login window.
// Expected: UI remains clear and functional — no element clipping or layout breaks.
